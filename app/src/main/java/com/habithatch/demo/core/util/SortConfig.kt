package com.habithatch.demo.core.util

import kotlin.reflect.KProperty1

data class SortConfig<T>(
    val attribute: KProperty1<T, Comparable<*>>,
    val comparator: Comparator<T>? = null,
    val direction: SortDirection = SortDirection.ASC
) {
    fun getEffectiveComparator(): Comparator<T> {
        val baseComparator = comparator ?: compareBy(attribute)
        return if (direction == SortDirection.DESC) baseComparator.reversed() else baseComparator
    }
    fun getAttributeName(): String {
        return attribute.name
    }
}