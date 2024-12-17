package com.habithatch.demo.core.util

data class SortConfig<T>(
    val comparator: Comparator<T>,
    val isAscending: Boolean = true
) {
    fun getEffectiveComparator(): Comparator<T> {
        return if (isAscending) comparator else comparator.reversed()
    }
    fun switchDirection(): SortConfig<T> {
        return this.copy(isAscending = !isAscending)
    }
}