package com.example.ichanghyeon.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Data> items = new ArrayList<>();
    CustomAdapter adapter;
    ListView list;

    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);

        addBtn = findViewById(R.id.button);


        adapter = new CustomAdapter(items);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AddMemoActivity.class);
                intent.putExtra("pos", position);
                intent.putExtra("title", items.get(position).getTitle());
                intent.putExtra("info", items.get(position).getInfo());
                intent.putExtra("extrainfo", items.get(position).getExtraInfo());
                startActivityForResult(intent,2);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMemoActivity.class);
                startActivityForResult(intent,1);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Data temp = new Data(data.getStringExtra("title"),data.getStringExtra("info"),data.getStringExtra("extrainfo"));
                items.add(temp);
                adapter.notifyDataSetChanged();
                Log.d(String.valueOf(temp.getTitle()),"실행완료");
            }
        }
    }
}
