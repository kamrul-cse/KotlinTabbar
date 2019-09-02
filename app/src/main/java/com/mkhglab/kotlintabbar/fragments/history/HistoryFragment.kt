package com.mkhglab.kotlintabbar.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class HistoryFragment: Fragment() {

    val title = "History"
    var mInterface: HistoryListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        mInterface?.historyLoaded()

        return view
    }

    companion object {
        fun newInstance(): HistoryFragment =
            HistoryFragment()
    }
}