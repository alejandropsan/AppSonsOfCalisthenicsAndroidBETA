package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExercicesAdvancedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercices_advanced)
    }

    fun goRoadToMuscle(view: View){
        startActivity(Intent(this, RoadToMuscleActivity::class.java))
    }

    fun goTension(view: View){
        startActivity(Intent(this, TensionActivity::class.java))
    }
}