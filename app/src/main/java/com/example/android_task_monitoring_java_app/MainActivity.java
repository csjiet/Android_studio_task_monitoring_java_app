package com.example.android_task_monitoring_java_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button modeChoosingActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeChoosingActivityButton = (Button) findViewById(R.id.button);
        modeChoosingActivityButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModeChoosingActivity();
            }
        });

    }

    public void openModeChoosingActivity(){
        Intent intent = new Intent(this, ModeChoosingActivity.class);
        startActivity(intent);
    }
}