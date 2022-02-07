package com.abbas.signin.di

import com.abbas.signin.data.remote.service.LoginService
import com.abbas.signin.data.repositoryImpl.LoginRepositoryImpl
import com.abbas.signin.domain.repository.LoginRepository
import com.abbas.signin.domain.useCase.UseCaseLogin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService =
        retrofit.create(LoginService::class.java)

    @Provides
    @Singleton
    fun provideLoginRepository(
        loginService: LoginService
    ): LoginRepository =
        LoginRepositoryImpl(loginService)

    @Provides
    @Singleton
    fun provideUseCaseLogin(loginRepository: LoginRepository) = UseCaseLogin(loginRepository)
}