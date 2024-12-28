package com.habithatch.demo.features.ai

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.util.Log

import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import com.habithatch.demo.core.speech.SpeechRecognizerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AIAssistantViewModel
    @Inject
    constructor(
        private val application: Application,
    ) : ViewModel() {
        private val _text = MutableStateFlow("")
        val text: StateFlow<String> = _text

        private val _isListening = MutableStateFlow(false)
        val isListening: StateFlow<Boolean> = _isListening

        private val _hasRecordAudioPermission = MutableStateFlow(hasRecordAudioPermission())
        val hasRecordAudioPermission: StateFlow<Boolean> = _hasRecordAudioPermission

        private val _showPermissionDialog = MutableStateFlow(false)
        val showPermissionDialog: StateFlow<Boolean> = _showPermissionDialog

        private val speechRecognizerHelper =
            SpeechRecognizerHelper(
                application,
                onResult = { recordedText ->
                    _text.value = recordedText
                    _isListening.value = false
                },
                endOfSpeechCallback = {
                    _isListening.value = false
                },
            )

        fun startListening() {
            if (!hasRecordAudioPermission()) {
                _showPermissionDialog.value = true
                return
            }
            _showPermissionDialog.value = false
            _isListening.value = true
            speechRecognizerHelper.startListening()
        }

        private fun hasRecordAudioPermission(): Boolean =
            ContextCompat.checkSelfPermission(
                application,
                Manifest.permission.RECORD_AUDIO,
            ) == PackageManager.PERMISSION_GRANTED

        override fun onCleared() {
            Log.d("AIViewModel", "onCleared")
            speechRecognizerHelper.destroy()
            super.onCleared()
        }
    }
