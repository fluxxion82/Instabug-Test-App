package com.example.android.domain.user.services

import com.example.android.domain.user.models.AppUser

interface UserAwareService {
    suspend fun onUserChanged(user: AppUser)
}
