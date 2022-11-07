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
import com.example.appsonsofcalisthenicsbeta.R.drawable
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class LevelTrainmentsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_trainments)

        initToolBar()
        initNavigationView()

    }

    private fun initToolBar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_levels)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layoutLevels)
        val toogle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.bar_title_menu,
            R.string.bar_title_closeMenu)

        drawer.addDrawerListener(toogle)

        toogle.syncState()
    }

    private fun initNavigationView(){
        var navigationView: NavigationView = findViewById(R.id.nav_view_levels)
        navigationView.setNavigationItemSelectedListener(this)

        var headerView: View = LayoutInflater.from(this).inflate(R.layout.nav_header_main, navigationView, false)
        navigationView.removeHeaderView(headerView)
        navigationView.addHeaderView(headerView)

        var tvUser: TextView = headerView.findViewById(R.id.tvUser)
        tvUser.text = LoginActivity.userEmail
    }

    fun goAmateur(view: View){
        startActivity(Intent(this, ExercicesAmateurActivity::class.java))
    }

    fun goMedium(view: View){
        startActivity(Intent(this, ExercicesMediumActivity::class.java))
    }

    fun goAdvanced(view: View){
        startActivity(Intent(this, ExercicesAdvancedActivity::class.java))
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
}