package com.example.ichanghyeon.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMemoActivity.class);
                intent.putExtra("data", items);
                startActivityForResult(intent,1);
//                items.add(new Item(inputText.getText().toString(),inputTextSmall.getText().toString()));
//                adapter.notifyDataSetChanged();
//                inputText.setText("");
//                inputTextSmall.setText("");
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
