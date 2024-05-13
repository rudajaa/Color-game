package com.example.colorgame;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class RulesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Знаходимо кнопку "Back"
        Button backButton = findViewById(R.id.backButton);
        backButton.setBackgroundTintList(getResources().getColorStateList(R.color.dark_green));

        // Налаштовуємо обробник подій для кнопки "Back"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Повертаємося на головний екран
                Intent intent = new Intent(RulesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }







}