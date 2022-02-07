package com.abbas.signin.data.repositoryImpl

import com.abbas.core.user.domain.model.User
import com.abbas.signin.data.remote.service.LoginService

import com.abbas.core.util.result.ResultState
import com.abbas.signin.domain.model.LoginRequest
import com.abbas.signin.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
) : LoginRepository {

    override fun submitLogin(loginRequest: LoginRequest): Flow<ResultState<User>> = flow {
        emit(ResultState.Loading())
        val resp = loginService.login(loginRequest.toDto())
        emit(ResultState.Success(data = resp.user.toUser(), message = resp.message))
    }

}