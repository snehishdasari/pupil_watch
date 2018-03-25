package com.example.android.pupil_watch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        TextView t1=new TextView(this) ;
        TextView t2=new TextView(this) ;
        TextView t3=new TextView(this) ;
        TextView t4=new TextView(this) ;
        TextView t5=new TextView(this) ;
        TextView t6=new TextView(this) ;
        TextView t7=new TextView(this) ;
        TextView t8=new TextView(this) ;
        TextView t9=new TextView(this) ;
        TextView t10=new TextView(this) ;
        TextView t11=new TextView(this) ;
        t1.setText("my profile");
        t2.setText("Announcements");
        t3.setText("Attendance");
        t4.setText("Exam Results");
        t5.setText("Remarks");
        t6.setText("Exam Schedule");
        t7.setText("Assignments/Home work");
        t8.setText("Fees");
        t9.setText("TimeTable");
        GridView gv=(GridView)findViewById(R.id.grid) ;
        ArrayList<String> list = new ArrayList<String>();

        gv.addView(t2);
        gv.addView(t3);
        gv.addView(t4);
        gv.addView(t5);
        gv.addView(t6);
        gv.addView(t7);
        gv.addView(t8);
        gv.addView(t9);
    }

}
