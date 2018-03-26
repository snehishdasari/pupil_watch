package com.example.android.pupil_watch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aghamarsh on 25-03-18.
 */

public class StudentAdapter extends ArrayAdapter<Student>{

    public StudentAdapter(Context context, ArrayList<Student> list){
        super(context,0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View studentDetailsView = convertView;

        if(studentDetailsView == null){
            studentDetailsView = LayoutInflater.from(getContext()).inflate(R.layout.student_details,parent,false);
        }

        Student student = getItem(position);

        ImageView imageView = (ImageView) studentDetailsView.findViewById(R.id.student_profile_pic);
        imageView.setImageResource(student.getmStudentImage());

        TextView name = (TextView) studentDetailsView.findViewById(R.id.student_name);
        name.setText(student.getmStudentName());

        TextView classView = (TextView) studentDetailsView.findViewById(R.id.student_class);
        classView.setText(student.getmStudentClass());

        return studentDetailsView;
    }
}
