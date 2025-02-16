package com.example.grocio.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocio.dao.UserDao
import com.example.grocio.entity.User
import com.example.grocio.utils.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    var signUpState = mutableStateOf<Result<String>?>(null)
    var loginState = mutableStateOf<Result<User>?>(null)

    fun signUp(username: String, email: String, password: String, phone: String) {
        viewModelScope.launch {
            val result = repository.signUp(User(username = username, email = email, password = password, phone = phone))
            signUpState.value = if (result > 0) {
                Result.success("Sign-Up Successful!")
            } else {
                Result.failure(Exception("Email already exists!"))
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.login(email, password)
            loginState.value = if (user != null) {
                Result.success(user)
            } else {
                Result.failure(Exception("Invalid Credentials!"))
            }
        }
    }
}