//[HabitHatch](../../index.md)/[com.habithatch.demo.features.home](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CoreHomeState](-core-home-state/index.md) | [app]<br>data class [CoreHomeState](-core-home-state/index.md)(val pet: [Pet](../com.habithatch.demo.data.entities/-pet/index.md), val onFabClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>Represents the main state information for the home screen. |
| [HomeScreenState](-home-screen-state/index.md) | [app]<br>@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)<br>class [HomeScreenState](-home-screen-state/index.md)(val goalsViewState: [GoalsViewState](../com.habithatch.demo.ui.goals/-goals-view-state/index.md), val goalFilterState: [GoalFilterState](../com.habithatch.demo.ui.goals/-goal-filter-state/index.md), val core: [CoreHomeState](-core-home-state/index.md), val addGoalDialogState: [AddGoalDialogState](../com.habithatch.demo.ui.goals/-add-goal-dialog-state/index.md) = AddGoalDialogState(), val goalSortState: [GoalSortState](../com.habithatch.demo.ui.goals/-goal-sort-state/index.md) = GoalSortState(emptyList()))<br>Represents the state of the home screen. |
| [HomeViewModel](-home-view-model/index.md) | [app]<br>class [HomeViewModel](-home-view-model/index.md)@Injectconstructor(userRepository: [UserRepository](../com.habithatch.demo.data.repositories/-user-repository/index.md), goalRepository: [GoalRepository](../com.habithatch.demo.data.repositories/-goal-repository/index.md), val config: [HabitHatchConfig](../com.habithatch.demo.core.config/-habit-hatch-config/index.md), val goalQueryFactory: [GoalQuery.Factory](../com.habithatch.demo.core.query/-goal-query/-factory/index.md), goalModelFactory: [GoalModel.Factory](../com.habithatch.demo.data.models/-goal-model/-factory/index.md), val builderFactory: [GoalFilterBuilderFactory](../com.habithatch.demo.core.query/-goal-filter-builder-factory/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [HomeScreen](-home-screen.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeScreen](-home-screen.md)(topNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), bottomNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), state: [HomeScreenState](-home-screen-state/index.md)? = rememberHomeScreenState())<br>The main screen of the application. Shows the user's pet and goals. |
| [HomeScreenPreview](-home-screen-preview.md) | [app]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true, showSystemUi = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeScreenPreview](-home-screen-preview.md)() |