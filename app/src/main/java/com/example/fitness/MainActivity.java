package com.example.fitness;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView userDataTextView;
    private TextView stepsTextView;
    private TextView caloriesTextView;
    private TextView heartRateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView pour afficher les données utilisateur
        userDataTextView = findViewById(R.id.userDataTextView);
        stepsTextView = findViewById(R.id.stepsTextView);
        caloriesTextView = findViewById(R.id.caloriesTextView);
        heartRateTextView = findViewById(R.id.heartRateTextView);

        // Appel à l'API REST pour récupérer les données utilisateur
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://your-api-endpoint-url.com");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");

                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    bufferedReader.close();
                    inputStream.close();
                    urlConnection.disconnect();

                    // Traitement des données JSON pour afficher dans le TextView
                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    final String username = jsonObject.getString("username");
                    final int steps = jsonObject.getInt("steps");
                    final int calories = jsonObject.getInt("calories");
                    final int heartRate = jsonObject.getInt("heartRate");

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            String userData = "Username: " + username + "\n"
                                    + "Steps: " + steps + "\n"
                                    + "Calories: " + calories;
                            userDataTextView.setText(userData);
                            stepsTextView.setText("Steps: " + steps);
                            caloriesTextView.setText("Calories: " + calories);
                            heartRateTextView.setText("Heart Rate: " + heartRate);
                        }
                    });
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
