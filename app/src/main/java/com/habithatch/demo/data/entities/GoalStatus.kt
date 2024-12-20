package com.habithatch.demo.data.entities

data class GoalStatus(
    val id: String,
    val label: String,
    val stepNumber: Int
) : Comparable<GoalStatus> {
    override fun compareTo(other: GoalStatus): Int {
        return stepNumber.compareTo(other.stepNumber)
    }

    override fun equals(other: Any?): Boolean {
        return other is GoalStatus && other.id == id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}