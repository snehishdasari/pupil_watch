package com.example.android.pupil_watch;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoaderManager.LoaderCallbacks<List<Student>> {

    public static final String LOG_TAG = StudentListActivity.class.getName();

    private static final String STUDENT_LIST_URL = "http://ec2-13-127-179-218.ap-south-1.compute.amazonaws.com:8080/school/getStudentDetailsByPhoneNumber";

    private static final int STUDENT_LIST_LOADER_ID = 0;

    private StudentAdapter mAdapter;

    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);

        ListView listView = (ListView) findViewById(R.id.student_list);

        mAdapter = new StudentAdapter(this, new ArrayList<Student>());

        listView.setAdapter(mAdapter);
        listView.setEmptyView(mEmptyStateTextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = mAdapter.getItem(position);
                StudentProfileActivity.studentName = student.getmStudentName();
                StudentProfileActivity.studentClass = student.getmStudentClass();
                StudentProfileActivity.studentImage = student.getmStudentImage();

                Intent i = new Intent(getApplicationContext(), StudentProfileActivity.class);
                startActivity(i);
            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isConnected()){
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(STUDENT_LIST_LOADER_ID, null, this);
        }
        else{
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
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

    @Override
    public Loader<List<Student>> onCreateLoader(int i, Bundle bundle) {

        Uri baseUri = Uri.parse(STUDENT_LIST_URL);
        Uri.Builder builder = baseUri.buildUpon();

        builder.appendQueryParameter("phoneNumber","9881144698");

        return new StudentListLoader(this,builder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Student>> loader, List<Student> students) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_students);

        mAdapter.clear();

        if (students != null && !students.isEmpty()) {
            mAdapter.addAll(students);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Student>> loader) {
        mAdapter.clear();
    }
}
