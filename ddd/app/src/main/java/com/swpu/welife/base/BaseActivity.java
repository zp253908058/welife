package com.swpu.welife.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.swpu.welife.app.AppManager;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see BaseActivity
 * @since 2018/12/3
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Activity的堆栈管理
     */
    private AppManager mAppManager;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppManager = AppManager.getInstance();
        mAppManager.push(this);
    }

    @Override
    protected void onDestroy() {
        mAppManager.remove(this);
        super.onDestroy();
    }

    /**
     * 获取ActivityStackManager
     *
     * @return AppManager
     */
    public AppManager getAppManager() {
        return mAppManager;
    }

    /**
     * 获取上下文
     *
     * @return Context
     */
    public Context getContext() {
        return this;
    }
}
