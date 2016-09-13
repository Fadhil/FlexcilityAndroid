package com.jomcode.flexcility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public final static String USER_PHONE_NUMBER = "com.jomcode.flexcility.USER_PHONE_NUMBER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sendVerificationSms(View v) {

        Intent intent = new Intent(this, VerifyCodeActivity.class);
        EditText phoneNumberInput  = (EditText) findViewById(R.id.phoneNumberInput);
        String phoneNumber = phoneNumberInput.getText().toString();
        intent.putExtra(USER_PHONE_NUMBER, phoneNumber);
        startActivity(intent);

    }
}
