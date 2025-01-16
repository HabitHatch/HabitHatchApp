package com.habithatch.demo.data.entities

import com.habithatch.demo.core.animation.FrameStateAnimation
import javax.inject.Inject

typealias PetMoodAnimations = Map<PetMood, FrameStateAnimation>

@Suppress("ktlint:standard:annotation")
class PetMoodAnimationsFactory @Inject constructor() {
    fun create(
        animation: FrameStateAnimation,
    ): PetMoodAnimations {
        val animations = mutableMapOf<PetMood, FrameStateAnimation>()
        PetMood.entries.forEach { mood ->
            animations[mood] = animation
        }
        return animations
    }
}
