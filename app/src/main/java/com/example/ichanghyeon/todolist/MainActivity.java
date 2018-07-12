package com.example.ichanghyeon.todolist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

        loadData();

        list = findViewById(R.id.listView);

        addBtn = findViewById(R.id.button);


        adapter = new CustomAdapter(items,MainActivity.this);

        list.setAdapter(adapter);


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
                Log.d(String.valueOf(data.getStringExtra("extrainfo")),"실행완료");

            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Data temp = new Data(data.getStringExtra("title"),data.getStringExtra("info"),data.getStringExtra("extrainfo"));
                items.set(data.getIntExtra("pos",0),temp);
                adapter.notifyDataSetChanged();
                Log.d(String.valueOf(temp.getTitle()),"실행완료");
            }
        }
    }

    public void editEvent(int position) {
        Log.d(String.valueOf(items.get(position).getExtraInfo()),"포지션");
        Intent intent = new Intent(MainActivity.this, EditMemoActivity.class);
        intent.putExtra("pos", position);
        intent.putExtra("title", items.get(position).getTitle());
        intent.putExtra("info", items.get(position).getInfo());
        intent.putExtra("extrainfo", items.get(position).getExtraInfo());

        startActivityForResult(intent,2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }

    public void saveData() {

        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String json = new Gson().toJson(items);
        editor.putString("save", json);
        editor.commit();

    }

    public void loadData() {


        Gson gson = new Gson();
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        String json = pref.getString("save", "");
        ArrayList<Data> shareditems;
        shareditems = gson.fromJson(json, new TypeToken<ArrayList<Data>>(){}.getType());
        if(shareditems != null)items.addAll(shareditems);

    }


}
