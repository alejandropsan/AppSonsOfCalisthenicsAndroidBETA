package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.appsonsofcalisthenicsbeta.LoginActivity.Companion.userEmail
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolBar()
        initNavigationView()

    }

    private fun initToolBar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        val toogle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.bar_title_menu,
        R.string.bar_title_closeMenu)

        drawer.addDrawerListener(toogle)

        toogle.syncState()
    }

    private fun initNavigationView(){
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        var headerView: View = LayoutInflater.from(this).inflate(R.layout.nav_header_main, navigationView, false)
        navigationView.removeHeaderView(headerView)
        navigationView.addHeaderView(headerView)

        var tvUser: TextView = headerView.findViewById(R.id.tvUser)
        tvUser.text = userEmail
    }

    fun goSignOut(view: View){
        signOut()
    }

    private fun signOut(){
        userEmail = ""
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun goLevelExercices(view: View){

        startActivity(Intent(this, LevelTrainmentsActivity::class.java))
    }

    fun goRoutines(view: View){

        startActivity(Intent(this, RoutinesActivity::class.java))
    }

    fun goNutrition(view: View) {

        startActivity(Intent(this, NutritionActivity::class.java))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.history -> goHistoryUserActivity()
            R.id.signOut -> signOut()
            R.id.item_profile -> goEditProfile()
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun goHistoryUserActivity(){
        startActivity(Intent(this, HistoryUserActivity::class.java))
    }

    private fun goEditProfile(){
        startActivity(Intent(this, MyProfileActivity::class.java))
    }

}