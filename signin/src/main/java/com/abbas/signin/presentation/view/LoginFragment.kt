package com.abbas.signin.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.abbas.core.base.BaseFragment
import com.abbas.signin.databinding.ActivityLoginBinding
import com.abbas.signin.presentation.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment:BaseFragment() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUiEvents(viewModel)
        binding.viewModel = viewModel
        subscribeToObservables()
    }

    private fun subscribeToObservables() {
        lifecycleScope.launch {
            viewModel.loginState.collectLatest {
                if (it.isSuccessful) {
                    Timber.e("Successful")
//                    delay(1500)
//                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
//                    startActivity(intent)
//                    finish()
                }
            }
        }
    }


}