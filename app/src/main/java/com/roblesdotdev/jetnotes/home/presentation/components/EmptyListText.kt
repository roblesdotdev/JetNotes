package com.roblesdotdev.jetnotes.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@Composable
fun EmptyListText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val annotatedText = buildAnnotatedString {
        append("There are no notes yet. ")
        pushStringAnnotation(tag = "ADD_NOTE", annotation = "add_note")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Medium
            )
        ) {
            append("Add one now.")
        }
        pop()
    }

    Text(annotatedText, modifier = modifier.clickable {
        val annotation = annotatedText.getStringAnnotations(
            tag = "ADD_NOTE",
            start = 0,
            end = annotatedText.length
        ).firstOrNull()
        if (annotation != null) {
            onClick()
        }
    })
}
