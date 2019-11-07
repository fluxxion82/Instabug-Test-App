package com.example.android.domain.user.services

import com.example.android.domain.user.models.UserEvent
import kotlinx.coroutines.channels.ReceiveChannel

interface UserEventsService {

    fun events(): ReceiveChannel<UserEvent>

    suspend fun update(event: UserEvent)
}
