package com.example.android.domain.user.models

sealed class UserEvent {
    data class LoginChanged(val user: AppUser) : UserEvent()
}
