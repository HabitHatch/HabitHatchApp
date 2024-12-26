package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.theme.success
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.common.SearchField

@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalFilterBar(
    modifier: Modifier = Modifier,
    allStatuses: List<GoalModel.Status>,
    goalFilterBuilder: GoalFilter.Builder,
    onGoalFilterChange: (GoalFilter) -> Unit,
) {
    val goalFilter = goalFilterBuilder.build()
    val searchQuery = goalFilter.searchQuery.orEmpty()
    val isDoneStatusVisible = goalFilter.statusVisibleMap.entries.any { (status, visible) -> status.isDone && visible }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SearchField(
            modifier = Modifier.height(40.dp).weight(1f),
            searchQuery = searchQuery,
            onQueryChange = {
                val newGoalFilter = goalFilterBuilder.setSearchQuery(it).build()
                onGoalFilterChange(newGoalFilter)
            },
        )

        IconButton(
            modifier = Modifier.width(48.dp),
            onClick = {
                val newGoalFilter =
                    goalFilterBuilder
                        .setStatusVisibility(
                            status = allStatuses.first { it.isDone },
                            !isDoneStatusVisible,
                        ).build()
                onGoalFilterChange(newGoalFilter)
            },
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Done",
                tint =
                    if (isDoneStatusVisible) {
                        MaterialTheme.colorScheme.success
                    } else {
                        MaterialTheme.colorScheme.outline
                    },
                modifier = Modifier.padding(horizontal = 4.dp),
            )
        }
    }
}
