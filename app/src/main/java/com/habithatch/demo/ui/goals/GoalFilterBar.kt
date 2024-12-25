package com.habithatch.demo.ui.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.common.SearchField

@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalFilterBar(
    allStatuses: List<GoalModel.Status>,
    goalFilterBuilder: GoalFilter.Builder,
    onGoalFilterChange: (GoalFilter) -> Unit,
) {
    val goalFilter = goalFilterBuilder.build()
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val doneState = allStatuses.first { it.isDone }
    val doneStateVisible = goalFilter.statusVisibleMap.entries.any { (status, visible) -> status.isDone && visible }
    val buttonText = if (doneStateVisible) "Hide ${doneState.label}" else "Show ${doneState.label}"
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SearchField(
            modifier =
                Modifier
                    .height(40.dp)
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium,
                    ).border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                        shape = MaterialTheme.shapes.medium,
                    ),
            searchQuery = searchQuery,
            onQueryChange = {
                val newGoalFilter =
                    goalFilterBuilder
                        .setSearchQuery(it)
                        .build()
                onGoalFilterChange(newGoalFilter)
            },
        )

        TextButton(
            modifier = Modifier.fillMaxWidth(0.25f),
            onClick = {
                val newGoalFilter =
                    goalFilterBuilder
                        .setStatusVisibility(status = allStatuses.first { it.isDone }, !doneStateVisible)
                        .build()
                onGoalFilterChange(newGoalFilter)
            },
        ) {
            Text(buttonText)
        }
    }
}
