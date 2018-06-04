package com.example.ichanghyeon.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> items = new ArrayList<>();
    CustomAdapter adapter;
    ListView list;
    EditText inputText;
    Button btn;

    EditText inputTextSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);

        inputText = findViewById(R.id.inputBox);
        btn = findViewById(R.id.button);

        inputTextSmall = findViewById(R.id.inputBoxSmall);

        items.add(new Item("큰 제목","작은 제목"));

        adapter = new CustomAdapter(items);

        list.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new Item(inputText.getText().toString(),inputTextSmall.getText().toString()));
                adapter.notifyDataSetChanged();
                inputText.setText("");
                inputTextSmall.setText("");
            }
        });



    }


}
