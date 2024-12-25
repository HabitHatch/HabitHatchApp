package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun GoalsView(
    goals: List<GoalModel>,
    showCreateExampleGoalsButton: Boolean = false,
    onCreateExampleGoalsClicked: () -> Unit = {},
    onToggleGoalStatus: (GoalModel) -> Unit = {},
) {
    if (showCreateExampleGoalsButton) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(
                onClick = onCreateExampleGoalsClicked,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 32.dp),
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
