package com.abbas.core.user.domain.repository

import com.abbas.core.user.domain.model.RefreshTokenRequest
import com.abbas.core.user.domain.model.User
import com.abbas.core.util.result.ResultState
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun insertOrUpdateUser(user: User): Flow<ResultState<Boolean>>

    fun getUser(id: String): Flow<ResultState<User>>

    fun getLastUser(): Flow<ResultState<User>>

    fun deleteUser(id: String): Flow<ResultState<Boolean>>

    fun refreshToken(request: RefreshTokenRequest): Flow<ResultState<String>>

}