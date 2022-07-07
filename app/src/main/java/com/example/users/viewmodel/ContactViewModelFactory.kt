package com.example.users.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.users.network.RetroRepository

class ContactViewModelFactory(private val contactRepo:RetroRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactViewModel(contactRepo) as T
    }
}