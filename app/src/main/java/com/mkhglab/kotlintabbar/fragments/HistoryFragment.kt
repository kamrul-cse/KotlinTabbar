package com.mkhglab.kotlintabbar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class HistoryFragment: Fragment() {

    val title = "History"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_history, container, false)

    companion object {
        fun newInstance(): HistoryFragment = HistoryFragment()
    }
}