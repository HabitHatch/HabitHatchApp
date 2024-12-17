package com.habithatch.demo.core.util

enum class SortState {
    NOT_USED,
    ASCENDING,
    DESCENDING;

    fun nextInCycle(): SortState {
        return when (this) {
            NOT_USED -> ASCENDING
            ASCENDING -> DESCENDING
            DESCENDING -> NOT_USED
        }
    }
}