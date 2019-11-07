package com.example.android.instabugapp.ui.homescreen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.instabugapp.R
import com.example.android.instabugapp.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val textView = view.findViewById<TextView>(R.id.tvHome)
        textView.setText("Test Instabug")

        return view
    }
}
