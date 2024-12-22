package com.habithatch.demo.core.util

data class SortConfig<T>(
    private val comparator: Comparator<T>,
    private val isAscending: Boolean = true
) {
    fun getEffectiveComparator(): Comparator<T> {
        return if (isAscending) comparator else comparator.reversed()
    }

    override fun toString(): String {
        return "SortConfig(comparator=..., isAscending=$isAscending)"
    }
}