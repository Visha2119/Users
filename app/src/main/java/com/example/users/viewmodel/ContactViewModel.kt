package com.example.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.users.model.RepositoriesList
import com.example.users.network.RetroRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@AndroidEntryPoint
 class ContactViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {

    fun getAllRepositoryList(): LiveData<RepositoriesList> {
        return  repository.getAllRecords()
    }

    fun makeApiCall(){
        repository.makeApiCall("30")
    }
}