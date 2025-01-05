package com.habithatch.demo.core.util

import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.core.query.SortState

/**
 * Returns all [GoalSortOption]'s that are used.
 */
fun Iterable<GoalSortOption>.getUsed() = filter { it.isUsed() }

/**
 * Removes all [GoalSortOption]'s with the given [label].
 */
fun Iterable<GoalSortOption>.removeByLabel(label: String) = filter { it.label != label }

/**
 * Disables all [GoalSortOption]'s.
 */
fun Iterable<GoalSortOption>.disableAll() = map { it.copy(sortState = SortState.NOT_USED) }
