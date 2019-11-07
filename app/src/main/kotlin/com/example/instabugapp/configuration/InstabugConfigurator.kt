package com.example.instabugapp.configuration

import android.app.Application
import android.util.Log
import com.instabug.crash.CrashReporting
import com.instabug.library.Feature
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent
import com.instabug.library.ui.onboarding.WelcomeMessage
import com.example.instabugapp.BuildConfig
import com.example.android.domain.base.CoroutineScopeFacade
import com.example.android.domain.base.CoroutinesContextFacade
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class InstabugConfigurator @Inject constructor(
    private val application: Application,
    private val contextFacade: CoroutinesContextFacade,
    private val scopeFacade: CoroutineScopeFacade
) : AppConfigurator {
    override suspend fun configure() {
        scopeFacade.globalScope.launch(contextFacade.main) {
            Log.d("InstabugConfigurator", "configurator instabug")
            if (BuildConfig.DEBUG) {
                Instabug.Builder(application, "debug_token")
                    .setInvocationEvents(InstabugInvocationEvent.NONE)
                    .setConsoleLogState(Feature.State.ENABLED)
                    .setUserDataState(Feature.State.DISABLED)
                    .setTrackingUserStepsState(Feature.State.ENABLED)
                    .setInAppMessagingState(Feature.State.ENABLED)
                    .setInstabugLogState(Feature.State.ENABLED)
                    .build()
                CrashReporting.setState(Feature.State.ENABLED)
                Instabug.setWelcomeMessageState(WelcomeMessage.State.DISABLED)
            } else {
                Instabug.Builder(application, "prod_token")
                    .setInvocationEvents(InstabugInvocationEvent.NONE)
                    .setConsoleLogState(Feature.State.ENABLED)
                    .setUserDataState(Feature.State.ENABLED)
                    .setTrackingUserStepsState(Feature.State.ENABLED)
                    .setInAppMessagingState(Feature.State.ENABLED)
                    .setInstabugLogState(Feature.State.ENABLED)
                    .build()
                CrashReporting.setState(Feature.State.ENABLED)
                Instabug.setWelcomeMessageState(WelcomeMessage.State.DISABLED)
            }
        }
    }
}
