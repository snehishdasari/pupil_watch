package com.example.android.pupil_watch;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.android.pupil_watch.StudentListActivity.LOG_TAG;

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
        List<Student> students = fetchStudentData(mUrl);
        return students;
    }

    private List<Student> fetchStudentData(String requestUrl){
        URL url = QueryUtils.createUrl(requestUrl, LOG_TAG);

        String jsonResponse = null;
        try {
            jsonResponse = QueryUtils.makeHttpRequest(url, LOG_TAG);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Student> students = extractStudentsFromJson(jsonResponse);

        return students;
    }

    private List<Student> extractStudentsFromJson(String studentJson){

        if (TextUtils.isEmpty(studentJson)) {
            return null;
        }

        List<Student> students = new ArrayList<>();

        try{
            JSONObject baseJsonResponse = new JSONObject(studentJson);

            String name = baseJsonResponse.getString("studentName");
            String standard = baseJsonResponse.getString("standard");
            String section = baseJsonResponse.getString("section");

            String cl = standard.charAt(0) + "-"+ section;

            Student student = new Student(R.mipmap.ic_person_black_48dp,name,cl);
            students.add(student);
        }
        catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return  students;
    }
}
