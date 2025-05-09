package com.roblesdotdev.jetnotes.home.presentation.detail

sealed class DetailEvent {
    data class OnChangeTitle(val title: String) : DetailEvent()
    data class OnChangeDescription(val description: String) : DetailEvent()
    object OnSave : DetailEvent()
    object OnDelete : DetailEvent()
}