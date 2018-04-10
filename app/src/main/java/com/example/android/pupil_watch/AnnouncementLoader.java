package com.example.android.pupil_watch;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.android.pupil_watch.AnnouncementActivity.*;

/**
 * Created by Rashed on 10-04-2018.
 */

public class AnnouncementLoader extends AsyncTaskLoader<List<Announcement>> {

    private String mUrl;

    public AnnouncementLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Announcement> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Announcement> announcements = fetchAnnouncementData(mUrl);
        return announcements;
    }

    private List<Announcement> fetchAnnouncementData(String requestUrl){
        URL url = QueryUtils.createUrl(requestUrl, LOG_TAG);

        String jsonResponse = null;
        try {
            jsonResponse = QueryUtils.makeHttpRequest(url, LOG_TAG);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Announcement> announcements = extractAnnouncementsFromJson(jsonResponse);

        return announcements;
    }

    private List<Announcement> extractAnnouncementsFromJson(String announcementJson){
        if (TextUtils.isEmpty(announcementJson)) {
            return null;
        }

        List<Announcement> announcements = new ArrayList<>();

        try{
            JSONObject baseJsonResponse = new JSONObject(announcementJson);

            JSONArray announcementList = baseJsonResponse.getJSONArray("announcementsDetails");

            for(int i=0; i<announcementList.length();i++){

                JSONObject announcementData = announcementList.getJSONObject(i);

                String title = announcementData.getString("typeOfAnnouncement");
                String description = announcementData.getString("description");

                Announcement announcement = new Announcement(title,"6 to 8","9am - 5pm",description);
                announcements.add(announcement);
            }

        }
        catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the earthquake JSON results", e);
        }

        return announcements;
    }
}
