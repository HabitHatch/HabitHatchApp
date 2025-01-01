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
    NOT_USED(R.drawable.vuesax_sort),
    ASCENDING(R.drawable.vuesax_arrow_up_1),
    DESCENDING(R.drawable.vuesax_arrow_down_1),
    ;

    fun nextInCycle(): SortState =
        when (this) {
            NOT_USED -> ASCENDING
            ASCENDING -> DESCENDING
            DESCENDING -> NOT_USED
        }
}
