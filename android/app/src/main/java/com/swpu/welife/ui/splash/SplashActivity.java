package com.swpu.welife.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.support.annotation.NonNull;
import android.view.View;

import com.swpu.welife.base.BaseActivity;
import com.swpu.welife.ui.home.HomeActivity;
import com.swpu.welife.ui.sign.LoginActivity;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see SplashActivity
 * @since 2018/12/3
 */
public class SplashActivity extends BaseActivity implements Runnable{

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final long DEFAULT_DURATION = 2000;

    private Handler mHandler = new Handler();
    private boolean mIsTokenAvailable;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN //hide statusBar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION; //hide navigationBar
        getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void run() {
        if (mIsTokenAvailable) {
            HomeActivity.startActivity(this);
        } else {
            LoginActivity.startActivity(this);
        }
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mHandler != null) {
            mHandler.removeCallbacks(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(this, 2000);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
