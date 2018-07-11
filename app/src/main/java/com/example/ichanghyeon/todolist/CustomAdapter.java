package com.example.ichanghyeon.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    ArrayList<Data> items = new ArrayList<>();

    public CustomAdapter(ArrayList<Data> items) {
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
        TextView smallText = (TextView) v.findViewById(R.id.smallText);

        text.setText(items.get(position).getTitle());
        smallText.setText(items.get(position).getInfo());

        return v;
    }
}
