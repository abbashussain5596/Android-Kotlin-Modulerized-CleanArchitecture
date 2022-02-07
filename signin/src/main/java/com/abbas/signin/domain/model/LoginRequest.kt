package com.abbas.signin.domain.model

import com.abbas.signin.data.remote.dto.LoginRequestDto

data class LoginRequest(val username: String, val password: String) {
    fun toDto() = LoginRequestDto(username, password)
}