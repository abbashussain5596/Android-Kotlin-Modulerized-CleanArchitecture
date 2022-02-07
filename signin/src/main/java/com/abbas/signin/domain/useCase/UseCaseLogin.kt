package com.abbas.signin.domain.useCase

import com.abbas.signin.domain.model.LoginRequest
import com.abbas.signin.domain.repository.LoginRepository
import javax.inject.Inject

class UseCaseLogin @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(loginRequest: LoginRequest) = loginRepository.submitLogin(loginRequest)
}