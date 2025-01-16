package com.habithatch.demo.core.query

import com.habithatch.demo.R

/**
 * Represents the state of a sort option.
 *
 * @param iconId The icon resource ID for the sort option.
 */
enum class SortState(
    val iconId: Int,
) {
    /**
     * @suppress
     */
    NOT_USED(R.drawable.sort),

    /**
     * @suppress
     */
    ASCENDING(R.drawable.sort_ascending),

    /**
     * @suppress
     */
    DESCENDING(R.drawable.sort_descending),
    ;

    /**
     * Returns the next state in the cycle.
     */
    fun nextInCycle(): SortState =
        when (this) {
            NOT_USED -> ASCENDING
            ASCENDING -> DESCENDING
            DESCENDING -> NOT_USED
        }
}
