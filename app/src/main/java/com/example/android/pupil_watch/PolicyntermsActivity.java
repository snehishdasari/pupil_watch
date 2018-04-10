package com.example.android.pupil_watch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PolicyntermsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policynterms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ListView pnt = (ListView) findViewById(R.id.PolicyTerms);
        ArrayList<String> pt = new ArrayList<String>();
        pt.add("1.this is an important policy");


        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, R.layout.data_policynterms, pt);
        pnt.setAdapter(adap);
        pnt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itempos = position;
                String itemval = (String) pnt.getItemAtPosition(itempos);
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
            startActivity(new Intent(getApplicationContext(),FaqActivity.class));
        } else if (id == R.id.nav_policy_terms) {

        } else if (id == R.id.nav_logout){
            startActivity(new Intent(getApplicationContext(),StudentListActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
