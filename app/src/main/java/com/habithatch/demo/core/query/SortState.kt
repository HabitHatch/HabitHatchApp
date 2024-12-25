package com.habithatch.demo.core.query

import com.habithatch.demo.R

enum class SortState(
    val label: String,
    val iconId: Int,
) {
    NOT_USED("Not sorted", R.drawable.vuesax_sort),
    ASCENDING("Ascending", R.drawable.vuesax_arrow_up_1),
    DESCENDING("Descending", R.drawable.vuesax_arrow_down_1),
    ;

    fun nextInCycle(): SortState =
        when (this) {
            NOT_USED -> ASCENDING
            ASCENDING -> DESCENDING
            DESCENDING -> NOT_USED
        }
}
