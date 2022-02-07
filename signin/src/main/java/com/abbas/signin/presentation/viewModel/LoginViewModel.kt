package com.abbas.signin.presentation.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.abbas.core.base.BaseViewModel
import com.abbas.core.util.result.ResultState
import com.abbas.signin.domain.model.LoginRequest
import com.abbas.signin.domain.useCase.UseCaseLogin
import com.abbas.signin.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCaseLogin: UseCaseLogin
) : BaseViewModel() {

    private val _loginState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState
    val bindingObject = BindingObject()

    fun login(un: String, pass: String) {
        viewModelScope.launch {
            useCaseLogin(LoginRequest(un, pass)).onEach { result ->
                when (result) {
                    is ResultState.Success -> {
                        showLoader(false)
                        _loginState.value = loginState.value.copy(
                            isSuccessful = true
                        )
                        showSnackBar(message = result.message ?: "")
                    }
                    is ResultState.Error -> {
                        showLoader(false)
                        _loginState.value = loginState.value.copy(
                            isSuccessful = false
                        )
                        showSnackBar(result.message ?: "Unknown error")
                    }
                    is ResultState.Loading -> {
                        showLoader(true)
                    }
                }
            }.launchIn(this)
        }
    }

    class BindingObject {
        val userName = ObservableField("")
        val password = ObservableField("")
    }
}