package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.item.GoalItem

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun GoalsView(
    state: GoalsViewState,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
) {
    if (state.showCreateExampleGoals) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(
                onClick = state.onCreateExampleGoals,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 32.dp),
            ) {
                Text("Create Example Goals")
            }
        }
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
    ) {
        state.goals.forEach { goal ->
            item {
                GoalItem(
                    goal = goal,
                    onToggleGoalStatus = { state.onToggleGoalStatus(goal) },
                )
            }
        }
    }
}

@Immutable
data class GoalsViewState(
    val goals: List<GoalModel>,
    val showCreateExampleGoals: Boolean,
    val onCreateExampleGoals: () -> Unit = {},
    val onToggleGoalStatus: (GoalModel) -> Unit = {},
)
