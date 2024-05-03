package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness.MainActivity;

public class Workout extends AppCompatActivity {

    private EditText startTimeEditText;
    private EditText durationEditText;
    private EditText distanceEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Récupérer les références des vues
        startTimeEditText = findViewById(R.id.startTimeEditText);
        durationEditText = findViewById(R.id.durationEditText);
        distanceEditText = findViewById(R.id.distanceEditText);
        saveButton = findViewById(R.id.saveButton);

        // Gérer le clic sur le bouton "Save"
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données saisies
                String startTime = startTimeEditText.getText().toString();
                String duration = durationEditText.getText().toString();
                String distance = distanceEditText.getText().toString();

                // Enregistrer les données dans une base de données ou effectuer d'autres actions nécessaires

                // Retourner à MainActivity
                Intent intent = new Intent(Workout.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optionnel, pour fermer l'activité actuelle
            }
        });
    }
}
