package com.habithatch.demo.data.entities

import android.util.Log

import com.habithatch.demo.core.animation.FrameStateAnimation
import com.habithatch.demo.core.animation.ImageResource
import com.habithatch.demo.core.util.allDone
import com.habithatch.demo.data.models.GoalModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * [Pet] represents a pet
 */
data class Pet(
    val id: Int,
    val name: String,
    val coverImage: ImageResource,
    private val petMoodAnimations: PetMoodAnimations,
    private var mood: PetMood? = null,
) {
    var animationState: MutableStateFlow<FrameStateAnimation?> = MutableStateFlow(null)

    init {
        Log.d("Pet", "Pet created: $this")
    }

    fun updateMood(allGoals: Collection<GoalModel>) {
        mood = if (allGoals.allDone()) PetMood.HAPPY else PetMood.SAD
        animationState.value = petMoodAnimations[mood]
    }

    override fun equals(other: Any?): Boolean = other is Pet && other.id == id

    override fun hashCode(): Int = id

    override fun toString(): String =
        """
        Pet(
            id=$id,
            name='$name',
            coverImage=$coverImage,
            petMoodAnimations=$petMoodAnimations,
            mood=$mood,
        """.trimIndent()
}
