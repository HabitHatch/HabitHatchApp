package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.util.createDate
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalQueryTable(
    goals: List<GoalModel>,
    allPriorities: List<GoalModel.Priority>,
    allStatuses: List<GoalModel.Status>,
    showCreateExampleGoalsButton: Boolean = false,
    modifier: Modifier = Modifier,
    goalQuery: GoalQuery,
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onGoalQueryChange: (GoalQuery) -> Unit = {},
    onCreateExampleGoalsClicked: () -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        GoalFilterBar(
            allPriorities = allPriorities,
            allStatuses = allStatuses,
            goalFilterBuilder = goalQuery.getFilterBuilder(),
            onGoalFilterChange = {
                val newGoalQuery = goalQuery.updateFilterConfig(it)
                onGoalQueryChange(newGoalQuery)
            },
        )
        GoalSortBar(
            sortOptions = goalQuery.sortOptions,
            onSortOptionChange = {
                val newGoalQuery = goalQuery.updateSortOption(it)
                onGoalQueryChange(newGoalQuery)
            },
        )
        if(showCreateExampleGoalsButton) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
            ) {
                Button(
                    onClick = onCreateExampleGoalsClicked,
                ) {
                    Text("Create Example Goals")
                }
            }
        }
        GoalList(
            goals = goals,
            modifier = Modifier.fillMaxSize(),
            onToggleGoalStatus = onToggleGoalStatus,
        )
    }
}

@Preview(showBackground = true)
@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalQueryTablePreview() {
    val config = HabitHatchDevConfig
    val normalPriority = config.priorities[0]
    val highPriority = config.priorities[1]

    val inProgressStatus = config.statuses[0]
    val doneStatus = config.statuses[1]
    GoalQueryTable(
        goals =
            listOf(
                GoalModel(
                    title = "Goal 1",
                    priority = normalPriority,
                    status = inProgressStatus,
                    createdAt = createDate(2024, 12, 4),
                ),
                GoalModel(
                    title = "Goal 2",
                    priority = highPriority,
                    status = inProgressStatus,
                    createdAt = createDate(2024, 12, 4),
                ),
                GoalModel(
                    title = "Goal 3",
                    priority = normalPriority,
                    status = doneStatus,
                    createdAt = createDate(2024, 12, 4),
                ),
            ),
        allPriorities =
            listOf(
                normalPriority,
                highPriority,
            ),
        allStatuses =
            listOf(
                inProgressStatus,
                doneStatus,
            ),
        goalQuery = config.getDefaultGoalQuery(),
    )
}
