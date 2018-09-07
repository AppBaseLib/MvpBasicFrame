package com.abt.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.abt.basic.app.BaseApp;
import com.abt.basic.utils.ToastUtil;
import com.abt.mvp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 黄卫旗
 * @description MainActivity
 * @time 2018/09/07
 */
public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.button) void click(Button button) {
        button.setText(R.string.app_name);
        ToastUtil.show("click");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public static void startActivity() {
        Intent intent = new Intent(BaseApp.getAppContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        BaseApp.getAppContext().startActivity(intent);
    }
}
