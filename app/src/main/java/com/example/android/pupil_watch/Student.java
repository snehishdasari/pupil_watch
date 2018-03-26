package com.example.android.pupil_watch;

/**
 * Created by Aghamarsh on 25-03-18.
 */

public class Student {

    private int mStudentImage;
    private String mStudentName;
    private String mStudentClass;

    Student(int img,String name,String cl)
    {
        mStudentImage = img;
        mStudentName = name;
        mStudentClass = cl;
    }

    public int getmStudentImage() {
        return mStudentImage;
    }

    public String getmStudentName() {
        return mStudentName;
    }

    public String getmStudentClass() {
        return mStudentClass;
    }
}
