package com.roblesdotdev.jetnotes.home.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.roblesdotdev.jetnotes.navigation.NavDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        val args = savedStateHandle.toRoute<NavDestination.Detail>()
        state = state.copy(
            id = args.id
        )
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.OnChangeDescription -> {
                state.copy(
                    description = event.description
                )
            }

            is DetailEvent.OnChangeTitle -> {
                state.copy(
                    title = event.title
                )
            }

            DetailEvent.OnSave -> {}
        }
    }
}