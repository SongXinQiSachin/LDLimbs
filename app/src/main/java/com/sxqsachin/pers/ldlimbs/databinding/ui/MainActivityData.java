package com.sxqsachin.pers.ldlimbs.databinding.ui;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sxqsachin.pers.ldlimbs.BR;

/**
 *
 * MainActivityData
 *
 * Created by SxqSachin on 2017/3/8.
 */

public class MainActivityData extends BaseObservable {
    private String  toolbarTitle = "";
    private int     toolbarBackgroundColor = 0;
    private int     toolbarTitleColor = 0;

    public MainActivityData() {
    }

    @Bindable
    public String getToolbarTitle() {
        return toolbarTitle;
    }

    public void setToolbarTitle(String toolbarTitle) {
        this.toolbarTitle = toolbarTitle;
        notifyPropertyChanged(BR.toolbarTitle);
    }

    @Bindable
    public int getToolbarBackgroundColor() {
        return toolbarBackgroundColor;
    }

    public void setToolbarBackgroundColor(int toolbarBackgroundColor) {
        this.toolbarBackgroundColor = toolbarBackgroundColor;
        notifyPropertyChanged(BR.toolbarBackgroundColor);
    }

    @Bindable
    public int getToolbarTitleColor() {
        return toolbarTitleColor;
    }

    public void setToolbarTitleColor(int toolbarTitleColor) {
        this.toolbarTitleColor = toolbarTitleColor;
        notifyPropertyChanged(BR.toolbarTitleColor);
    }
}

