package com.example.android.pupil_watch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
        announcementList.add(new Announcement("Dance Contest","6 to 8 ","2 - 3 PM","Lets Dance"));
        announcementList.add(new Announcement("School Anniversary Celebrations","1 to 10 ","1 - 4 PM","Celebrations Time"));

        AnnouncementAdapter announcements = new AnnouncementAdapter(this,announcementList);
        ListView listView = (ListView) findViewById(R.id.announcement_list);
        listView.setAdapter(announcements);
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
