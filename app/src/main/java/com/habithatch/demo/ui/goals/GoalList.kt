package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.data.models.GoalModel

@Composable
fun GoalList(
    goals: List<GoalModel>,
    modifier: Modifier = Modifier.fillMaxSize(),
    contentPadding: PaddingValues = PaddingValues(4.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onGoalClicked: (GoalModel) -> Unit = {},
) {
    LazyColumn(
            modifier = modifier,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement
    ) {
        goals.forEach { goal ->
            item {
                GoalItem(
                        goal = goal,
                        onToggleGoalStatus = { onToggleGoalStatus(goal) },
                        onGoalClicked = { onGoalClicked(goal) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalListPreview() {
    val goals = HabitHatchDevConfig.exampleGoals
    GoalList(goals = goals)
}