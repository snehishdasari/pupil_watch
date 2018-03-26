package com.example.android.pupil_watch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Rashed on 26-03-2018.
 */

public class DashboardAdapter extends BaseAdapter {

    private Context mContext;

    private ArrayList<DashboardItem> mList;

    public DashboardAdapter(Context c, ArrayList<DashboardItem> list) {
        mContext = c;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View dashboardItemView = convertView;
        if(dashboardItemView == null){
            dashboardItemView = LayoutInflater.from(mContext).inflate(R.layout.dashboard_item,parent,false);
        }

        DashboardItem dashboardItem = mList.get(position);

        ImageView imageView = dashboardItemView.findViewById(R.id.dashboard_item_image);
        imageView.setImageResource(dashboardItem.getmImage());

        TextView textView = dashboardItemView.findViewById(R.id.dashboard_item_title);
        textView.setText(dashboardItem.getmTitle());

        return dashboardItemView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
}
