package com.habithatch.demo.common.goals

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.habithatch.demo.features.home.HomeViewModel

@Composable
fun GoalListScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val showDialog = remember { mutableStateOf(false) }
    val goals = viewModel.filteredGoals.collectAsState()

    Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { showDialog.value = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
                }
            },
            content = { paddingValues ->
                GoalList(
                        goals = goals.value,
                        onToggleDone = { goal -> viewModel.toggleGoalDone(goal) },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                )
            }
    )

    if (showDialog.value) {
        AddGoalDialog(
                onDismiss = { showDialog.value = false },
                onAdd = { goalName ->
                    viewModel.addGoal(goalName)
                    showDialog.value = false
                }
        )
    }
}