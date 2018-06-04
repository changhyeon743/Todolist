package com.example.ichanghyeon.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ichanghyeon on 2018. 6. 4..
 */

public class CustomAdapter extends BaseAdapter{
    ArrayList<String> items = new ArrayList<>();

    public CustomAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null);

        TextView text = (TextView) v.findViewById(R.id.contentText);

        text.setText(items.get(position));
        return v;
    }
}
