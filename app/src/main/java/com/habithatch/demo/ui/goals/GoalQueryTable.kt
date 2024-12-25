package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.util.createDate
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming", "LocalVariableName")
@Composable
fun GoalQueryTable(
    allStatuses: List<GoalModel.Status>,
    modifier: Modifier = Modifier,
    goalQuery: GoalQuery,
    goalsContent: @Composable () -> Unit,
    onGoalQueryChange: (GoalQuery) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(40.dp),
        ) {
            GoalFilterBar(
                modifier = Modifier.fillMaxHeight().weight(6f),
                allStatuses = allStatuses,
                goalFilterBuilder = goalQuery.getFilterBuilder(),
                onGoalFilterChange = { onGoalQueryChange(goalQuery.copy(filter = it)) },
            )
            Spacer(modifier = Modifier.weight(0.5f))
            GoalSortBar(
                modifier = Modifier.fillMaxHeight().weight(5.5f),
                sortOptions = goalQuery.sortOptions,
                onSortOptionChange = { onGoalQueryChange(goalQuery.copy(it)) },
            )
        }
        goalsContent()
    }
}

@Preview()
@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalQueryTablePreview() {
    val config = HabitHatchDevConfig
    val normalPriority = config.priorities[0]
    val highPriority = config.priorities[1]

    val inProgressStatus = config.statuses[0]
    val doneStatus = config.statuses[1]
    GoalQueryTable(
        allStatuses =
            listOf(
                inProgressStatus,
                doneStatus,
            ),
        goalsContent = {
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
    val inProgressStatus = config.statuses[0]
    val doneStatus = config.statuses[1]
    GoalQueryTable(
        allStatuses =
            listOf(
                inProgressStatus,
                doneStatus,
            ),
        goalQuery = config.getDefaultGoalQuery(),
        goalsContent = {
            GoalsView(
                goals = emptyList(),
                showCreateExampleGoalsButton = true,
            )
        },
    )
}
