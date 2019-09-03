package com.mkhglab.kotlintabbar.fragments.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsFragment: Fragment() {

    val title = "Settings"
    var mInterface: SettingsListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        mInterface?.settingsLoaded()

        view.changePINLL.setOnClickListener {
            Log.d("DEBUG", "View.changePINLL tapped")
        }
        view.moreAppsLL.setOnClickListener {
            Log.d("DEBUG", "View.moreAppsLL tapped")
        }
        view.logoutLL.setOnClickListener {
            Log.d("DEBUG", "View.logoutLL tapped")
        }

        return view
    }

    companion object {
        fun newInstance(): SettingsFragment =
            SettingsFragment()
    }
}