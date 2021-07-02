package com.prakriti.mycustomview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyCustomView myCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View customView = findViewById(R.id.customView);
//        customView.setOnClickListener(v -> Toast.makeText(MainActivity.this, R.string.clicked, Toast.LENGTH_SHORT).show() );

        // need MyCustomView object to set/get the attribute instance vars
        myCustomView = (MyCustomView) findViewById(R.id.customView);
        myCustomView.setOnClickListener(v -> {
            myCustomView.setViewColor(getColor(R.color.teal_700)); // min API Level 23 for this function call
            myCustomView.setTextColor(Color.WHITE);
            myCustomView.setViewText("VIEW CLICKED!");
        });
    }
}