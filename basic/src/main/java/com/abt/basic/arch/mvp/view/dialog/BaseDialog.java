package com.abt.basic.arch.mvp.view.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.orhanobut.logger.Logger;

/**
 * @描述： @弹出框基类
 * @作者： @黄卫旗
 * @创建时间： @21/05/2018
 */
@SuppressLint("ValidFragment")
public abstract class BaseDialog extends DialogFragment implements IDialogView {
    public static final String TAG = "DIALOG_FRAGMENT";

    private int mLayoutId;
    private int mVariableId;
    //private VM mViewModel;
    private boolean mShowVisible = false;

    public BaseDialog() { }

    @SuppressLint("ValidFragment")
    public BaseDialog(int style, int theme, int layoutId, int variableId) {
        setStyle(style, theme);
        mLayoutId = layoutId;
        mVariableId = variableId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // 临时解决方案，重新创建时直接destroy掉
        if (this.mLayoutId == 0) {
            dismiss();
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * 显示对话框
     */
    public final void show(FragmentManager fragmentManager) {
        try {
            if (!mShowVisible) {
                show(fragmentManager, TAG);
                mShowVisible = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mShowVisible = false;
        }
    }

    @Override
    public void hideDialog() {
        if (mShowVisible) {
            dismiss();
            mShowVisible = false;
        }
    }
}
