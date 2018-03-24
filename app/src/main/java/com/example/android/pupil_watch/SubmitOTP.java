package com.example.android.pupil_watch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubmitOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_otp);
    }

    public void gotokidDetails(View v)
    {
        Intent i3 = new Intent(this,kidDetails.class) ;
        startActivity(i3);
    }
}
