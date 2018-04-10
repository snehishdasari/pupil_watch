package com.example.android.pupil_watch;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rashed on 25-03-2018.
 */

public class AnnouncementAdapter extends ArrayAdapter<Announcement> {

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View AnnouncementView = convertView;

        if(AnnouncementView==null){
            AnnouncementView = LayoutInflater.from(getContext()).inflate(R.layout.data_announcement,parent,false);
        }

        Announcement announcement = getItem(position);

        TextView title = AnnouncementView.findViewById(R.id.announcement_title);
        title.setText(announcement.getmTitle());

        TextView classes = AnnouncementView.findViewById(R.id.announcement_classes);
        classes.setText(announcement.getmClasses());

        TextView time = AnnouncementView.findViewById(R.id.announcement_time);
        time.setText(announcement.getmTime());

        TextView description = AnnouncementView.findViewById(R.id.announcement_description);
        description.setText(announcement.getmDescription());

        return AnnouncementView;
    }

    public AnnouncementAdapter(Activity context, ArrayList<Announcement> announcements){
        super(context,0,announcements);
    }
}
