package com.habithatch.demo.core.util

/**
 * Returns the next higher element in the collection, based on the given selector.
 *
 * @param bySelector The selector to determine the order of the elements.
 * @param element The element to find the next higher element for.
 * @return The next higher element in the collection.
 * @throws IllegalArgumentException If the collection is empty.
 */
@Throws(IllegalArgumentException::class)
fun <T, R : Comparable<R>> Collection<T>.getNextHigherOrLowest(
    bySelector: (T) -> R,
    element: T,
): T {
    require(this.isNotEmpty()) { "Cannot find next higher element in an empty list" }

    val sorted = this.sortedBy(bySelector)
    val elementValue = bySelector(element)

    val nextHigher = sorted.find { bySelector(it) > elementValue }
    return nextHigher ?: sorted.first()
}
