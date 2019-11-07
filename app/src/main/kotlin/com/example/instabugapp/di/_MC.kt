package com.example.instabugapp.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.example.instabugapp.MainApplication
import com.example.instabugapp.di.modules.ApplicationModule
import com.example.android.domain.di.DomainModule
import com.example.android.instabugapp.di.MainInjectors
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        MainInjectors::class,
        DomainModule::class
    ]
)
@Suppress("ClassNaming") // MainComponent
interface _MC : AndroidInjector<MainApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()
}
