package com.example.instabugapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.example.instabugapp.configuration.AppConfigurator
import com.example.instabugapp.di.Dagger_MC
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainApplication : DaggerApplication() {

    @Inject
    internal lateinit var configurators: @JvmSuppressWildcards Set<AppConfigurator>

    override fun onCreate() {
        super.onCreate()
        runBlocking {
            withContext(Dispatchers.Default) {
                configurators.forEach {
                    launch { it.configure() }
                }
            }
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        Dagger_MC.builder().create(this)
}
