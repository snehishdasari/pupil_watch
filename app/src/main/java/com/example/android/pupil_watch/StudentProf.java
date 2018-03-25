package com.example.android.pupil_watch;

/**
 * Created by Aghamarsh on 25-03-18.
 */

public class StudentProf {

    private int [] img_id;
    private String Std_name;
    private String cls;

    StudentProf(int[] img,String name,String cl)
    {
        img_id=img;
        Std_name=name;
        cls=cl;
    }

    int[] getImg_id(){
        return img_id;
    }
    String getStd_name(){
        return Std_name;
    }
    String getCls(){
        return cls;
    }
}
