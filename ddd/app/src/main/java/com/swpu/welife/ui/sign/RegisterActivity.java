package com.swpu.welife.ui.sign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.swpu.welife.R;
import com.swpu.welife.base.ToolbarActivity;
import com.swpu.welife.util.StringUtils;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see RegisterActivity
 * @since 2018/12/10
 */
public class RegisterActivity extends ToolbarActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    private EditText mUsernameView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);

        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mUsernameView = findViewById(R.id.register_username);
        mPasswordView = findViewById(R.id.register_password);
        mConfirmPasswordView = findViewById(R.id.register_confirm_password);
    }

    /**
     * 注册点击事件
     */
    public void onRegister(View view) {
        attemptRegister();
    }

    /**
     * 注册逻辑
     */
    private void attemptRegister() {
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();
        String confirmPassword = mConfirmPasswordView.getText().toString();

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

        if (!StringUtils.equals(password, confirmPassword)) {
            mConfirmPasswordView.setError(getString(R.string.error_diff_password));
            mConfirmPasswordView.requestFocus();
            return;
        }
    }
}
