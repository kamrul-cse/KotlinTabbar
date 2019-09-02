package com.mkhglab.kotlintabbar.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class SettingsFragment: Fragment() {

    val title = "Settings"
    var mInterface: SettingsListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        mInterface?.settingsLoaded()

        return view
    }

    companion object {
        fun newInstance(): SettingsFragment =
            SettingsFragment()
    }
}