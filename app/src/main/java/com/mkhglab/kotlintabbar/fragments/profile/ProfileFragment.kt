package com.mkhglab.kotlintabbar.fragments.profile

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment() {

    val title = "Profile"
    var mInterface: ProfileListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mInterface?.profileLoaded()

        view.findViewById<LinearLayout>(R.id.nameDisplayLL).visibility = View.VISIBLE
        view.findViewById<LinearLayout>(R.id.nameEditLL).visibility = View.GONE

        view.findViewById<Button>(R.id.editButton).setOnClickListener {
            nameDisplayLL.visibility = View.GONE
            nameEditLL.visibility = View.VISIBLE
        }

        view.findViewById<Button>(R.id.submitButton).setOnClickListener {
            nameDisplayLL.visibility = View.VISIBLE
            nameEditLL.visibility = View.GONE
        }

        return view
    }

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }
}