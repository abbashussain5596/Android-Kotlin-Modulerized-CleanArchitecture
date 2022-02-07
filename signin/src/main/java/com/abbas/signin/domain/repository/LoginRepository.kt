package com.abbas.signin.domain.repository

import com.abbas.core.user.domain.model.User
import com.abbas.signin.domain.model.LoginRequest
import com.abbas.core.util.result.ResultState
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun submitLogin(loginRequest: LoginRequest): Flow<ResultState<User>>
}