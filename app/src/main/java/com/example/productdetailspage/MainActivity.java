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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements TaskMaker.Honey {
    TaskMaker taskMaker = new TaskMaker();
    Handler handler = new Handler();
    Button button;
    TextView hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello =findViewById(R.id.hello);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
         button = (Button) findViewById(R.id.hitter);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 taskMachine.execute("");
             }
         });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction().add(R.id.container, taskMaker).commit();
    }

    @Override
    public void data() {

    }
}