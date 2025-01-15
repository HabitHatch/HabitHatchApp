//[HabitHatch](../../../index.md)/[com.habithatch.demo.ui.habits](../index.md)/[HabitSortState](index.md)

# HabitSortState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [HabitSortState](index.md)(val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)&gt;, val onSortOptionChange: ([HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { })

The state of the habit sort.

#### Parameters

app

| | |
|---|---|
| sortOptions | The list of sort options. |
| onSortOptionChange | The action to be performed when the sort option changes. |

## Constructors

| | |
|---|---|
| [HabitSortState](-habit-sort-state.md) | [app]<br>constructor(sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)&gt;, onSortOptionChange: ([HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { }) |

## Properties

| Name | Summary |
|---|---|
| [onSortOptionChange](on-sort-option-change.md) | [app]<br>val [onSortOptionChange](on-sort-option-change.md): ([HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [sortOptions](sort-options.md) | [app]<br>val [sortOptions](sort-options.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)&gt; |
