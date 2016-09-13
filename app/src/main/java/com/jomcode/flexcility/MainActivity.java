package com.jomcode.flexcility;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "FlexcilityPrefs";
    public static final String USER_MOBILE_NO = "com.jomcode.flexcility.USER_MOBILE_NO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
        Integer userId = settings.getInt("userId", 0);
        if(userId > 0){
            // Go to Dashboard
            Log.d("DEBUG", "Going to Dashboard");
        } else {
            // Go to Login
            Log.d("DEBUG", "Going to Login");

            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }
    }
}

