package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExercicesAmateurActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amateur_exercices)
    }


    fun goStretches(view: View){
        startActivity(Intent(this, StretchesAmateurActivity::class.java))
    }

    fun goRoadToMuscle(view: View){
        startActivity(Intent(this, RoadToMuscleActivity::class.java))
    }

    fun goTension(view: View){
        startActivity(Intent(this, TensionActivity::class.java))
    }

    fun goCardio(view: View){
        startActivity(Intent(this, CardioActivity::class.java))
    }

    fun goLegs(view: View){
        startActivity(Intent(this, LegsActivity::class.java))
    }

    fun goAbs(view: View){
        startActivity(Intent(this, AbsActivity::class.java))
    }

    fun goBiceps(view: View){
        startActivity(Intent(this, BicepsActivity::class.java))
    }

    fun goChest(view: View){
        startActivity(Intent(this, ChestActivity::class.java))
    }

    fun goTriceps(view: View){
        startActivity(Intent(this, TricepsActivity::class.java))
    }

    fun goShoulders(view: View){
        startActivity(Intent(this, ShouldersActivity::class.java))
    }

    fun goBack(view: View){
        startActivity(Intent(this, BackActivity::class.java))
    }

    fun runExercices(view: View){
        startActivity(Intent(this, RunExerciceActivity::class.java))
    }
}