package com.sxqsachin.pers.ldlimbs.ui;

import android.util.TypedValue;

import com.sxqsachin.pers.ldlimbs.LDLimbs;
import com.sxqsachin.pers.ldlimbs.R;

/**
 *
 * LDLimbsUI
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class LDLimbsUI {
    private static int  colorPrimary = 0;
    private static int  colorPrimaryDark = 0;
    private static int  colorAccent = 0;

    private static TypedValue typedValue = new TypedValue();

    public static int   getThemeColorPrimary() {
        LDLimbs.getApplication().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        colorPrimary = typedValue.data;

        return colorPrimary;
    }

    public static int   getThemeColorPrimaryDark() {
        LDLimbs.getApplication().getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        colorPrimaryDark = typedValue.data;

        return colorPrimaryDark;
    }

    public static int   getThemeColorAccent() {
        LDLimbs.getApplication().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        colorAccent = typedValue.data;

        return colorAccent;
    }
}
