package com.example.appsonsofcalisthenicsbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat

class HistoryUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_user)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_record)
        setSupportActionBar(toolbar)

        toolbar.title = getString(R.string.bar_title_record)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.gray_dark))
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.aa))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.order_records_by, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.orderby_date -> {
                if (item.title == getString(R.string.orderby_dateZA)){
                    item.title = getString(R.string.orderby_dateAZ)
                }
                else{
                    item.title = getString(R.string.orderby_dateZA)
                }
                return true
            }

            R.id.orderby_amateur -> {
                if (item.title == getString(R.string.orderby_amateurZA)){
                    item.title = getString(R.string.orderby_amateurAZ)
                }
                else{
                    item.title = getString(R.string.orderby_amateurZA)
                }
                return true
            }

            R.id.orderby_medium -> {
                if (item.title == getString(R.string.orderby_mediumZA)){
                    item.title = getString(R.string.orderby_mediumAZ)
                }
                else{
                    item.title = getString(R.string.orderby_mediumZA)
                }
                return true
            }

            R.id.orderby_advanced -> {
                if (item.title == getString(R.string.orderby_advancedZA)){
                    item.title = getString(R.string.orderby_advancedAZ)
                }
                else{
                    item.title = getString(R.string.orderby_advancedZA)
                }
                return true
            }

            R.id.orderby_favorites -> {
                if (item.title == getString(R.string.orderby_favoritesZA)){
                    item.title = getString(R.string.orderby_favoritesAZ)
                }
                else{
                    item.title = getString(R.string.orderby_favoritesZA)
                }
                return true
            }

            R.id.orderby_min_activity -> {
                if (item.title == getString(R.string.orderby_min_activityZA)){
                    item.title = getString(R.string.orderby_min_activityAZ)
                }
                else{
                    item.title = getString(R.string.orderby_min_activityZA)
                }
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun goHome(view: View){
        startActivity(Intent(this, MainActivity::class.java))
    }
}