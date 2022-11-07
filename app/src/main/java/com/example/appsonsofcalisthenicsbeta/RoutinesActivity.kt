package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class RoutinesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routines)

        initToolBar()
        initNavigationView()
    }

    private fun initToolBar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_routines)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layoutRoutines)
        val toogle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.bar_title_menu,
            R.string.bar_title_closeMenu)

        drawer.addDrawerListener(toogle)

        toogle.syncState()
    }

    private fun initNavigationView(){
        var navigationView: NavigationView = findViewById(R.id.nav_viewRoutines)
        navigationView.setNavigationItemSelectedListener(this)

        var headerView: View = LayoutInflater.from(this).inflate(R.layout.nav_header_main, navigationView, false)
        navigationView.removeHeaderView(headerView)
        navigationView.addHeaderView(headerView)

        var tvUser: TextView = headerView.findViewById(R.id.tvUser)
        tvUser.text = LoginActivity.userEmail
    }

    private fun signOut(){
        LoginActivity.userEmail = ""
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.history -> goHistoryUserActivity()
            R.id.signOut -> signOut()
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun goHistoryUserActivity(){
        startActivity(Intent(this, HistoryUserActivity::class.java))
    }

    fun goRoutinesRandom(view: View){
        startActivity(Intent(this, RoutinesRandomActivity::class.java))
    }

    fun goRoutinesAmateur(view: View){
        startActivity(Intent(this, RoutinesAmateurActivity::class.java))
    }

    fun goRoutinesMedium(view: View){
        startActivity(Intent(this, RoutinesMediumActivity::class.java))
    }

    fun goRoutinesAdvanced(view: View){
        startActivity(Intent(this, RoutinesAdvancedActivity::class.java))
    }
}