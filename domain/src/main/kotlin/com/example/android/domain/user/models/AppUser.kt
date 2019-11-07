package com.example.android.domain.user.models

sealed class AppUser {
    object Anonymous : AppUser()
    data class LoggedIn(
        val id: Long,
        val email: String,
        val analyticsId: Long,
        val accessToken: String
    ) : AppUser()
}
