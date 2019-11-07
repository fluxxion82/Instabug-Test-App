package com.example.instabugapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import com.example.instabugapp.MainApplication
import com.example.instabugapp.configuration.AndroidThreeTenConfigurator
import com.example.instabugapp.configuration.AppConfigurator

@Module(includes = [InstabugModule::class])
internal abstract class ApplicationModule {

    @Binds
    abstract fun context(application: MainApplication): Context

    @Binds
    abstract fun application(application: MainApplication): Application

    @Binds
    @IntoSet
    abstract fun androidThreeTen(instabug: AndroidThreeTenConfigurator): AppConfigurator
}
