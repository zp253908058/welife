package com.swpu.welife.ui.home;

import android.content.Context;
import android.content.Intent;

import com.swpu.welife.base.ToolbarActivity;

/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see HomeActivity
 * @since 2018/12/3
 */
public class HomeActivity extends ToolbarActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, HomeActivity.class);
        context.startActivity(intent);
    }
}
