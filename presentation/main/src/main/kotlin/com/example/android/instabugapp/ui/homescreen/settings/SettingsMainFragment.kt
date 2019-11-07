package com.example.android.instabugapp.ui.homescreen.settings

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.example.android.instabugapp.R
import com.example.android.instabugapp.adapter.DividerItemDecoration
import com.example.android.instabugapp.ui.base.BasePreferenceFragment

class SettingsMainFragment : BasePreferenceFragment(), PreferenceFragmentCompat.OnPreferenceStartScreenCallback {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDivider(null)

        val recyclerView = listView
        val separator = resources.getDrawable(R.drawable.abc_list_divider_mtrl_alpha)
        separator.setColorFilter(resources.getColor(R.color.light_grey), PorterDuff.Mode.SRC_ATOP)
        val decor = DividerItemDecoration(separator)
        recyclerView.addItemDecoration(decor)
    }

    override fun setupPreferencesFromResource() {
        addPreferencesFromResource(R.xml.settings)
    }

    override fun onPreferenceStartScreen(caller: PreferenceFragmentCompat?, pref: PreferenceScreen?): Boolean {
        val host = childFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = NavHostFragment.findNavController(host!!)

        navController.navigate(R.id.supportFragment)

        return true
    }
}
