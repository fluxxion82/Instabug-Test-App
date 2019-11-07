package com.example.instabugapp.configuration

import android.util.Log
import com.instabug.library.Instabug
import com.example.android.instabugapp.service.BugReporter
import javax.inject.Inject

internal class InstabugReporter @Inject constructor() : BugReporter {

    override suspend fun report() {
        runCatching {
            Log.i("InstabugReporter", "show instabug")
            Instabug.show()
        }.onFailure {
            Log.e("InstabugReporter", "exception showing instabug")
            it.printStackTrace()
        }
    }
}
