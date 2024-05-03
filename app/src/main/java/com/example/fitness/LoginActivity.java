package com.example.fitness;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClicked(View view) {
        // Récupérer les valeurs des champs email et mot de passe
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Ici, vous pouvez ajouter la logique de connexion à votre backend
        // Par exemple, vérifier les informations d'identification avec une base de données
        // Si les informations sont valides, vous pouvez démarrer l'activité principale
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onSignUpClicked(View view) {
        // URL de la page d'inscription
        String signUpUrl = "https://www.example.com/signup";

        // Créer un Intent pour ouvrir une page web
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(signUpUrl));
        startActivity(intent);
    }

}
