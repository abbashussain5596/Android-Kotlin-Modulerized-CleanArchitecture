package com.abbas.signin.data.remote.service

import com.abbas.signin.data.remote.dto.LoginRequestDto
import com.abbas.signin.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("api/login")
    suspend fun login(@Body request: LoginRequestDto): LoginResponseDto
}