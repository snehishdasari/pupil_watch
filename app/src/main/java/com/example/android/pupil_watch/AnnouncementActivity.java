package com.example.android.pupil_watch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
        announcementList.add(new Announcement("Dance Contest","6 to 8 ","2 - 3 PM","Lets Dance"));
        announcementList.add(new Announcement("School Anniversary Celebrations","1 to 10 ","1 - 4 PM","Celebrations Time"));

        AnnouncementAdapter announcements = new AnnouncementAdapter(this,announcementList);
        ListView listView = (ListView) findViewById(R.id.announcement_list);
        listView.setAdapter(announcements);
    }
}
