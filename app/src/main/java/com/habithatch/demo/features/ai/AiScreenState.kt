package com.habithatch.demo.features.ai

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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
