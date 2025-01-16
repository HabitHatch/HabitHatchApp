package com.habithatch.demo.core.animation

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

import com.habithatch.demo.R

open class FrameStateAnimation(
    private val frames: List<Frame>,
    private var currentIndex: Int = 0,
) : IStateAnimation {
    private var job: Job? = null
    private var _state = MutableStateFlow(frames[currentIndex].imageRes)
    override val state: StateFlow<Int> = _state

    override fun start() {
        job =
            CoroutineScope(Dispatchers.Default).launch {
                while (isActive) {
                    delay(frames[currentIndex].duration)
                    nextImage()
                }
            }
    }

    override fun stop() {
        job?.cancel()
        job = null
    }

    private fun nextImage() {
        currentIndex = (currentIndex + 1) % frames.size
        _state.value = frames[currentIndex].imageRes
    }

    companion object {
        fun createFromFrames(
            frames: List<Frame>,
        ) = FrameStateAnimation(frames = frames)

        fun createFromImages(
            images: List<ImageResource>,
            duration: Long = 1000,
        ) = FrameStateAnimation(
            frames = images.map { Frame(it, duration) },
        )
    }

    override fun equals(other: Any?): Boolean = other is FrameStateAnimation && frames == other.frames

    override fun hashCode(): Int = this.frames.hashCode()

    override fun toString(): String =
        """
        FrameStateAnimation(
        currentIndex=$currentIndex,
        frames=$frames,
        )
        """.trimIndent()
}
