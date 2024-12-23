package com.habithatch.demo.core.query

import com.habithatch.demo.data.models.GoalModel

data class GoalSortOption(
    val label: String,
    private val comparator: Comparator<GoalModel>,
    val sortState: SortState = SortState.NOT_USED,
) {
    @Throws(IllegalStateException::class)
    fun getComparator(): Comparator<GoalModel> =
        when (sortState) {
            SortState.ASCENDING -> comparator
            SortState.DESCENDING -> comparator.reversed()
            else -> error("Sort state is not used")
        }

    fun cycleState(): GoalSortOption = this.copy(sortState = sortState.nextInCycle())

    override fun equals(other: Any?): Boolean = other is GoalSortOption && other.label == label && other.sortState == sortState

    override fun hashCode(): Int = label.hashCode() + 31 * sortState.hashCode()

    override fun toString(): String = "GoalSortOption(label='$label', sortState=$sortState)"
}
