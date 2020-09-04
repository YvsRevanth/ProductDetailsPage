package com.example.productdetailspage;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class TaskMaker extends Fragment {
    Honey honey;
    FrameLayout fragger;
    View view;
    TaskMachine taskMachine = new TaskMachine();
    Handler handler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_task_maker, container, false);
        return view;
    }
    public class TaskMachine extends AsyncTask<String, String, String>{
        HttpURLConnection httpURLConnection;
        @Override
        protected String doInBackground(String... strings) {
            try {
            URL url = new URL("https://reqres.in/api/users/2");
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader stream = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((stream.readLine()));
              final JSONObject jsonObject = new JSONObject(stringBuilder.toString());
              handler.post(new Runnable() {
                  @Override
                  public void run() {

                  }
              });
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void setHoney(Honey honey){
        this.honey= honey;
    }
    public interface Honey{
        public void data();
    }
}