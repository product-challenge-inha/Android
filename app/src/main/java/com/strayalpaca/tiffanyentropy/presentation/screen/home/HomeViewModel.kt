package com.strayalpaca.tiffanyentropy.presentation.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _showNotificationDot = MutableStateFlow(true)
    val showNotificationDot = _showNotificationDot.asStateFlow()
}