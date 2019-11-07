package com.example.android.instabugapp.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ServiceScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ReceiverScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NestedFragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NestedTwiceFragmentScope
