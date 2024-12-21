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
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.common.SearchField

// TODO: group the filterbar state into a single data class
// TODO: group the event handlers into a single event handler data class
@Composable
fun GoalFilterBar(
    priorities: List<GoalModel.Priority>,
    goalFilter: GoalFilterAttributes,
    onQueryChange: (String) -> Unit,
    onGoalStateVisibleChange: (GoalModel.Status, Boolean) -> Unit,
    onPriorityVisibilityChange: (GoalModel.Priority, Boolean) -> Unit,
) {
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val visibleGoalStatuses = goalFilter.statusVisibleMap
    val visibleGoalPriorities = goalFilter.priorityVisibleMap

    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchField(
                searchQuery = searchQuery,
                onQueryChange = onQueryChange,
                modifier = Modifier.weight(0.6f).padding(end = 8.dp)
        )
        StatusDropdown(
                visibleGoalStatuses = visibleGoalStatuses,
                onDoneStateVisibleChange = onGoalStateVisibleChange
        )
        PriorityDropdown(
                priorities = priorities,
                visiblePriorities = visibleGoalPriorities,
                onPriorityVisibilityChange = onPriorityVisibilityChange
        )
    }
}

@Composable
fun StatusDropdown(
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
        }
    }
}

@Composable
fun PriorityDropdown(
    priorities: List<GoalModel.Priority>,
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
            priorities.forEach { priority ->
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
