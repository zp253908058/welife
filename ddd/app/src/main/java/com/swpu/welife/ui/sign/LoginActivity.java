package com.swpu.welife.ui.sign;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.swpu.welife.R;
import com.swpu.welife.base.ToolbarActivity;
import com.swpu.welife.ui.home.HomeActivity;
import com.swpu.welife.util.StringUtils;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Class description:
 * 登录页面
 *
 * @author zp
 * @version 1.0
 * @see LoginActivity
 * @since 2018/12/3
 */
public class LoginActivity extends ToolbarActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }

    private EditText mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        initView();
    }

    private void initView() {
        mUsernameView = findViewById(R.id.login_username);
        mPasswordView = findViewById(R.id.login_password);
    }

    /**
     * 登录点击事件
     */
    public void onLogin(View view) {
        attemptLogin();
    }

    /**
     * 登录
     */
    private void attemptLogin() {

        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (TextUtils.isEmpty(username)) {
            mUsernameView.setError(getString(R.string.error_null_username));
            mUsernameView.requestFocus();
            return;
        }

        if (StringUtils.length(password) < 6) {
            mPasswordView.setError(getString(R.string.error_short_password));
            mPasswordView.requestFocus();
            return;
        }


    }

    /**
     * 注册点击事件
     */
    public void onRegister(View view) {
        RegisterActivity.startActivity(this);
    }


}

