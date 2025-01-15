//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.habits](../index.md)/[HabitsViewState](index.md)/[HabitsViewState](-habits-view-state.md)

# HabitsViewState

[app]\
constructor(habits: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, showCreateExampleHabits: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onCreateExampleHabits: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onToggleHabitStatus: ([HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

#### Parameters

app

| | |
|---|---|
| habits | The list of habits. |
| showCreateExampleHabits | Whether to show the create example habits button. |
| onCreateExampleHabits | The action to be performed when the create example habits button is clicked. |
| onToggleHabitStatus | The action to be performed when the habit status is toggled. |
