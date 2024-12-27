package com.habithatch.demo.ui.goals.table

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
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.util.createDate
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.GoalsView
import com.habithatch.demo.ui.goals.GoalsViewState

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun GoalQueryTable(
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
@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun GoalQueryTablePreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())
    val normalPriority = config.priorities.toList()[0]
    val highPriority = config.priorities.toList()[1]

    val inProgressStatus = GoalModel.Status("in Progress", 10)
    val doneStatus = GoalModel.Status("in Progress", 20, true)
    GoalQueryTable(
        goalsContent = {
            GoalsView(
                state =
                    GoalsViewState(
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
                        showCreateExampleGoals = false,
                    ),
            )
        },
        goalQuery = config.getDefaultGoalQuery(),
    )
}

@Preview(showBackground = true)
@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun GoalQueryTableNoGoalsPreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())
    GoalQueryTable(
        goalQuery = config.getDefaultGoalQuery(),
        goalsContent = {
            GoalsView(
                state =
                    GoalsViewState(
                        goals = emptyList(),
                        showCreateExampleGoals = true,
                    ),
            )
        },
    )
}
