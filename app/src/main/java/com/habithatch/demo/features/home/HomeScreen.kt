package com.habithatch.demo.features.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import BottomNavigationBar
import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.habithatch.demo.common.ui.LoadingScreen
import com.habithatch.demo.common.ui.PetAnimation
import com.habithatch.demo.common.ui.goals.AddGoalDialog
import com.habithatch.demo.common.ui.goals.GoalListScreen
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.navigation.getNavigationItem
import com.habithatch.demo.data.entities.User

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val user: User? by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.filteredGoals.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val doneStateVisibleMap by viewModel.doneStateVisibleMap.collectAsStateWithLifecycle()
    val priorityVisibleMap by viewModel.priorityVisibleMap.collectAsStateWithLifecycle()

    val bottomNavigationItems = viewModel.bottomNavigationItems

    Log.d("HomeScreen", "User: $user")
    if (user == null) {
        LoadingScreen()
        return
    }
    val showDialog = remember { mutableStateOf(false) }
    val selectedItem = Screen.Home.getNavigationItem(bottomNavigationItems)
    if (selectedItem == null) {
        Log.e("HomeScreen", "Home screen not found in navigation items")
        Text(
                text = "Error: Unable to load the Home Screen",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = MaterialTheme.colorScheme.error
        )
        return
    }
    Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { showDialog.value = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
                }
            },
            content = { paddingValues ->
                Column(
                        modifier = Modifier.padding(paddingValues),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PetAnimation(
                            pet = user!!.pet,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(top = 10.dp)
                    )
                    Column(
                            modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        GoalListScreen(searchQuery = searchQuery.orEmpty(),
                                visibleDoneStates = doneStateVisibleMap,
                                visiblePriorities = priorityVisibleMap,
                                goals = goals,
                                onToggleDone = { viewModel.toggleGoalDone(it) },
                                addGoal = { viewModel.addGoal(it) },
                                onQueryChange = { viewModel.changeSearchQuery(it) },
                                onDoneStateVisibilityChange = { doneState, visibility ->
                                    viewModel.setDoneStateVisible(doneState, visibility)
                                },
                                onPriorityVisibilityChange = { priority, visibility ->
                                    viewModel.setPriorityVisibility(priority, visibility)
                                })
                    }


                }

            },
            bottomBar = {
                BottomNavigationBar(
                        onItemSelected = {
                            if (it.screen == Screen.Home) return@BottomNavigationBar
                            navController.navigate(it.screen.route)
                        },
                        selectedItem = selectedItem,
                        navigationItems = bottomNavigationItems
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
