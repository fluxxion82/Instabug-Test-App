package com.example.android.instabugapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import dagger.Module
import dagger.Provides
import com.example.android.instabugapp.R
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    internal fun provideSharedPreferences(app: Context): SharedPreferences {
        return app.getSharedPreferences(
            app.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    internal fun provideBroadcastManager(context: Context): LocalBroadcastManager = LocalBroadcastManager.getInstance(context)
}
