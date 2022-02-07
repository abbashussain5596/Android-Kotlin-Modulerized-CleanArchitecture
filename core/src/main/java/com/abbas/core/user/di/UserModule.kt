package com.abbas.core.user.di

import com.abbas.core.db.AppDatabase
import com.abbas.core.user.data.remote.service.UserService
import com.abbas.core.user.data.repositoryImpl.UserRepositoryImpl
import com.abbas.core.user.domain.repository.UserRepository
import com.abbas.core.user.domain.useCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideUserRepository(
        userService: UserService,
        appDatabase: AppDatabase
    ): UserRepository =
        UserRepositoryImpl(userService, appDatabase.userDao())

    @Provides
    @Singleton
    fun provideUseCaseDeleteUser(userRepository: UserRepository) = UseCaseDeleteUser(userRepository)

    @Provides
    @Singleton
    fun provideUseCaseGetUser(userRepository: UserRepository) = UseCaseGetUser(userRepository)

    @Provides
    @Singleton
    fun provideUseCaseGetLastUser(userRepository: UserRepository) =
        UseCaseGetLastUser(userRepository)

    @Provides
    @Singleton
    fun provideUseCaseInsertOrUpdateUser(userRepository: UserRepository) =
        UseCaseInsertOrUpdateUser(userRepository)

    @Provides
    @Singleton
    fun provideUseCaseRefreshToken(userRepository: UserRepository) =
        UseCaseRefreshToken(userRepository)

}