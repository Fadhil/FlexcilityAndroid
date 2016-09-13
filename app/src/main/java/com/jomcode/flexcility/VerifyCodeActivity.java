package com.jomcode.flexcility;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VerifyCodeActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "FlexcilityPrefs";
    public static final String API_URL = "http://www.setgetgo.com/randomword/get.php";
    private static final String DEBUG_TAG = "FADHIL DEBUG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.USER_PHONE_NUMBER);
        TextView textOutput = (TextView) findViewById(R.id.user_phone_number);
        textOutput.setText(message);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            new RandomWordApiTask().execute(API_URL);
        } else {

            setContentView(R.layout.activity_verify_code);
            TextView errorMsg = (TextView) findViewById(R.id.errorMsg);
            errorMsg.setText(getString(R.string.could_not_connect_to_network));
        }



    }



    private class RandomWordApiTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            try{
                return getRandomWord(url[0]);
            } catch (IOException e) {
                return "Unable to retrieve data. ";
            }
        }

        private String getRandomWord(String url) throws IOException {
            InputStream is = null;

            try {
                URL data_url = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) data_url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(DEBUG_TAG, "The response is: " + response);
                is = conn.getInputStream();
                return readIt(is);
            } finally {
                if (is != null) {
                    is.close();
                }

            }
        }

        public String readIt(InputStream stream) throws IOException {
            Reader reader;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[100];
            reader.read(buffer);
            return new String(buffer);
        }

        protected void onPostExecute(String result) {
            TextView infoMsg = (TextView) findViewById(R.id.infoMsg);
            infoMsg.setText(result);
        }
    }

}
