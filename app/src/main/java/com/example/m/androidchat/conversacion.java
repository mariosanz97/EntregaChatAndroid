package com.example.m.androidchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class conversacion extends AppCompatActivity {

    private Button button;
    private ListView listView;
    private converadapter converadapter;
    private EditText editText;
    private List<String> Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversaciones);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.Button);
        listView = (ListView) findViewById(R.id.listView);


        Array = new ArrayList<String>();

        converadapter = new converadapter(this, Array);
        listView.setAdapter(converadapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Array.add(editText.getText().toString());
                converadapter.notifyDataSetChanged();
                editText.setText("");

            }
        });


    }
}
