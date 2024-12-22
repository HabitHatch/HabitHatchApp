package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.util.GoalSortOption
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.core.util.SortState
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

@Composable
fun GoalQueryTable(
    goals: List<GoalModel>,
    allPriorities: List<GoalModel.Priority>,
    allStatuses: List<GoalModel.Status>,
    modifier: Modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth(),
    goalQuery: GoalQuery,
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onGoalQueryChange: (GoalQuery) -> Unit = {},
) {
    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                allPriorities = allPriorities,
                allStatuses = allStatuses,
                goalFilter = goalQuery.filter,
                onGoalFilterChange = {
                    val newGoalQuery = goalQuery.updateFilterConfig(it)
                    onGoalQueryChange(newGoalQuery)
                }
        )
        GoalSortBar(
                goalQuery = goalQuery,
                onGoalQueryChange = onGoalQueryChange
        )
        GoalList(
                goals = goals,
                modifier = Modifier.fillMaxSize(),
                onToggleGoalStatus = onToggleGoalStatus,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GoalQueryTablePreview() {
    val normalPriority = HabitHatchDevConfig.priorities[0]
    val highPriority = HabitHatchDevConfig.priorities[1]

    val inProgressStatus = HabitHatchDevConfig.statuses[0]
    val doneStatus = HabitHatchDevConfig.statuses[1]
    GoalQueryTable(
            goals = listOf(
                    GoalModel(
                            id = 1,
                            title = "Goal 1",
                            priority = HabitHatchDevConfig.priorities[0],
                            status = inProgressStatus
                    ),
                    GoalModel(
                            id = 2,
                            title = "Goal 2",
                            priority = highPriority,
                            status = inProgressStatus
                    ),
                    GoalModel(
                            id = 3,
                            title = "Goal 3",
                            priority = normalPriority,
                            status = doneStatus
                    ),
            ),
            allPriorities = listOf(
                    normalPriority,
                    highPriority
            ),
            allStatuses = listOf(
                    inProgressStatus,
                    doneStatus
            ),
            goalQuery = GoalQuery(
                    filter = GoalFilter.Builder(
                            HabitHatchDevConfig,
                            HabitHatchDevConfig
                    ).createMatchAll().build(),
                    sortOptions = listOf(
                    ),
                    defaultSortConfig = SortConfig(
                            compareBy { it.title }
                    )
            )
    )
}
