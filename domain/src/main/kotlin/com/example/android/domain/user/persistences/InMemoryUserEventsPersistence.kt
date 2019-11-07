package com.example.android.domain.user.persistences

import com.example.android.domain.base.CoroutinesContextFacade
import com.example.android.domain.user.models.UserEvent
import com.example.android.domain.user.services.UserEventsService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.withContext

@Singleton
internal class InMemoryUserEventsPersistence @Inject constructor(
    private val contextFacade: CoroutinesContextFacade
) : UserEventsService {

    private val channel = BroadcastChannel<UserEvent>(1)

    override fun events(): ReceiveChannel<UserEvent> = channel.openSubscription()

    override suspend fun update(event: UserEvent) = withContext(contextFacade.default) {
        channel.send(event)
    }
}
