package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.data.entities.GoalEntity
import java.time.Instant
import java.util.UUID

/**
 * [GoalModel] represents a goal.
 *
 * @param title the title of the goal
 * @param status the status of the goal
 * @param priority the priority of the goal
 * @param createdAt the creation date of the goal
 * @param isDraft whether the goal is a draft
 */
@ConsistentCopyVisibility
@Immutable
data class GoalModel private constructor(
    val userId: UUID,
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
    }

    @Immutable
    data class Status(
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean = false,
    ) {
        /** @suppress */
        override fun equals(other: Any?) = other is Status && other.label == label

        /** @suppress */
        override fun hashCode() = label.hashCode()
    }

    fun isDone(): Boolean = this.status.isDone

    /** @suppress */
    fun copy(
        title: String? = null,
        status: Status? = null,
        priority: Priority? = null,
    ) = GoalModel(
        userId = userId,
        title = title ?: this.title,
        status = status ?: this.status,
        priority = priority ?: this.priority,
        createdAt = createdAt,
        isDraft = isDraft,
    )

    fun getCreatedAtOrNow() = createdAt ?: Instant.now()

    fun getUniqueId() = title.hashCode() + 31 * getCreatedAtOrNow().toEpochMilli()

    @Suppress("ktlint:standard:function-expression-body")
    class Factory {
        fun createFromEntity(
            entity: GoalEntity,
            status: Status,
            priority: Priority,
        ): GoalModel {
            return GoalModel(
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
        ): GoalModel {
            return GoalModel(
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
