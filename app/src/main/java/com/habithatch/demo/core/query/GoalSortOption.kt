package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.GoalModel

@Immutable
data class GoalSortOption(
    val label: String,
    private val comparator: Comparator<GoalModel>,
    val sortState: SortState = SortState.NOT_USED,
    private val uiIndex: Int,
) : Comparable<GoalSortOption> {
    @Throws(IllegalStateException::class)
    fun getComparator(): Comparator<GoalModel> =
        when (sortState) {
            SortState.ASCENDING -> comparator
            SortState.DESCENDING -> comparator.reversed()
            else -> error("Sort state is not used")
        }

    fun cycleState(): GoalSortOption = this.copy(sortState = sortState.nextInCycle())

    override fun equals(other: Any?) = other is GoalSortOption && other.label == label && other.sortState == sortState

    override fun hashCode(): Int = label.hashCode() + 31 * sortState.hashCode()

    override fun toString(): String = "GoalSortOption(label='$label', sortState=$sortState)"

    override fun compareTo(other: GoalSortOption): Int = this.uiIndex.compareTo(other.uiIndex)
}
