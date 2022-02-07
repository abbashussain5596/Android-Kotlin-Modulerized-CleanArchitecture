package com.abbas.core.user.data.remote.dto

import com.abbas.core.user.data.local.UserEntity
import com.abbas.core.user.domain.model.User

data class UserDto(
    val id: String,
    val fullName: String,
    val email: String,
    val profilePicture: String,
    val token: String,
    val refreshToken: String,
    val tokenExpiryTime: Long
) {
    fun toUserEntity() =
        UserEntity(id, fullName, email, profilePicture, token, refreshToken, tokenExpiryTime)

    fun toUser() =
        User(id, fullName, email, profilePicture, token, refreshToken, tokenExpiryTime)
}