//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.goals](../index.md)/[GoalsViewState](index.md)/[GoalsViewState](-goals-view-state.md)

# GoalsViewState

[app]\
constructor(goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onToggleGoalStatus: ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

#### Parameters

app

| | |
|---|---|
| goals | The list of goals. |
| showCreateExampleGoals | Whether to show the create example goals button. |
| onCreateExampleGoals | The action to be performed when the create example goals button is clicked. |
| onToggleGoalStatus | The action to be performed when the goal status is toggled. |