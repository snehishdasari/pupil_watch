package com.example.android.pupil_watch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rashed on 10-04-2018.
 */

public class FaqAdapter extends ArrayAdapter<QuesAns> {

    public FaqAdapter(Context where, ArrayList<QuesAns> list) {
        super(where, 0, list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View faqView = convertView;

        if (faqView == null) {
            faqView = LayoutInflater.from(getContext()).inflate(R.layout.data_faq, parent, false);
        }
        QuesAns i = getItem(position);
        TextView q = faqView.findViewById(R.id.faqq);
        q.setText(i.getq());
        TextView a = faqView.findViewById(R.id.faqa);
        a.setText(i.geta());
        return faqView;
    }
}
