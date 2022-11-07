package com.example.appsonsofcalisthenicsbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NextNutrition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_nutrition)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_nutrition)
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.bar_nutrition_title)
    }
}

/*

Hombres TMB = (10 x peso de Kg) + (6,25 x altura en cm) – (5 x edad en años) + 5
Mujeres TMB = (10 x peso en kg) + (6,25 x altura en cm) – (5 x edad en años) – 161

*/