package com.example.android.instabugapp.ui.homescreen.settings.support

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android.domain.base.CoroutineScopeFacade
import com.example.android.instabugapp.R
import com.example.android.instabugapp.service.BugReporter
import com.example.android.instabugapp.ui.base.BaseFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class SupportFragment : BaseFragment() {

    @Inject
    lateinit var bugReporter: BugReporter

    @Inject
    lateinit var coroutineScopeFacade: CoroutineScopeFacade

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_support, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        val sendDiagnosticReport = view.findViewById<TextView>(R.id.sendDiagnostic)
        sendDiagnosticReport.setOnClickListener {
            coroutineScopeFacade.globalScope.launch { bugReporter.report() }
        }

        return view
    }
}
