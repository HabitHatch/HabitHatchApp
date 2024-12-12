package com.habithatch.demo.common.goals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
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
    var searchTextValue: TextFieldValue = TextFieldValue(text = searchQuery)

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
    ) {
        OutlinedTextField(
                value = searchTextValue,
                onValueChange = { query: TextFieldValue ->
                    searchTextValue = query
                    onQueryChange(query.text)
                },
                modifier = Modifier.fillMaxWidth()
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