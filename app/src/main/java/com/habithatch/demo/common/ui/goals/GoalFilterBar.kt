package com.habithatch.demo.common.ui.goals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority

@Composable
fun GoalFilterBar(
    searchQuery: String,
    visibleDoneStates: Map<GoalDoneState, Boolean>,
    visiblePriorities: Map<GoalPriority, Boolean>,
    onQueryChange: (String) -> Unit,
    onDoneStateVisibleChange: (GoalDoneState, Boolean) -> Unit,
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit,
) {

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
    ) {
        OutlinedTextField(
                value = searchQuery,
                leadingIcon = {
                    Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                    )
                },
                onValueChange = { query: String ->
                    onQueryChange(query)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = MaterialTheme.shapes.medium,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Status", style = MaterialTheme.typography.labelSmall)
                GoalDoneState.entries.forEach { doneState: GoalDoneState ->

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                                checked = visibleDoneStates[doneState] == true,
                                onCheckedChange = {
                                    onDoneStateVisibleChange(doneState, it)
                                }
                        )
                        Text(doneState.name)
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text("Priority", style = MaterialTheme.typography.labelSmall)

                GoalPriority.entries.forEach { priority: GoalPriority ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                                checked = visiblePriorities[priority] == true,
                                onCheckedChange = {
                                    onPriorityVisibilityChange(priority, it)
                                }
                        )
                        Text(priority.name)
                    }
                }
            }
        }
    }
}