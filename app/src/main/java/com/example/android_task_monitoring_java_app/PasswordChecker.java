package com.example.android_task_monitoring_java_app;

public class PasswordChecker {

    public boolean passwordVerifier(String password){

        System.out.println(password);
        if(password.equals("123")){

            return true;
        }

        return false;
    }
}
