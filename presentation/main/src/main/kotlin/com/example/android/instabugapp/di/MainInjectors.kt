package com.example.android.instabugapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.android.instabugapp.ui.homescreen.HomeRootFragment
import com.example.android.instabugapp.ui.homescreen.home.HomeFragment
import com.example.android.instabugapp.ui.homescreen.settings.SettingsMainFragment
import com.example.android.instabugapp.ui.homescreen.settings.support.SupportFragment
import com.example.android.instabugapp.ui.main._MA

@Module(includes = [MainModule::class])
abstract class MainInjectors {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): _MA

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun homeRootFragment(): HomeRootFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun homeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun settingsMain(): SettingsMainFragment

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun supportFragment(): SupportFragment
}
