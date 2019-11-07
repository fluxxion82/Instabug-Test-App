package com.example.instabugapp.configuration

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import javax.inject.Inject

internal class AndroidThreeTenConfigurator @Inject constructor(
    private val application: Application
) : AppConfigurator {

    override suspend fun configure() =
        AndroidThreeTen.init(application)
}
