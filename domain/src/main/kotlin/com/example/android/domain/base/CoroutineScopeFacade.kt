package com.example.android.domain.base

import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

interface CoroutineScopeFacade {
    val globalScope: CoroutineScope
}

internal class DefaultScopeFacade @Inject constructor(
    contextFacade: CoroutinesContextFacade
) : CoroutineScopeFacade {
    val job = SupervisorJob()
    override val globalScope: CoroutineScope = CoroutineScope(contextFacade.default + job)
}
