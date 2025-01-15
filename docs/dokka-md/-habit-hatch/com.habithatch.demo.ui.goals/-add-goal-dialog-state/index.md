//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.habits](../index.md)/[AddHabitDialogState](index.md)

# AddHabitDialogState

[app]\
data class [AddHabitDialogState](index.md)(val showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md), val allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt;, val onAddHabit: ([HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, val onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

## Constructors

| | |
|---|---|
| [AddHabitDialogState](-add-habit-dialog-state.md) | [app]<br>constructor(showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md), allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt;, onAddHabit: ([HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [allPriorities](all-priorities.md) | [app]<br>val [allPriorities](all-priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Priority](../../com.habithatch.demo.data.models/-habit-model/-priority/index.md)&gt; |
| [habit](habit.md) | [app]<br>val [habit](habit.md): [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md) |
| [onAddHabit](on-add-habit.md) | [app]<br>val [onAddHabit](on-add-habit.md): ([HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [onDismiss](on-dismiss.md) | [app]<br>val [onDismiss](on-dismiss.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [showDialog](show-dialog.md) | [app]<br>val [showDialog](show-dialog.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
