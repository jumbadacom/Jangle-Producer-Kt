package com.example.jangleproducerkt.ui.view.fragments

import androidx.lifecycle.ViewModel
import com.example.jangleproducerkt.ui.repository.UserRepository
import javax.inject.Inject


class ProfileViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {

}