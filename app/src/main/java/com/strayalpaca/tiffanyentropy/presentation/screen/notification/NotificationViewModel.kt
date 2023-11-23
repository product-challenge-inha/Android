package com.strayalpaca.tiffanyentropy.presentation.screen.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strayalpaca.tiffanyentropy.presentation.model.RequestState
import com.strayalpaca.tiffanyentropy.presentation.screen.notification.model.NotificationScreenEvent
import com.strayalpaca.tiffanyentropy.presentation.screen.notification.model.NotificationScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {
    private val events = Channel<NotificationScreenEvent>()
    val state: StateFlow<NotificationScreenState> = events.receiveAsFlow()
        .runningFold(NotificationScreenState(), ::reduce)
        .stateIn(viewModelScope, SharingStarted.Eagerly, NotificationScreenState())

    private fun reduce(state: NotificationScreenState, events: NotificationScreenEvent): NotificationScreenState {
        return when (events) {
            NotificationScreenEvent.NotificationLoading -> {
                state.copy(notificationLoadState = RequestState.LOADING)
            }
            NotificationScreenEvent.NotificationLoadFailure -> {
                state.copy(notificationLoadState = RequestState.FAILURE)
            }
            is NotificationScreenEvent.NotificationLoadSuccess -> {
                state.copy(notificationLoadState = RequestState.IDLE, notificationList = events.notifications)
            }
        }
    }
}