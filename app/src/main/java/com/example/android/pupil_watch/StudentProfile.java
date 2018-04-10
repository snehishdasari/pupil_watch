package com.example.android.pupil_watch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class
StudentProfile extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    public static String studentName = new String();
    public static String studentClass = new String();
    public static int studentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        TextView nameView = (TextView) findViewById(R.id.student_name);
        nameView.setText(studentName);

        TextView classView = (TextView) findViewById(R.id.student_class);
        classView.setText(studentClass);

        ImageView imageView = (ImageView) findViewById(R.id.student_profile_pic);
        imageView.setImageResource(studentImage);

        final ArrayList<DashboardItem> list = new ArrayList<DashboardItem>();
        list.add(new DashboardItem("My Profile", R.mipmap.ic_person_black_48dp, new Intent(this, MyProfileActivity.class)));
        list.add(new DashboardItem("Announcements", R.mipmap.ic_person_black_48dp, new Intent(this, AnnouncementActivity.class)));
        list.add(new DashboardItem("Attendance", R.mipmap.ic_person_black_48dp, new Intent(this, ParentProfile.class)));
        list.add(new DashboardItem("Exam Results", R.mipmap.ic_person_black_48dp, new Intent(this, Feedback.class)));
        list.add(new DashboardItem("Remarks", R.mipmap.ic_person_black_48dp, new Intent(this, AboutUs.class)));
        list.add(new DashboardItem("Exam Schedule", R.mipmap.ic_person_black_48dp, new Intent(this, ContactUs.class)));
        list.add(new DashboardItem("Assignments/ Home Works", R.mipmap.ic_person_black_48dp));
        list.add(new DashboardItem("Fees", R.mipmap.ic_person_black_48dp));
        list.add(new DashboardItem("Time Table", R.mipmap.ic_person_black_48dp));


        GridView dashboardView = (GridView) findViewById(R.id.dashboard_grid);
        dashboardView.setAdapter(new DashboardAdapter(this, list));

        dashboardView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DashboardItem dashboardItem = list.get(position);

                Intent intent = dashboardItem.getmIntent();
                if (intent == null) {
                } else {
                    startActivity(intent);
                }
            }
        });

    }

}
