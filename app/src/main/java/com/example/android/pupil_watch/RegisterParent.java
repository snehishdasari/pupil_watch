package com.example.android.pupil_watch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterParent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parent);
    }
    public void submitotp(View v)
    {
        Intent i2=new Intent(this,SubmitOTP.class) ;
        startActivity(i2);
    }
}
