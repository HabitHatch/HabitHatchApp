package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.HabitModel

/**
 * Represents a sort option for habits.
 *
 * @param label The label of the sort option.
 * @param _comparator The comparator for the sort option.
 * @param sortState The current state of the sort option.
 * @param uiIndex changes the position of the sort option in the UI.
 */
@Immutable
data class HabitSortOption(
    val labelRes: Int,
    private val _comparator: Comparator<HabitModel>,
    val sortState: SortState = SortState.NOT_USED,
    val uiIndex: Int,
) : Comparable<HabitSortOption> {
    val comparator: Comparator<HabitModel>
        get() =
            when (sortState) {
                SortState.ASCENDING -> _comparator
                SortState.DESCENDING -> _comparator.reversed()
                else -> error("Sort state is not used")
            }

    /**Returns a copy of this sort option with the sort state cycled.
     */
    fun cycleState(): HabitSortOption = this.copy(sortState = sortState.nextInCycle())

    /**
     * Returns a copy of this sort option with the sort state set to [SortState.NOT_USED].
     */
    fun isUsed(): Boolean = sortState != SortState.NOT_USED

    /**
     * @suppress
     */
    override fun toString(): String = "HabitSortOption(sortState=$sortState)"

    /**
     * @suppress
     */
    override fun compareTo(other: HabitSortOption): Int = this.uiIndex.compareTo(other.uiIndex)
}
