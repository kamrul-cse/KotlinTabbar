package com.mkhglab.kotlintabbar.fragments.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class HomeFragment: Fragment() {

    val title = "Home"

    var mInterface: HomeListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        mInterface?.homeLoaded()

        return view
    }

    companion object {
        fun newInstance(): HomeFragment =
            HomeFragment()
    }
}