package com.habithatch.demo.core.speech

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log

/**
 * Helper class for speech recognition.
 *
 * @param context The context to use for creating the SpeechRecognizer.
 * @param onResult Callback to be called when speech recognition is successful.
 * @param endOfSpeechCallback Callback to be called when speech input ends.
 */
class SpeechRecognizerHelper(
    context: Context,
    private val onResult: (String) -> Unit,
    private val endOfSpeechCallback: () -> Unit,
) {
    private val speechRecognizer: SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)

    companion object {
        private const val TAG = "SpeechRecognizerHelper"
    }

    init {
        speechRecognizer.setRecognitionListener(
            object : RecognitionListener {
                /**
                 * onResults is called when the recognition is successful.
                 */
                override fun onResults(results: Bundle?) {
                    val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        Log.d(TAG, "Recognition successful: ${matches[0]}")
                        onResult(matches[0])
                    } else {
                        Log.d(TAG, "No recognition results")
                    }
                }

                override fun onError(error: Int) {
                    Log.e(TAG, "Recognition error: ${getErrorDescription(error)}")
                }

                override fun onReadyForSpeech(params: Bundle?) {
                    Log.d(TAG, "Ready for speech")
                }

                override fun onBeginningOfSpeech() {
                    Log.d(TAG, "Speech input started")
                }

                override fun onEndOfSpeech() {
                    Log.d(TAG, "Speech input ended")
                    endOfSpeechCallback()
                }

                override fun onPartialResults(partialResults: Bundle?) {
                    val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        Log.d(TAG, "Partial result: ${matches[0]}")
                    }
                }

                /**
                 * @suppress
                 */
                override fun onEvent(
                    eventType: Int,
                    params: Bundle?,
                ) {
                    Log.d(TAG, "Event received: $eventType")
                }

                /**
                 * @suppress
                 */
                override fun onRmsChanged(rmsdB: Float) {
                    Log.d(TAG, "RMS dB level: $rmsdB")
                }

                /**
                 * @suppress
                 */
                override fun onBufferReceived(buffer: ByteArray?) {
                    Log.d(TAG, "Audio buffer received")
                }
            },
        )
    }

    fun startListening(prompt: String = "Speak now") {
        Log.d(TAG, "Starting speech recognition")
        val intent =
            Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_PROMPT, prompt)
            }
        speechRecognizer.startListening(intent)
    }

    fun destroy() {
        Log.d(TAG, "Destroying SpeechRecognizer")
        speechRecognizer.destroy()
    }

    private fun getErrorDescription(error: Int): String =
        when (error) {
            SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
            SpeechRecognizer.ERROR_CLIENT -> "Client-side error"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "Insufficient permissions"
            SpeechRecognizer.ERROR_NETWORK -> "Network error"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "Network timeout"
            SpeechRecognizer.ERROR_NO_MATCH -> "No recognition match"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "Recognition service busy"
            SpeechRecognizer.ERROR_SERVER -> "Server error"
            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "No speech input"
            else -> "Unknown error: $error"
        }
}
