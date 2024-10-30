package com.example.fragmentandnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.content_frame,HomeFragment()).commit()
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            drawerLayout.openDrawer(GravityCompat.START)
        }
        when(item.itemId)
        {
            R.id.nav_home->{
                supportFragmentManager.beginTransaction().replace(R.id.content_frame,HomeFragment()).commit()
            }
            R.id.nav_news->{
                supportFragmentManager.beginTransaction().replace(R.id.content_frame,NewsFragment()).commit()
            }
            R.id.nav_settings->{
                supportFragmentManager.beginTransaction().replace(R.id.content_frame,SettingsFragment()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}