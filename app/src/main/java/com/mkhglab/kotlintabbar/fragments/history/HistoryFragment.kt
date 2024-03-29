package com.mkhglab.kotlintabbar.fragments.history

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.mkhglab.kotlintabbar.R

class HistoryFragment: Fragment() {

    val title = "History"
    var mInterface: HistoryListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        mInterface?.historyLoaded()

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_history_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {


        when (item?.itemId) {
            R.id.action_menu_group -> {
                Log.d("DEBUG", "action_menu_group tapped")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): HistoryFragment =
            HistoryFragment()
    }
}