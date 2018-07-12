package com.example.ichanghyeon.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditMemoActivity extends AppCompatActivity {
    Button doneBtn;
    Button cancelBtn;

    EditText titleField;
    EditText infoField;
    EditText extrainfoField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_memo);

        doneBtn = findViewById(R.id.doneBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        titleField = findViewById(R.id.titleField);
        infoField = findViewById(R.id.infoField);
        extrainfoField = findViewById(R.id.extraInfoField);

        titleField.setText(getIntent().getStringExtra("title"));
        infoField.setText(getIntent().getStringExtra("info"));
        extrainfoField.setText(getIntent().getStringExtra("extrainfogit"));

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                intent.putExtra("title", titleField.getText().toString());
                intent.putExtra("info", infoField.getText().toString());
                intent.putExtra("extrainfo", extrainfoField.getText().toString());
                Log.e(titleField.getText().toString(),"타이틀");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
