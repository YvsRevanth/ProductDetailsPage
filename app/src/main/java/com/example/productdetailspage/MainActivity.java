package com.example.productdetailspage;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TaskMaker taskMaker = new TaskMaker();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo.isConnected()) {
//            Toast.makeText(this, "connected", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "not connected", Toast.LENGTH_LONG).show();
//        }
                getSupportFragmentManager().beginTransaction().add(R.id.container, taskMaker).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    @Override
//    public void data() {
//
//    }
}