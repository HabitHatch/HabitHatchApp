package com.habithatch.demo.components

import com.habithatch.demo.entities.Goal
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GoalList(
    goals: List<Goal>,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        goals.forEach { goal ->
            item {
                GoalItem(goal = goal)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalListPreview(){
    val goals = listOf(
        Goal(id = 1, title = "Goal 1"),
        Goal(id = 2, title = "Goal 2"),
        Goal(id = 3, title = "Goal 3")
    )
    GoalList(goals = goals)
}