package com.example.android.pupil_watch;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashed on 10-04-2018.
 */

public class StudentListLoader extends AsyncTaskLoader<List<Student>> {

    private String mUrl;

    public StudentListLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Student> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Student> students = QueryUtils.fetchStudentData(mUrl);
        return students;
    }
}
