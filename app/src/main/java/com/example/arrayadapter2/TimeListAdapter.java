package com.example.arrayadapter2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TimeListAdapter extends ArrayAdapter<Datexx> {
    public static Object add;
    private Context mContext;
    int mResource;


    // on se hienoa koodia mutta kun ei tajua


    public TimeListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Datexx> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public TimeListAdapter(MainActivity mainActivity, int adapter_view_layout) {
        super(mainActivity, adapter_view_layout);
    }

    public static void add(String toString) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String aika = getItem(position).getTime();


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTime = (TextView) convertView.findViewById(R.id.view_date);

        tvTime.setText(aika);

        return convertView;
    }
}
