package com.abbas.core.user.domain.useCase

import com.abbas.core.user.domain.repository.UserRepository
import javax.inject.Inject

class UseCaseGetLastUser @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke() = userRepository.getLastUser()
}