package com.example.android.pupil_watch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String studentName = new String();
    public static String studentClass = new String();
    public static int studentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView nameView = (TextView) findViewById(R.id.student_name);
        nameView.setText(studentName);

        TextView classView = (TextView) findViewById(R.id.student_class);
        classView.setText(studentClass);

        ImageView imageView = (ImageView) findViewById(R.id.student_profile_pic);
        imageView.setImageResource(studentImage);

        final ArrayList<DashboardItem> list = new ArrayList<DashboardItem>();
        list.add(new DashboardItem("My Profile", R.mipmap.ic_person_black_48dp, new Intent(this, MyProfileActivity.class)));
        list.add(new DashboardItem("Announcements", R.mipmap.ic_person_black_48dp, new Intent(this, AnnouncementActivity.class)));
        list.add(new DashboardItem("Attendance", R.mipmap.ic_person_black_48dp));
        list.add(new DashboardItem("Exam Results", R.mipmap.ic_person_black_48dp));
        list.add(new DashboardItem("Remarks", R.mipmap.ic_person_black_48dp));
        list.add(new DashboardItem("Exam Schedule", R.mipmap.ic_person_black_48dp));
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_parents_profile) {
            startActivity(new Intent(getApplicationContext(),ParentProfileActivity.class));
        } else if (id == R.id.nav_feedback) {
            startActivity(new Intent(getApplicationContext(),FeedbackActivity.class));
        } else if (id == R.id.nav_about_us) {
            startActivity(new Intent(getApplicationContext(),AboutUsActivity.class));
        } else if (id == R.id.nav_contact_us) {
            startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
        } else if (id == R.id.nav_faq) {

        } else if (id == R.id.nav_policy_terms) {

        } else if (id == R.id.nav_logout){
            startActivity(new Intent(getApplicationContext(),StudentListActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
