package com.roblesdotdev.jetnotes.home.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {
    var state by mutableStateOf(ListState())
        private set

    init {
        viewModelScope.launch {
            homeRepository.getAllNotes()
                .onStart {
                    state = state.copy(isLoading = true)
                }
                .collectLatest { notes ->
                state = state.copy(
                    notes = notes,
                    isLoading = false
                )
            }
        }
    }
}