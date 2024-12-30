package com.habithatch.demo.core.util

import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.core.query.SortState

fun Iterable<GoalSortOption>.getUsed() = filter { it.isUsed() }

fun Iterable<GoalSortOption>.removeByLabel(label: String) = filter { it.label != label }

fun Iterable<GoalSortOption>.disableAll() = map { it.copy(sortState = SortState.NOT_USED) }
