package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.pow
import kotlin.math.roundToInt

class NutritionActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    private lateinit var pesoUser: EditText
    private lateinit var heightsUser: EditText
    private lateinit var resultImcUser: TextView
    private lateinit var calculateImc: android.widget.Button
    private lateinit var percent: TextView
    private var pesoImc: Float? = null
    private var heightsImc: Float? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)

        initToolBar()
        initNavigationView()

        pesoUser = findViewById(R.id.etPesoUser)
        heightsUser = findViewById(R.id.etAlturaUser)
        heightsUser.requestFocus()

        calculateImc = findViewById(R.id.bCalculate)
        resultImcUser = findViewById(R.id.tvResultImcUser)
        resultImcUser.visibility = View.INVISIBLE
        percent = findViewById(R.id.tvPercent)
        percent.visibility = View.INVISIBLE

    }

    private fun initToolBar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_nutrition)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layoutNutrition)
        val toogle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.bar_title_menu,
            R.string.bar_title_closeMenu)

        drawer.addDrawerListener(toogle)

        toogle.syncState()
    }

    private fun initNavigationView(){
        var navigationView: NavigationView = findViewById(R.id.nav_view_nutrition)
        navigationView.setNavigationItemSelectedListener(this)

        var headerView: View = LayoutInflater.from(this).inflate(R.layout.nav_header_main, navigationView, false)
        navigationView.removeHeaderView(headerView)
        navigationView.addHeaderView(headerView)

        var tvUser: TextView = headerView.findViewById(R.id.tvUser)
        tvUser.text = LoginActivity.userEmail
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.history -> goHistoryUserActivity()
            R.id.signOut -> signOut()
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun signOut(){
        LoginActivity.userEmail = ""
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun goHistoryUserActivity(){
        startActivity(Intent(this, HistoryUserActivity::class.java))
    }

    fun imcUser(view: View){
        pesoImc = pesoUser.text.toString().toFloatOrNull()
        heightsImc = heightsUser.text.toString().toFloatOrNull()
        imc(pesoImc, heightsImc)
    }

    private fun imc(peso: Float?, altura: Float?){

        val formula = (peso!! / altura!!.pow(2))
        resultImcUser.text = formula.toString().subSequence(0, 5)
        resultImcUser.visibility = VISIBLE
        percent.visibility = VISIBLE
    }


    fun goTmb(view: View){
        startActivity(Intent(this, NextNutrition::class.java))
    }



}