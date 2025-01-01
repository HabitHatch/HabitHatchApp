//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.goals](../index.md)/[AddGoalDialogState](index.md)

# AddGoalDialogState

[app]\
data class [AddGoalDialogState](index.md)(val showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md), val allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt;, val onAddGoal: ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, val onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

## Constructors

| | |
|---|---|
| [AddGoalDialogState](-add-goal-dialog-state.md) | [app]<br>constructor(showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md), allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt;, onAddGoal: ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [allPriorities](all-priorities.md) | [app]<br>val [allPriorities](all-priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt; |
| [goal](goal.md) | [app]<br>val [goal](goal.md): [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) |
| [onAddGoal](on-add-goal.md) | [app]<br>val [onAddGoal](on-add-goal.md): ([GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onDismiss](on-dismiss.md) | [app]<br>val [onDismiss](on-dismiss.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [showDialog](show-dialog.md) | [app]<br>val [showDialog](show-dialog.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |