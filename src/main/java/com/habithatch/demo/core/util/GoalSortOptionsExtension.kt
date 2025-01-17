package com.habithatch.demo.core.util

import com.habithatch.demo.core.query.HabitSortOption
import com.habithatch.demo.core.query.SortState

/**
 * Returns all [HabitSortOption]'s that are used.
 */
fun Iterable<HabitSortOption>.getUsed() = filter { it.isUsed() }

/**
 * Removes all [HabitSortOption]'s with the given [label].
 */
fun Iterable<HabitSortOption>.removeByUIIndex(uiIndex: Int) = filter { it.uiIndex != uiIndex }

/**
 * Disables all [HabitSortOption]'s.
 */
fun Iterable<HabitSortOption>.disableAll() = map { it.copy(sortState = SortState.NOT_USED) }
