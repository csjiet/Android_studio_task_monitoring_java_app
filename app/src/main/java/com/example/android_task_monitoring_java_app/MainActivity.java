package com.example.android_task_monitoring_java_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean passwordState = false;


    private EditText passwordText;
    private Button modeChoosingActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activities
        modeChoosingActivityButton = (Button) findViewById(R.id.button);
        passwordText = (EditText) findViewById(R.id.editTextNumberPassword);



        // Action
        // Check if start button is clicked
        modeChoosingActivityButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModeChoosingActivity();
            }
        });

        // Check password validity
        passwordText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                PasswordChecker passwordCheck = new PasswordChecker();
                passwordState = passwordCheck.passwordVerifier(passwordText.getText().toString());
                System.out.println(passwordState);
                return passwordState;
            }
        });






    }

    public void openModeChoosingActivity(){

        if(passwordState){
            Intent intent = new Intent(this, ModeChoosingActivity.class);
            startActivity(intent);
        }else{

            // Display warning text
            alertDialog();
        }
    }

    private void alertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("You have to enter your password ");
        dialog.setTitle("Invalid password. Please try again. ");
        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Yes is clicked", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();


    }



}