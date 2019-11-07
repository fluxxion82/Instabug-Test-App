package com.example.android.instabugapp.ui.homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android.instabugapp.R
import com.example.android.instabugapp.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HomeRootFragment : BaseFragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var  bottomNavigation : BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeRootFragment", "onCreateView")
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_root_home, container, false)

        val host = childFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = NavHostFragment.findNavController(host!!)

        bottomNavigation = view.findViewById(R.id.bottomNavigation)
        bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigation.visibility = View.VISIBLE
        }

        return view
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}