package com.abbas.core.util.session

import com.abbas.core.user.domain.model.RefreshTokenRequest
import com.abbas.core.user.domain.model.User
import com.abbas.core.user.domain.useCase.UseCaseGetLastUser
import com.abbas.core.user.domain.useCase.UseCaseRefreshToken
import java.util.*
import dagger.Lazy
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    private val useCaseGetLastUser: Lazy<UseCaseGetLastUser>,
    private val useCaseRefreshToken: Lazy<UseCaseRefreshToken>
) {

    suspend fun getToken(): String? {
        val userResult = useCaseGetLastUser.get().invoke().firstOrNull()
        val user = userResult?.data ?: return null
        if (isTokenExpired(user)) {
            val updatedToken = useCaseRefreshToken.get()
                .invoke(RefreshTokenRequest(user.token, user.refreshToken)).firstOrNull()
            return updatedToken?.data
        }
        return null
    }

    private fun isTokenExpired(user: User) =
        ((user.lastTokenRefreshTime) + (user.tokenExpiryTime)) <= Calendar.getInstance().time.time
}

