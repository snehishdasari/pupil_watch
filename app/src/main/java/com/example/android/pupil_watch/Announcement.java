package com.example.android.pupil_watch;

/**
 * Created by Rashed on 25-03-2018.
 */

public class Announcement {
    private String mTitle;
    private String mClasses;
    private String mTime;
    private String mDescription;

    public Announcement(String title, String classes, String time, String description){
        mTitle = title;
        mClasses = classes;
        mTime = time;
        mDescription = description;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmClasses() {
        return mClasses;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmDescription() {
        return mDescription;
    }
}
