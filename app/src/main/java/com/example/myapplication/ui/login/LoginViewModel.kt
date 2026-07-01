package com.example.myapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.User
import com.example.myapplication.data.repository.MockDataRepository
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Initial : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val user: User) : LoginUiState()
    data class Error(val error: String) : LoginUiState()
}

class LoginViewModel : ViewModel() {
    private val repository = MockDataRepository()

    private val _uiState = MutableLiveData<LoginUiState>(LoginUiState.Initial)
    val uiState: LiveData<LoginUiState> = _uiState

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = LoginUiState.Error("Email and password are required")
            return
        }

        _uiState.value = LoginUiState.Loading
        viewModelScope.launch {
            val result = repository.login(email, password)
            result.fold(
                onSuccess = { user ->
                    _uiState.value = LoginUiState.Success(user)
                },
                onFailure = { error ->
                    _uiState.value = LoginUiState.Error(error.message ?: "An unknown error occurred")
                }
            )
        }
    }
}
