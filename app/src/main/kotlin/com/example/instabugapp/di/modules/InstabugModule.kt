package com.example.instabugapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import com.example.instabugapp.configuration.AppConfigurator
import com.example.instabugapp.configuration.InstabugConfigurator
import com.example.instabugapp.configuration.InstabugReporter
import com.example.android.domain.user.services.UserAwareService
import com.example.android.instabugapp.service.BugReporter

@Module
internal abstract class InstabugModule {

    @Binds
    abstract fun reporter(instabug: InstabugReporter): BugReporter

    @Binds
    @IntoSet
    abstract fun configurator(instabug: InstabugConfigurator): AppConfigurator
}
