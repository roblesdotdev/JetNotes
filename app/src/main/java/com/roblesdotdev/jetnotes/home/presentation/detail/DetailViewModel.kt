package com.roblesdotdev.jetnotes.home.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.roblesdotdev.jetnotes.home.domain.models.Note
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import com.roblesdotdev.jetnotes.navigation.NavDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val homeRepository: HomeRepository
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    init {
        val args = savedStateHandle.toRoute<NavDestination.Detail>()
        if (args.id != null) {
            viewModelScope.launch {
                state = state.copy(isLoading = true)
                val note = homeRepository.getNoteById(args.id)
                state = state.copy(
                    id = note.id,
                    title = note.title,
                    description = note.description,
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.OnChangeDescription -> {
                state = state.copy(
                    description = event.description
                )
            }

            is DetailEvent.OnChangeTitle -> {
                state = state.copy(
                    title = event.title
                )
            }

            DetailEvent.OnSave -> {
                viewModelScope.launch {
                    val note = Note(
                        id = state.id ?: UUID.randomUUID().toString(),
                        title = state.title,
                        description = state.description
                    )
                    homeRepository.upsertNote(note)
                    state = state.copy(
                        isSaved = true
                    )
                }
            }

            DetailEvent.OnDelete -> {
                val id = state.id
                if (id != null) {
                    viewModelScope.launch {
                        homeRepository.deleteNote(id)
                    }
                }
            }
        }
    }
}