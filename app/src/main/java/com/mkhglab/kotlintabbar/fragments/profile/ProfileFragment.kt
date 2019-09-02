package com.mkhglab.kotlintabbar.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class ProfileFragment: Fragment() {

    val title = "Profile"
    var mInterface: ProfileListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mInterface?.profileLoaded()

        return view
    }

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }
}