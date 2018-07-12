package com.example.ichanghyeon.todolist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    ArrayList<Data> items = new ArrayList<>();
    Context mContext;

    public CustomAdapter(ArrayList<Data> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null);

        TextView text = (TextView) v.findViewById(R.id.contentText);
        TextView smallText = (TextView) v.findViewById(R.id.smallText);


        text.setText(items.get(position).getTitle());
        smallText.setText(items.get(position).getInfo());

        Button btn = (Button) v.findViewById(R.id.deleteBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });

        Button editBtn = (Button) v.findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ERror","ERROR");
                ((MainActivity)mContext).editEvent(position);
            }
        });



        return v;
    }

}
