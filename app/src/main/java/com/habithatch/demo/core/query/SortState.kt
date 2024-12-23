package com.habithatch.demo.core.query

enum class SortState {
    NOT_USED,
    ASCENDING,
    DESCENDING,
    ;

    fun nextInCycle(): SortState =
        when (this) {
            NOT_USED -> ASCENDING
            ASCENDING -> DESCENDING
            DESCENDING -> NOT_USED
        }
}
