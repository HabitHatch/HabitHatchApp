package com.habithatch.demo.features.home

import android.util.Log

import BottomNavigationBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialog
import com.habithatch.demo.ui.goals.GoalQueryTable
import com.habithatch.demo.ui.navigation.TopAppInformationBar
import com.habithatch.demo.ui.pets.PetAnimation

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(
    navController: NavHostController,
    config: HabitHatchConfig = hiltViewModel<HomeViewModel>().config,
    state: HomeScreenState = rememberHomeScreenState(),
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val screen = Screen.fromRoute(currentRoute)
    val activeNavigationItem =
        NavigationItem.findNavigationItemByRoute(
            route = currentRoute,
            navigationItems = config.navigationItems,
        )

    if (state.user == null) {
        Log.w("HomeScreen", "User is null")
        return
    }

    Scaffold(
        topBar = {
            TopAppInformationBar(
                title = screen?.title.orEmpty(),
                primaryNavigationItem = config.primaryNavigationItem,
                onPrimaryNavigationItemClick = {
                    navController.navigate(config.primaryNavigationItem.screen.route)
                },
            )
        },
        bottomBar = {
            BottomNavigationBar(
                onNavigationItemClicked = {
                    navController.navigate(it.screen.route)
                },
                activeNavigationItem = activeNavigationItem,
                navigationItems = config.navigationItems,
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.onAddGoalClicked()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
            }
        },
        content = { paddingValues ->
            Column(
                modifier =
                    Modifier.padding(
                        paddingValues,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PetAnimation(
                    pet = state.user.pet,
                    isPetHappy = state.allGoalsDone,
                    modifier =
                        Modifier
                            .fillMaxWidth(0.4f)
                            .padding(top = 8.dp),
                )
                GoalQueryTable(
                    goals = state.goals,
                    goalQuery = state.goalQuery,
                    allStatuses = config.statuses,
                    allPriorities = config.priorities,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    showCreateExampleGoalsButton = !state.hasAnyGoals,
                    onToggleGoalStatus = { state.onGoalStatusToggled(it) },
                    onGoalQueryChange = { state.onGoalQueryChange(it) },
                    onCreateExampleGoalsClicked = {
                        state.onCreateExampleGoalsClicked()
                    },
                )
            }
        },
    )

    if (state.showDialog) {
        AddGoalDialog(
            allPriorities = config.priorities,
            preselectedGoal =
                GoalModel(
                    title = "",
                    priority = config.defaultPriority,
                    status = config.defaultStatus,
                ),
            onDismiss = {
                state.onGoalDialogDismissed()
            },
            onAdd = { goal ->
                state.onGoalAdded(goal)
            },
        )
    }
}

@Stable
class HomeScreenState(
    val user: User?,
    val goals: List<GoalModel>,
    val allGoalsDone: Boolean,
    val goalQuery: GoalQuery,
    val showDialog: Boolean,
    val hasAnyGoals: Boolean,
    val onCreateExampleGoalsClicked: () -> Unit = {},
    val onAddGoalClicked: () -> Unit,
    val onGoalDialogDismissed: () -> Unit,
    val onGoalAdded: (GoalModel) -> Unit,
    val onGoalQueryChange: (GoalQuery) -> Unit,
    val onGoalStatusToggled: (GoalModel) -> Unit,
)

@Suppress("ktlint:standard:function-naming")
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.queriedGoals.collectAsStateWithLifecycle()
    val allGoalsDone by viewModel.allGoalsDone.collectAsStateWithLifecycle()
    val goalQuery by viewModel.goalQuery.collectAsStateWithLifecycle()
    val hasAnyGoals by viewModel.hasAnyGoals.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    return remember(user, goals, allGoalsDone, goalQuery, showDialog, hasAnyGoals) {
        HomeScreenState(
            user = user,
            goals = goals,
            allGoalsDone = allGoalsDone,
            goalQuery = goalQuery,
            showDialog = showDialog,
            hasAnyGoals = hasAnyGoals,
            onAddGoalClicked = { showDialog = true },
            onGoalAdded = {
                viewModel.addGoal(it)
                showDialog = false
            },
            onGoalStatusToggled = { viewModel.toggleGoalStatus(it) },
            onGoalQueryChange = { viewModel.updateGoalQuery(it) },
            onGoalDialogDismissed = { showDialog = false },
            onCreateExampleGoalsClicked = { viewModel.seedGoals() },
        )
    }
}
