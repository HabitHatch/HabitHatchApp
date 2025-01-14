package com.habithatch.demo.data.entities

open class Animation

data class Frame(
    val duration: Int,
    val imageRes: Int,
)

data class FrameAnimation(
    val frames: List<Frame>,
    val loop: Boolean,
) : Animation() {
    class Builder {
        private val frames = mutableListOf<Frame>()
        private var loop = false

        fun addFrame(
            duration: Int,
            imageRes: Int,
        ) {
            frames.add(Frame(duration, imageRes))
        }

        fun addFrames(
            images: List<Int>,
            duration: Int,
        ) {
            images.forEach { imageRes ->
                frames.add(Frame(duration, imageRes))
            }
        }

        fun loop(loop: Boolean) {
            this.loop = loop
        }

        fun build() = FrameAnimation(frames, loop)
    }
}
