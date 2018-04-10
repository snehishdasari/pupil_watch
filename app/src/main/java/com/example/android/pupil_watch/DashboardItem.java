package com.example.android.pupil_watch;

import android.content.Intent;

/**
 * Created by Rashed on 26-03-2018.
 */

public class DashboardItem {

    private String mTitle;
    private int mImage;
    private Intent mIntent;

    public DashboardItem(String title, int image){
        mTitle = title;
        mImage = image;
        mIntent = null;
    }

    public DashboardItem(String title, int image, Intent intent){
        mTitle = title;
        mImage = image;
        mIntent = intent;
    }

    public Intent getmIntent() {
        return mIntent;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getmImage() {
        return mImage;
    }
}
