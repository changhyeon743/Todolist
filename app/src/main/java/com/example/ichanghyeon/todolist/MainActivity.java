package com.example.ichanghyeon.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
    CustomAdapter adapter;
    ListView list;
    EditText inputText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);

        inputText = findViewById(R.id.inputBox);
        btn = findViewById(R.id.button);
        items.add("안녕");

        adapter = new CustomAdapter(items);

        list.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(inputText.getText().toString());
                adapter.notifyDataSetChanged();
                inputText.setText("");
            }
        });



    }


}
