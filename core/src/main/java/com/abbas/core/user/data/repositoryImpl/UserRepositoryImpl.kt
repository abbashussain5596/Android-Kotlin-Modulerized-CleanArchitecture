package com.abbas.core.user.data.repositoryImpl

import com.abbas.core.user.data.local.UserDao
import com.abbas.core.user.data.remote.service.UserService
import com.abbas.core.user.domain.model.RefreshTokenRequest
import com.abbas.core.user.domain.model.User
import com.abbas.core.user.domain.repository.UserRepository
import com.abbas.core.util.result.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao
) : UserRepository {

    override fun insertOrUpdateUser(user: User): Flow<ResultState<Boolean>> = flow {
        emit(ResultState.Loading())
        userDao.insert(user.toEntity())
        emit(ResultState.Success(data = true))
    }

    override fun getUser(id: String): Flow<ResultState<User>> = flow {
        emit(ResultState.Loading())
        val user = userDao.getUser(id)
        emit(ResultState.Success(data = user.toUser()))
    }

    override fun getLastUser(): Flow<ResultState<User>> = flow {
        emit(ResultState.Loading())
        val user = userDao.getLastUser()
        emit(ResultState.Success(data = user.toUser()))
    }

    override fun deleteUser(id: String): Flow<ResultState<Boolean>> = flow {
        emit(ResultState.Loading())
        userDao.deleteUser(id)
        emit(ResultState.Success(data = true))
    }

    override fun refreshToken(request: RefreshTokenRequest): Flow<ResultState<String>> = flow {
        emit(ResultState.Loading())
        val resp = userService.refreshToken(request.toDto())
        emit(ResultState.Success(data = resp.refreshToken))
    }

}