package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.data.entities.GoalEntity
import java.time.Instant
import javax.inject.Inject

@ConsistentCopyVisibility
@Immutable
data class GoalModel private constructor(
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
        @Suppress("unused")
        sealed class Importance(
            val value: Int,
        ) : Comparable<Importance> {
            object VeryLow : Importance(0)

            object Low : Importance(10)

            object Normal : Importance(20)

            object High : Importance(30)

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
        override fun equals(other: Any?): Boolean = other is Status && other.label == label

        override fun hashCode(): Int = label.hashCode()
    }

    fun isDone(): Boolean = this.status.isDone

    fun copy(
        title: String? = null,
        status: Status? = null,
        priority: Priority? = null,
    ): GoalModel =
        GoalModel(
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
                entity: GoalEntity,
                status: Status,
                priority: Priority,
            ): GoalModel =
                GoalModel(
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
            ) = GoalModel(
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
            ) = GoalModel(
                title = title,
                status = status,
                priority = priority,
                createdAt = createdAt,
                isDraft = true,
            )
        }
}
