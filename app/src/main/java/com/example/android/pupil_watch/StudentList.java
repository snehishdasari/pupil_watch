package com.example.android.pupil_watch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        ListView listView = (ListView) findViewById(R.id.student_list);
        final ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(R.mipmap.ic_person_black_48dp,"Aghamarsh","BE 2/4"));
        studentList.add(new Student(R.mipmap.ic_person_black_48dp,"Snehish","BE 2/4"));

        StudentAdapter studentAdapter = new StudentAdapter(this,studentList);

        listView.setAdapter(studentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);
                StudentProfile.studentName = student.getmStudentName();
                StudentProfile.studentClass = student.getmStudentClass();
                StudentProfile.studentImage = student.getmStudentImage();

                Intent i = new Intent(getApplicationContext(),StudentProfile.class);
                startActivity(i);
            }
        });
    }
}
