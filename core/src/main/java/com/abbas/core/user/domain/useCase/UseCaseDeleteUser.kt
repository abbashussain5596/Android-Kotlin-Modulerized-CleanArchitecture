package com.abbas.core.user.domain.useCase

import com.abbas.core.user.domain.repository.UserRepository
import javax.inject.Inject

class UseCaseDeleteUser @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(id: String) = userRepository.deleteUser(id)
}