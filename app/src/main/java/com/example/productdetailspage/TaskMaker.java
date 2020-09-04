package com.example.productdetailspage;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

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
    FrameLayout frag;
    TextView hello;
    TaskMachine taskMachine = new TaskMachine();
    Button button;
    View view;

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

    @Override
    public void onResume() {
        super.onResume();
        hello = hello.findViewById(R.id.hello);
        Button button = view.findViewById(R.id.hitter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskMachine.execute("");
            }
        });
    }
    public void setHoney(Honey honey) {
        this.honey = honey;
    }

    public interface Honey {
        public void data();
    }
}

    class TaskMachine extends AsyncTask<String, String, String> {
        TextView hello;
        Handler handler = new Handler();
        HttpURLConnection httpURLConnection;

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("https://reqres.in/api/users/2");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    Log.e("page is available now", "ok");
                } else {
                    Log.e("page is unavailable now", "not ok dude");
                }
            } catch (IOException ex) {
                Log.e("", " " + ex.getMessage());
            }
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader stream = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((stream.readLine()));
                final JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        hello.setText(jsonObject.toString());
                    }
                });
            } catch (Exception ex) {
                Log.e("SOME ERROR", " ");
            }
            return null;
        }
    }


