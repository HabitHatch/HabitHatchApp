package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.common.SearchField

@Composable
fun GoalFilterBar(
    allPriorities: List<GoalModel.Priority>,
    allStatuses: List<GoalModel.Status>,
    goalFilter: GoalFilter,
    onGoalFilterChange: (GoalFilter) -> Unit
) {
    val searchQuery = goalFilter.searchQuery.orEmpty()

    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchField(
                searchQuery = searchQuery,
                onQueryChange = {
                    val newGoalFilter = goalFilter
                        .builder()
                        .setSearchQuery(it)
                        .build()
                    onGoalFilterChange(newGoalFilter)
                },
        )
        StatusDropdown(
                allStatuses = allStatuses,
                visibleGoalStatuses = goalFilter.statusVisibleMap,
                onDoneStateVisibleChange = { goalStatus, isVisible ->
                    val newGoalFilter = goalFilter
                        .builder()
                        .setStatusVisibility(goalStatus, isVisible)
                        .build()
                    onGoalFilterChange(newGoalFilter)
                }
        )
        PriorityDropdown(
                allPriorities = allPriorities,
                visiblePriorities = goalFilter.priorityVisibleMap,
                onPriorityVisibilityChange = { goalPriority, isVisible ->
                    val newGoalFilter = goalFilter
                        .builder()
                        .setPriorityVisibility(goalPriority, isVisible)
                        .build()
                    onGoalFilterChange(newGoalFilter)
                }
        )
    }
}

@Composable
fun StatusDropdown(
    allStatuses: List<GoalModel.Status>,
    visibleGoalStatuses: Map<GoalModel.Status, Boolean>,
    onDoneStateVisibleChange: (GoalModel.Status, Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
            modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        TextButton(onClick = { expanded = true }) {
            Text("Status")
        }
        DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
        ) {
            allStatuses.forEach { priority ->
                DropdownMenuItem(
                        text = {
                            Row(
                                    verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                        checked = visibleGoalStatuses[priority] == true,
                                        onCheckedChange = {
                                            onDoneStateVisibleChange(priority, it)
                                            expanded = false
                                        }
                                )
                                Text(priority.label)
                            }
                        },
                        onClick = {}
                )
            }
        }
    }
}

@Composable
fun PriorityDropdown(
    allPriorities: List<GoalModel.Priority>,
    visiblePriorities: Map<GoalModel.Priority, Boolean>,
    onPriorityVisibilityChange: (GoalModel.Priority, Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
            modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        TextButton(onClick = { expanded = true }) {
            Text("Priority")
        }
        DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
        ) {
            allPriorities.forEach { priority ->
                DropdownMenuItem(
                        text = {
                            Row(
                                    verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                        checked = visiblePriorities[priority] == true,
                                        onCheckedChange = {
                                            onPriorityVisibilityChange(priority, it)
                                            expanded = false
                                        }
                                )
                                Text(priority.label)
                            }
                        },
                        onClick = {}
                )
            }
        }
    }
}
