package com.abbas.core.user.data.remote.dto.refreshToken

import com.abbas.core.base.BaseResponse

data class RefreshTokenResponseDto(val token: String, val refreshToken: String) : BaseResponse()