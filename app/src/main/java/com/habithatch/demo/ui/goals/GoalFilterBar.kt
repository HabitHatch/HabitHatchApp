package com.habithatch.demo.ui.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import java.util.EnumMap
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.models.GoalFilter

@Composable
fun GoalFilterBar(
    goalFilter: GoalFilter,
    onQueryChange: (String) -> Unit,
    onGoalStateVisibleChange: (GoalStatus, Boolean) -> Unit,
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit,
) {
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val visibleGoalStatuses = goalFilter.goalStatusVisibleMap
    val visibleGoalPriorities = goalFilter.goalPriorityVisibleMap

    Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomSearchView(
                searchQuery = searchQuery,
                onQueryChange = onQueryChange,
                modifier = Modifier.weight(0.6f).padding(end = 8.dp)
        )
        StatusDropdown(
                visibleGoalStatuses = visibleGoalStatuses,
                onDoneStateVisibleChange = onGoalStateVisibleChange
        )
        PriorityDropdown(
                visiblePriorities = visibleGoalPriorities,
                onPriorityVisibilityChange = onPriorityVisibilityChange
        )
    }
}

// TODO: move to separate file
@Composable
fun CustomSearchView(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
            modifier = modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium
                )
                .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                        shape = MaterialTheme.shapes.medium
                ),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 12.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
        ) {
            BasicTextField(
                    value = searchQuery,
                    onValueChange = { onQueryChange(it) },
                    textStyle = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
            )
        }
    }
}
// TODO: move to separate file

@Composable
fun StatusDropdown(
    visibleGoalStatuses: EnumMap<GoalStatus, Boolean>,
    onDoneStateVisibleChange: (GoalStatus, Boolean) -> Unit
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
            GoalStatus.entries.forEach { doneState ->
                DropdownMenuItem(
                        text = {
                            Row(
                                    verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                        checked = visibleGoalStatuses[doneState] == true,
                                        onCheckedChange = {
                                            onDoneStateVisibleChange(doneState, it)
                                            expanded = false
                                        }
                                )
                                Text(doneState.name)
                            }
                        },
                        onClick = {}
                )
            }
        }
    }
}

// TODO: move to separate file
@Composable
fun PriorityDropdown(
    visiblePriorities: EnumMap<GoalPriority, Boolean>,
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit
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
            GoalPriority.entries.forEach { priority ->
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
