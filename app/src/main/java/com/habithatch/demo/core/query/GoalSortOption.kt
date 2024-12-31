package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.GoalModel

/**
 * Represents a sort option for goals.
 *
 * @param label The label of the sort option.
 * @param _comparator The comparator for the sort option.
 * @param sortState The current state of the sort option.
 * @param uiIndex changes the position of the sort option in the UI.
 */
@Immutable
data class GoalSortOption(
    val label: String,
    private val _comparator: Comparator<GoalModel>,
    val sortState: SortState = SortState.NOT_USED,
    private val uiIndex: Int,
) : Comparable<GoalSortOption> {
    val comparator: Comparator<GoalModel>
        get() =
            when (sortState) {
                SortState.ASCENDING -> _comparator
                SortState.DESCENDING -> _comparator.reversed()
                else -> error("Sort state is not used")
            }

    /**
     * Returns a copy of this sort option with the sort state cycled.
     */
    fun cycleState(): GoalSortOption = this.copy(sortState = sortState.nextInCycle())

    fun isUsed(): Boolean = sortState != SortState.NOT_USED

    override fun equals(other: Any?) = other is GoalSortOption && other.label == label && other.sortState == sortState

    override fun hashCode(): Int = label.hashCode() + 31 * sortState.hashCode()

    override fun toString(): String = "GoalSortOption(label='$label', sortState=$sortState)"

    override fun compareTo(other: GoalSortOption): Int = this.uiIndex.compareTo(other.uiIndex)
}
