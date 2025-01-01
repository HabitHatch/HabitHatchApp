//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.goals](../index.md)/[GoalsViewState](index.md)

# GoalsViewState

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [GoalsViewState](index.md)(val goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, val showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, val onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, val onToggleGoalStatus: ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goals view.

#### Parameters

app

| | |
|---|---|
| goals | The list of goals. |
| showCreateExampleGoals | Whether to show the create example goals button. |
| onCreateExampleGoals | The action to be performed when the create example goals button is clicked. |
| onToggleGoalStatus | The action to be performed when the goal status is toggled. |

## Constructors

| | |
|---|---|
| [GoalsViewState](-goals-view-state.md) | [app]<br>constructor(goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onToggleGoalStatus: ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [goals](goals.md) | [app]<br>val [goals](goals.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [onCreateExampleGoals](on-create-example-goals.md) | [app]<br>val [onCreateExampleGoals](on-create-example-goals.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onToggleGoalStatus](on-toggle-goal-status.md) | [app]<br>val [onToggleGoalStatus](on-toggle-goal-status.md): ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [showCreateExampleGoals](show-create-example-goals.md) | [app]<br>val [showCreateExampleGoals](show-create-example-goals.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true |