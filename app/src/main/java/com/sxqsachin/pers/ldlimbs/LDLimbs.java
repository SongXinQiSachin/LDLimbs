package com.sxqsachin.pers.ldlimbs;

import android.app.Application;

/**
 *
 * LDLimbs
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class LDLimbs extends Application {
    private static LDLimbs  instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static LDLimbs getApplication() {
        return instance;
    }
}
