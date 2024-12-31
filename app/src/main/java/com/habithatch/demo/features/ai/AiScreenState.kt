package com.habithatch.demo.features.ai

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * Represents the state of the AI screen.
 *
 * @param text The text to display on the screen.
 * @param isListening Whether the AI assistant is currently listening.
 * @param showPermissionDialog Whether to show the permission dialog.
 * @param onStartListening The callback to start listening.
 */
@Stable
class AIScreenState(
    val text: String,
    val isListening: Boolean,
    val showPermissionDialog: Boolean,
    val onStartListening: () -> Unit,
)

@Composable
fun rememberAIScreenState(
    viewModel: AIAssistantViewModel = hiltViewModel(),
): AIScreenState {
    val text by viewModel.text.collectAsStateWithLifecycle()
    val isListening by viewModel.isListening.collectAsStateWithLifecycle()
    val showPermissionDialog by viewModel.showPermissionDialog.collectAsStateWithLifecycle()

    return remember(text, isListening, showPermissionDialog) {
        AIScreenState(
            text = text,
            isListening = isListening,
            showPermissionDialog = showPermissionDialog,
            onStartListening = { viewModel.startListening() },
        )
    }
}
