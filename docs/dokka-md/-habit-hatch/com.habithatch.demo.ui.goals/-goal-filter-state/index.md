//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.goals](../index.md)/[GoalFilterState](index.md)

# GoalFilterState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [GoalFilterState](index.md)(val goalFilterBuilder: [GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md), val onGoalFilterChange: ([GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goal filter.

#### Parameters

app

| | |
|---|---|
| goalFilterBuilder | The builder of the goal filter. |
| onGoalFilterChange | The action to be performed when the goal filter changes. |

## Constructors

| | |
|---|---|
| [GoalFilterState](-goal-filter-state.md) | [app]<br>constructor(goalFilterBuilder: [GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md), onGoalFilterChange: ([GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [goalFilterBuilder](goal-filter-builder.md) | [app]<br>val [goalFilterBuilder](goal-filter-builder.md): [GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md) |
| [onGoalFilterChange](on-goal-filter-change.md) | [app]<br>val [onGoalFilterChange](on-goal-filter-change.md): ([GoalFilter.Builder](../../com.habithatch.demo.core.query/-goal-filter/-builder/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |