package com.abbas.core.user.domain.model

import com.abbas.core.user.data.remote.dto.refreshToken.RefreshTokenRequestDto

data class RefreshTokenRequest(val token: String, val refreshToken: String) {
    fun toDto() = RefreshTokenRequestDto(token, refreshToken)
}