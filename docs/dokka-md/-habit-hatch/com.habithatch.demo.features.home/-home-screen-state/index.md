//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[HomeScreenState](index.md)

# HomeScreenState

[app]\
@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [HomeScreenState](index.md)(val goalsViewState: [GoalsViewState](../../com.habithatch.demo.ui.goals/-goals-view-state/index.md), val goalFilterState: [GoalFilterState](../../com.habithatch.demo.ui.goals/-goal-filter-state/index.md), val core: [CoreHomeState](../-core-home-state/index.md), val addGoalDialogState: [AddGoalDialogState](../../com.habithatch.demo.ui.goals/-add-goal-dialog-state/index.md) = AddGoalDialogState(), val goalSortState: [GoalSortState](../../com.habithatch.demo.ui.goals/-goal-sort-state/index.md) = GoalSortState(emptyList()))

Represents the state of the home screen.

## Constructors

| | |
|---|---|
| [HomeScreenState](-home-screen-state.md) | [app]<br>constructor(goalsViewState: [GoalsViewState](../../com.habithatch.demo.ui.goals/-goals-view-state/index.md), goalFilterState: [GoalFilterState](../../com.habithatch.demo.ui.goals/-goal-filter-state/index.md), core: [CoreHomeState](../-core-home-state/index.md), addGoalDialogState: [AddGoalDialogState](../../com.habithatch.demo.ui.goals/-add-goal-dialog-state/index.md) = AddGoalDialogState(), goalSortState: [GoalSortState](../../com.habithatch.demo.ui.goals/-goal-sort-state/index.md) = GoalSortState(emptyList())) |

## Properties

| Name | Summary |
|---|---|
| [addGoalDialogState](add-goal-dialog-state.md) | [app]<br>val [addGoalDialogState](add-goal-dialog-state.md): [AddGoalDialogState](../../com.habithatch.demo.ui.goals/-add-goal-dialog-state/index.md) |
| [core](core.md) | [app]<br>val [core](core.md): [CoreHomeState](../-core-home-state/index.md) |
| [goalFilterState](goal-filter-state.md) | [app]<br>val [goalFilterState](goal-filter-state.md): [GoalFilterState](../../com.habithatch.demo.ui.goals/-goal-filter-state/index.md) |
| [goalSortState](goal-sort-state.md) | [app]<br>val [goalSortState](goal-sort-state.md): [GoalSortState](../../com.habithatch.demo.ui.goals/-goal-sort-state/index.md) |
| [goalsViewState](goals-view-state.md) | [app]<br>val [goalsViewState](goals-view-state.md): [GoalsViewState](../../com.habithatch.demo.ui.goals/-goals-view-state/index.md) |