package com.abbas.signin.data.remote.dto

import com.abbas.core.base.BaseResponse
import com.abbas.core.user.data.remote.dto.UserDto


data class LoginResponseDto(val user: UserDto) : BaseResponse()