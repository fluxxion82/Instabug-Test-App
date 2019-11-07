package com.example.android.domain.di

import com.example.android.domain.base.CoroutineScopeFacade
import com.example.android.domain.base.CoroutinesContextFacade
import com.example.android.domain.base.DefaultContextFacade
import com.example.android.domain.base.DefaultScopeFacade
import dagger.Binds
import dagger.Module
import dagger.Provides
import com.example.android.domain.user.persistences.InMemoryUserEventsPersistence
import com.example.android.domain.user.services.UserEventsService
import org.threeten.bp.Clock

@Module
abstract class DomainModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun clock() = Clock.systemDefaultZone()
    }

    @Binds
    internal abstract fun dispatchersFacade(implementation: DefaultContextFacade): CoroutinesContextFacade

    @Binds
    internal abstract fun scopeFacade(implementation: DefaultScopeFacade): CoroutineScopeFacade

    @Binds
    internal abstract fun userEvents(implementation: InMemoryUserEventsPersistence): UserEventsService
}
