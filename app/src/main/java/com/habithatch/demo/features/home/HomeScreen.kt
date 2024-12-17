package com.habithatch.demo.features.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.ui.goals.AddGoalDialog
import com.habithatch.demo.ui.goals.GoalQueryTable
import com.habithatch.demo.ui.navigation.TopAppInformationBar
import com.habithatch.demo.ui.pets.PetAnimation

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val user: User? by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.filteredGoals.collectAsStateWithLifecycle()
    val goalQuery by viewModel.goalQuery.collectAsStateWithLifecycle()
    val allGoalsDone by viewModel.allGoalsDone.collectAsStateWithLifecycle()

    val bottomNavigationItems = viewModel.bottomNavigationItems
    val primaryNavigationItem = viewModel.primaryNavigationItem
    val priorities = viewModel.priorities

    val showDialog = remember { mutableStateOf(false) }
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val screen = Screen.fromRoute(currentRoute)
    val selectedItem = NavigationItem.findNavigationItemByRoute(
            route = currentRoute,
            navigationItems = bottomNavigationItems
    )
    Log.d("HomeScreen", "Goals: $goals")
    Log.d("HomeScreen", "User: $user")

    if (user == null) {
        return
    }
    Scaffold(
            topBar = {
                TopAppInformationBar(
                        title = screen?.title.orEmpty(),
                        primaryNavigationItem = primaryNavigationItem,
                        onPrimaryNavigationItemClick = {
                            navController.navigate(primaryNavigationItem.screen.route)
                        }
                )
            },
            bottomBar = {
                BottomNavigationBar(
                        onNavigationItemClicked = {
                            navController.navigate(it.screen.route)
                        },
                        activeNavigationItem = selectedItem,
                        navigationItems = bottomNavigationItems
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { showDialog.value = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
                }
            },
            content = { paddingValues ->
                Column(
                        modifier = Modifier.padding(
                                paddingValues
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PetAnimation(
                            pet = user!!.pet,
                            isPetHappy = allGoalsDone,
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .padding(top = 8.dp)
                    )
                    GoalQueryTable(
                            goals = goals,
                            priorities = priorities,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            goalQuery = goalQuery,
                            onToggleGoalStatus = { viewModel.toggleGoalDone(it) },
                            onQueryChange = { viewModel.changeSearchQuery(it) },
                            onGoalStateVisibilityChange = { doneState, visibility ->
                                viewModel.setDoneStateVisible(doneState, visibility)
                            },
                            onPriorityVisibilityChange = { priority, visibility ->
                                viewModel.setPriorityVisible(priority, visibility)
                            },
                            sortOptionStateClicked = { viewModel.toggleSortOptionState(it) }
                    )
                }
            }
    )
    if (showDialog.value) {
        AddGoalDialog(
                onDismiss = { showDialog.value = false },
                onAdd = { goalName, priority ->
                    viewModel.addGoal(goalName, priority)
                    showDialog.value = false
                }
        )
    }
}
