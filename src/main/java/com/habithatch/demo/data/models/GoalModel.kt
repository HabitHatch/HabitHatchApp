package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.data.entities.HabitEntity
import java.time.Instant
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
    val title: String,
    val status: Status,
    val priority: Priority,
    val createdAt: Instant?,
    val isDraft: Boolean = false,
) {
    @Immutable
    data class Priority(
        val label: String,
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
            /**
             * @suppress
             */
            object VeryLow : Importance(0)

            /**
             * @suppress
             */
            object Low : Importance(10)

            /**
             * @suppress
             */
            object Normal : Importance(20)

            /**
             * @suppress
             */
            object High : Importance(30)

            /**
             * @suppress
             */
            object VeryHigh : Importance(40)

            override fun compareTo(other: Importance) = this.value.compareTo(other.value)
        }

        fun isImportant() = importance >= Importance.High
    }

    @Immutable
    data class Status(
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean = false,
    ) {
        /**
         * @suppress
         */
        override fun equals(other: Any?): Boolean = other is Status && other.label == label

        /**
         * @suppress
         */
        override fun hashCode(): Int = label.hashCode()
    }

    fun isDone(): Boolean = this.status.isDone

    /**
     * @suppress
     */
    fun copy(
        title: String? = null,
        status: Status? = null,
        priority: Priority? = null,
    ): HabitModel =
        HabitModel(
            title = title ?: this.title,
            status = status ?: this.status,
            priority = priority ?: this.priority,
            createdAt = createdAt,
            isDraft = isDraft,
        )

    fun getCreatedAtOrNow(): Instant = createdAt ?: Instant.now()

    fun getUniqueId() = title.hashCode() + 31 * getCreatedAtOrNow().toEpochMilli()

    class Factory
        @Inject
        constructor() {
            fun createFromEntity(
                entity: HabitEntity,
                status: Status,
                priority: Priority,
            ): HabitModel =
                HabitModel(
                    title = entity.title,
                    status = status,
                    priority = priority,
                    createdAt = entity.createdAt,
                    isDraft = false,
                )

            fun createDraft(
                title: String = "",
                status: Status,
                priority: Priority,
            ) = HabitModel(
                title = title,
                status = status,
                priority = priority,
                createdAt = null,
                isDraft = true,
            )

            fun createDraft(
                status: Status,
                priority: Priority,
            ) = createDraft("", status, priority)

            fun createExample(
                title: String,
                status: Status,
                priority: Priority,
                createdAt: Instant,
            ) = HabitModel(
                title = title,
                status = status,
                priority = priority,
                createdAt = createdAt,
                isDraft = true,
            )
        }
}
