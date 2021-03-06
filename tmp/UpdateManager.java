package com.abt.common.update;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.abt.common.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class UpdateManager {
    private static final String XMLURL_ALI = "http://112.74.67.115:1080/sdk/version.xml";
    private static final String XMLURL_MIE = "http://124.251.36.41:1080/sdk/version.xml";

    /* 下载中 */
    private static final int DOWNLOAD = 1;
    /* 下载结束 */
    private static final int DOWNLOAD_FINISH = 2;
    /* 需要升级 */
    private static final int UPDATE = 3;
    /* 不需要升级 */
    private static final int UNUPDATE = 4;
    /* 保存解析的XML信息 */
    private HashMap<String, String> mHashMap;
    /* 下载保存路径 */
    private String mSavePath;
    /* 记录进度条数量 */
    private int progress;
    /* 是否取消更新 */
    private boolean cancelUpdate = false;

    private static String log = "";
    private static String url = "";

    private Context mContext;
    /* 更新进度条 */
    private ProgressBar mProgress;
    private UpdateDownLoadDialog mDownloadDialog;
    private UpdateCancelCallback listener;
    private static boolean isLastestVersion = true;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                // 正在下载
                case DOWNLOAD:
                    // 设置进度条位置
                    mProgress.setProgress(progress);
                    break;
                case DOWNLOAD_FINISH:
                    // 安装文件
                    installApk();
                    break;
                case UPDATE:
                    showNoticeDialog();
                    break;
                case UNUPDATE:
                    // Toast.makeText(mContext, R.string.soft_update_no,
                    // Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }

        ;
    };

    public UpdateManager(Context context) {
        this.mContext = context;
    }

    /**
     * 检查软件是否有更新版本
     * @return
     */
    public void checkUpdate() {
        // 获取当前软件版本
        // 把version.xml放到网络上，然后获取文件信息
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHashMap = null;
                int versionCode = getVersionCode(mContext);
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(XMLURL_ALI)
                            .openConnection();
                    conn.connect();
                    InputStream inStream = conn.getInputStream();
                    // 解析XML文件。 由于XML文件比较小，因此使用DOM方式进行解析
                    ParseXmlService service = new ParseXmlService();
                    mHashMap = service.parseXml(inStream);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != mHashMap) {
                        String log = mHashMap.get("log");
                        if (log != null && log.length() != 0) {
                            UpdateManager.log = log;
                        }
                        String url = mHashMap.get("url");
                        if (url != null && url.length() != 0) {
                            UpdateManager.url = url;
                        }
                        if (mHashMap.get("version") != null) {
                            int serviceCode = Integer.valueOf(mHashMap.get("version"));
                            // 版本判断
                            if (serviceCode > versionCode) {
                                mHandler.sendEmptyMessage(UPDATE);
                            } else {
                                mHandler.sendEmptyMessage(UNUPDATE);
                            }
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    public int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void showNoticeDialog() {
//		CustomDialog customDialog = new CustomDialog(mContext, log, mContext
//				.getResources().getString(R.string.soft_update_updatebtn),
//				mContext.getResources().getString(R.string.soft_update_later));
        CustomViewDialog customDialog = new CustomViewDialog(mContext,
                "主要更新", mContext.getResources().getString(R.string.soft_update_updatebtn),
                mContext.getResources().getString(R.string.soft_update_later));
        TextView tv = new TextView(mContext);
        tv.setText(log);
        customDialog.show();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        customDialog.setCancelable(false);
        customDialog.addView((View) tv, lp);
        customDialog.setClicklistener(new OnClickDescribeListener() {
            @Override
            public void doConfirm() {
                // customDialog.dismiss();
                // 显示下载对话框
                showDownloadDialog();
                isLastestVersion = true;
                if (listener != null)
                    listener.doUpdateCommit();
            }

            @Override
            public void doCancel() {
                isLastestVersion = false;
                if (listener != null)
                    listener.doUpdateCancel();
            }
        });

    }

    /**
     * 显示软件下载对话框
     */
    private void showDownloadDialog() {
        mDownloadDialog = new UpdateDownLoadDialog(mContext, mContext
                .getResources().getString(R.string.soft_update_cancel));
        mDownloadDialog.setCancelable(false);
        mDownloadDialog.show();
        mDownloadDialog
                .setClicklistener(new UpdateDownLoadDialog.ClickListenerInterface() {
                    @Override
                    public void doCancel() {
                        cancelUpdate = true;
                        isLastestVersion = false;
                    }
                });

        mProgress = mDownloadDialog.getProgressView();
        // 现在文件
        downloadApk();
    }

    /**
     * 下载apk文件
     */
    private void downloadApk() {
        // 启动新线程下载软件
        new downloadApkThread().start();
    }

    /**
     * 下载文件线程
     */
    private class downloadApkThread extends Thread {
        @Override
        public void run() {
            try {
                // 判断SD卡是否存在，并且是否具有读写权限
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    // 获得存储卡的路径
                    String sdpath = Environment.getExternalStorageDirectory()
                            + "/";
                    mSavePath = sdpath + "download";
                    URL url = new URL(mHashMap.get("url"));
                    // 创建连接
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.connect();
                    // 获取文件大小
                    int length = conn.getContentLength();
                    // 创建输入流
                    InputStream is = conn.getInputStream();

                    File file = new File(mSavePath);
                    // 判断文件目录是否存在
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File apkFile = new File(mSavePath, mHashMap.get("name"));
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    // 缓存
                    byte buf[] = new byte[1024];
                    // 写入到文件中
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        // 计算进度条位置
                        progress = (int) (((float) count / length) * 100);
                        // 更新进度
                        mHandler.sendEmptyMessage(DOWNLOAD);
                        if (numread <= 0) {
                            // 下载完成
                            mHandler.sendEmptyMessage(DOWNLOAD_FINISH);
                            break;
                        }
                        // 写入文件
                        fos.write(buf, 0, numread);
                    } while (!cancelUpdate);// 点击取消就停止下载.
                    fos.close();
                    is.close();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 取消下载对话框显示
            if (mDownloadDialog != null && mDownloadDialog.isShowing()) {
                mDownloadDialog.dismiss();
            }

        }
    }

    /**
     * 安装APK文件
     */
    private void installApk() {
        File apkfile = new File(mSavePath, mHashMap.get("name"));
        if (!apkfile.exists()) {
            return;
        }
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()),
                "application/vnd.android.package-archive");
        mContext.startActivity(i);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static boolean getVersionJudgeResult() {
        return isLastestVersion;
    }

    public static String getDownloadUrl() {
        return url;
    }

    public void setOnUpdateCancelCallback(UpdateCancelCallback listener) {
        this.listener = listener;
    }

}
