package com.example.stackoverflowuser.ui.main

import androidx.lifecycle.*
import com.example.stackoverflowuser.data.SORepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val soRepository: SORepository) : ViewModel() {
    private val _usersLiveData = MutableLiveData<List<UserUiModel>>()
    val usersLiveData: LiveData<List<UserUiModel>>
        get() =
            _usersLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    fun fetchUsers() {
        viewModelScope.launch {
            _loadingLiveData.value = true
            val users = soRepository.getUsers(1, 30)
            _usersLiveData.value = users.map {
                UserUiModel(
                    name = it.name,
                    avatar = it.avatar,
                    reputation = it.reputation,
                    location = it.location,
                    isBookmarked = false,
                    lastSeen = it.lastAccess
                )
            }
            _loadingLiveData.value = false
        }
    }
}

class MainViewModelFactory(private val soRepository: SORepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(soRepository) as T
}