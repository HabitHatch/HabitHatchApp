//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[HomeScreenState](index.md)

# HomeScreenState

[app]\
@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [HomeScreenState](index.md)(val habitsViewState: [HabitsViewState](../../com.habithatch.demo.ui.habits/-habits-view-state/index.md), val habitFilterState: [HabitFilterState](../../com.habithatch.demo.ui.habits/-habit-filter-state/index.md), val core: [CoreHomeState](../-core-home-state/index.md), val addHabitDialogState: [AddHabitDialogState](../../com.habithatch.demo.ui.habits/-add-habit-dialog-state/index.md) = AddHabitDialogState(), val habitSortState: [HabitSortState](../../com.habithatch.demo.ui.habits/-habit-sort-state/index.md) = HabitSortState(emptyList()))

Represents the state of the home screen.

## Constructors

| | |
|---|---|
| [HomeScreenState](-home-screen-state.md) | [app]<br>constructor(habitsViewState: [HabitsViewState](../../com.habithatch.demo.ui.habits/-habits-view-state/index.md), habitFilterState: [HabitFilterState](../../com.habithatch.demo.ui.habits/-habit-filter-state/index.md), core: [CoreHomeState](../-core-home-state/index.md), addHabitDialogState: [AddHabitDialogState](../../com.habithatch.demo.ui.habits/-add-habit-dialog-state/index.md) = AddHabitDialogState(), habitSortState: [HabitSortState](../../com.habithatch.demo.ui.habits/-habit-sort-state/index.md) = HabitSortState(emptyList())) |

## Properties

| Name | Summary |
|---|---|
| [addHabitDialogState](add-habit-dialog-state.md) | [app]<br>val [addHabitDialogState](add-habit-dialog-state.md): [AddHabitDialogState](../../com.habithatch.demo.ui.habits/-add-habit-dialog-state/index.md) |
| [core](core.md) | [app]<br>val [core](core.md): [CoreHomeState](../-core-home-state/index.md) |
| [habitFilterState](habit-filter-state.md) | [app]<br>val [habitFilterState](habit-filter-state.md): [HabitFilterState](../../com.habithatch.demo.ui.habits/-habit-filter-state/index.md) |
| [habitSortState](habit-sort-state.md) | [app]<br>val [habitSortState](habit-sort-state.md): [HabitSortState](../../com.habithatch.demo.ui.habits/-habit-sort-state/index.md) |
| [habitsViewState](habits-view-state.md) | [app]<br>val [habitsViewState](habits-view-state.md): [HabitsViewState](../../com.habithatch.demo.ui.habits/-habits-view-state/index.md) |