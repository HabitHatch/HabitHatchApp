package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.data.entities.HabitEntity
import java.time.Instant
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

/**
 * [HabitModel] represents a habit.
 *
 * @param title the title of the habit
 * @param status the status of the habit
 * @param priority the priority of the habit
 * @param createdAt the creation date of the habit
 * @param isDraft whether the habit is a draft
 */
@ConsistentCopyVisibility
@Immutable
data class HabitModel private constructor(
    val userId: UUID,
    val title: String,
    val status: Status,
    val priority: Priority,
    val createdAt: Instant?,
    val isDraft: Boolean = false,
) {
    @Immutable
    data class Priority(
        val id: Int = generateId(),
        val labelRes: Int,
        val importance: Importance,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ) {
        /**
         * Importance of the priority.
         */
        @Suppress("unused")
        sealed class Importance(
            val value: Int,
        ) : Comparable<Importance> {
            /** @suppress */
            object VeryLow : Importance(10)

            /** @suppress */
            object Low : Importance(20)

            /** @suppress */
            object Normal : Importance(30)

            /** @suppress */
            object High : Importance(40)

            /** @suppress */
            object VeryHigh : Importance(50)

            override fun compareTo(other: Importance) = this.value.compareTo(other.value)
        }

        fun isImportant() = importance >= Importance.High

        companion object {
            private val idGenerator = AtomicInteger(0)

            private fun generateId(): Int = idGenerator.incrementAndGet()
        }
    }

    @Immutable
    data class Status(
        val id: Int = generateId(),
        val labelRes: Int,
        val stepNumber: Int,
        val isDone: Boolean = false,
    ) {
        /** @suppress */
        override fun equals(other: Any?) = other is Status && other.stepNumber == stepNumber

        /** @suppress */
        override fun hashCode(): Int = stepNumber
    }

    fun isDone(): Boolean = this.status.isDone

    /** @suppress */
    fun copy(
        title: String? = null,
        status: Status? = null,
        priority: Priority? = null,
    ) = HabitModel(
        userId = userId,
        title = title ?: this.title,
        status = status ?: this.status,
        priority = priority ?: this.priority,
        createdAt = createdAt,
        isDraft = isDraft,
    )

    fun getCreatedAtOrNow() = createdAt ?: Instant.now()

    fun getUniqueId() = title.hashCode() + 31 * getCreatedAtOrNow().toEpochMilli()

    companion object {
        private val idGenerator = AtomicInteger(0)

        private fun generateId(): Int = idGenerator.incrementAndGet()
    }

    @Suppress("ktlint:standard:annotation", "ktlint:standard:function-expression-body")
    class Factory @Inject constructor() {
        fun createFromEntity(
            entity: HabitEntity,
            status: Status,
            priority: Priority,
        ): HabitModel {
            return HabitModel(
                userId = entity.userId,
                title = entity.title,
                status = status,
                priority = priority,
                createdAt = entity.createdAt,
            )
        }

        fun createDraft(
            userId: UUID,
            status: Status,
            priority: Priority,
            title: String = "",
            createdAt: Instant? = null,
        ): HabitModel {
            return HabitModel(
                userId = userId,
                title = title,
                status = status,
                priority = priority,
                createdAt = createdAt,
                isDraft = true,
            )
        }
    }
}
