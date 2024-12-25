package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.util.createDate
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming", "LocalVariableName")
@Composable
fun GoalQueryTable(
    allPriorities: List<GoalModel.Priority>,
    allStatuses: List<GoalModel.Status>,
    modifier: Modifier = Modifier,
    goalQuery: GoalQuery,
    GoalsView: @Composable () -> Unit,
    onGoalQueryChange: (GoalQuery) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        GoalFilterBar(
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
        GoalsView()
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
        GoalsView = {
            GoalsView(
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
            )
        },
        goalQuery = config.getDefaultGoalQuery(),
    )
}

@Preview(showBackground = true)
@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalQueryTableNoGoalsPreview() {
    val config = HabitHatchDevConfig
    val normalPriority = config.priorities[0]
    val highPriority = config.priorities[1]

    val inProgressStatus = config.statuses[0]
    val doneStatus = config.statuses[1]
    GoalQueryTable(
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
        GoalsView = {
            GoalsView(
                goals = emptyList(),
                showCreateExampleGoalsButton = true,
            )
        },
    )
}
