package com.mkhglab.kotlintabbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mkhglab.kotlintabbar.fragments.HistoryFragment
import com.mkhglab.kotlintabbar.fragments.HomeFragment
import com.mkhglab.kotlintabbar.fragments.ProfileFragment
import com.mkhglab.kotlintabbar.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    var homeFragment = HomeFragment.newInstance()
    var historyFragment = HistoryFragment.newInstance()
    var profileFragment = ProfileFragment.newInstance()
    var settingsFragment = SettingsFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        toolbar.title = homeFragment.title
        openFragment(homeFragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                toolbar.title = homeFragment.title
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                toolbar.title = historyFragment.title
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = profileFragment.title
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                toolbar.title = settingsFragment.title
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
