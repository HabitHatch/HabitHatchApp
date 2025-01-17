//[HabitHatch](../../index.md)/[com.habithatch.demo.features.home](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CoreHomeState](-core-home-state/index.md) | [app]<br>data class [CoreHomeState](-core-home-state/index.md)(val pet: [Pet](../com.habithatch.demo.data.entities/-pet/index.md), val onFabClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>Represents the main state information for the home screen. |
| [HomeScreenState](-home-screen-state/index.md) | [app]<br>@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)<br>class [HomeScreenState](-home-screen-state/index.md)(val habitsViewState: [HabitsViewState](../com.habithatch.demo.ui.habits/-habits-view-state/index.md), val habitFilterState: [HabitFilterState](../com.habithatch.demo.ui.habits/-habit-filter-state/index.md), val core: [CoreHomeState](-core-home-state/index.md), val addHabitDialogState: [AddHabitDialogState](../com.habithatch.demo.ui.habits/-add-habit-dialog-state/index.md) = AddHabitDialogState(), val habitSortState: [HabitSortState](../com.habithatch.demo.ui.habits/-habit-sort-state/index.md) = HabitSortState(emptyList()))<br>Represents the state of the home screen. |
| [HomeViewModel](-home-view-model/index.md) | [app]<br>class [HomeViewModel](-home-view-model/index.md)@Injectconstructor(userRepository: [UserRepository](../com.habithatch.demo.data.repositories/-user-repository/index.md), habitRepository: [HabitRepository](../com.habithatch.demo.data.repositories/-habit-repository/index.md), val config: [HabitHatchConfig](../com.habithatch.demo.core.config/-habit-hatch-config/index.md), val habitQueryFactory: [HabitQuery.Factory](../com.habithatch.demo.core.query/-habit-query/-factory/index.md), habitModelFactory: [HabitModel.Factory](../com.habithatch.demo.data.models/-habit-model/-factory/index.md), val builderFactory: [HabitFilterBuilderFactory](../com.habithatch.demo.core.query/-habit-filter-builder-factory/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [HomeScreen](-home-screen.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeScreen](-home-screen.md)(topNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), bottomNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), state: [HomeScreenState](-home-screen-state/index.md)? = rememberHomeScreenState())<br>The main screen of the application. Shows the user's pet and habits. |
| [HomeScreenPreview](-home-screen-preview.md) | [app]<br>@[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true, showSystemUi = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HomeScreenPreview](-home-screen-preview.md)() |