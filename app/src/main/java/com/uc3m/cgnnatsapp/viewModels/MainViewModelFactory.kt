package com.uc3m.cgnnatsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uc3m.cgnnatsapp.repository.RepositoryApi

class MainViewModelFactory(private val repositoryApi: RepositoryApi): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ApiViewModel(repositoryApi)  as T
    }
}