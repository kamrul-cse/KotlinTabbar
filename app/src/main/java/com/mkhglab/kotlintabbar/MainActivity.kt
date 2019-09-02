package com.mkhglab.kotlintabbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mkhglab.kotlintabbar.fragments.history.HistoryFragment
import com.mkhglab.kotlintabbar.fragments.history.HistoryListener
import com.mkhglab.kotlintabbar.fragments.home.HomeFragment
import com.mkhglab.kotlintabbar.fragments.profile.ProfileFragment
import com.mkhglab.kotlintabbar.fragments.settings.SettingsFragment
import com.mkhglab.kotlintabbar.fragments.home.HomeListener
import com.mkhglab.kotlintabbar.fragments.profile.ProfileListener
import com.mkhglab.kotlintabbar.fragments.settings.SettingsListener

class MainActivity : AppCompatActivity(), HomeListener, HistoryListener, ProfileListener, SettingsListener {

    lateinit var toolbar: ActionBar

    var homeFragment = HomeFragment.newInstance()
    var historyFragment = HistoryFragment.newInstance()
    var profileFragment = ProfileFragment.newInstance()
    var settingsFragment = SettingsFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        homeFragment.mInterface = this
        historyFragment.mInterface = this
        profileFragment.mInterface = this
        settingsFragment.mInterface = this

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        openFragment(homeFragment)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //HomeListener
    override fun homeLoaded() {
        toolbar.title = homeFragment.title
    }

    //HistoryListener
    override fun historyLoaded() {
        toolbar.title = historyFragment.title
    }

    //ProfileListener
    override fun profileLoaded() {
        toolbar.title = profileFragment.title
    }

    //SettingsListener
    override fun settingsLoaded() {
        toolbar.title = settingsFragment.title
    }
}
