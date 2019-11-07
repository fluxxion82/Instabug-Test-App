package com.example.android.instabugapp.ui.base

import android.content.Context
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import dagger.android.support.AndroidSupportInjection

abstract class BasePreferenceFragment : PreferenceFragmentCompat() {

    protected abstract fun setupPreferencesFromResource()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setupPreferencesFromResource()
    }
}