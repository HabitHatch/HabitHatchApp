//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[HabitQuery](index.md)

# HabitQuery

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [HabitQuery](index.md)(val filter: [HabitFilter](../-habit-filter/index.md), val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../-habit-sort-option/index.md)&gt; = emptyList(), val defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md))

Query for filtering and sorting habits.

#### Parameters

app

| | |
|---|---|
| filter | The filter for the habits. |
| sortOptions | The sort options for the habits. |
| defaultComparator | The default comparator for the habits. |
| priorityProvider | Provides the priorities for habits. |
| statusProvider | Provides the statuses for habits. |

## Constructors

| | |
|---|---|
| [HabitQuery](-habit-query.md) | [app]<br>constructor(filter: [HabitFilter](../-habit-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../-habit-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Factory](-factory/index.md) | [app]<br>class [Factory](-factory/index.md)@Injectconstructor(priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [defaultComparator](default-comparator.md) | [app]<br>val [defaultComparator](default-comparator.md): [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt; |
| [filter](filter.md) | [app]<br>val [filter](filter.md): [HabitFilter](../-habit-filter/index.md) |
| [sortOptions](sort-options.md) | [app]<br>val [sortOptions](sort-options.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../-habit-sort-option/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getComparator](get-comparator.md) | [app]<br>fun [getComparator](get-comparator.md)(): [Comparator](https://developer.android.com/reference/kotlin/java/util/Comparator.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt; |
| [getFilterBuilder](get-filter-builder.md) | [app]<br>fun [getFilterBuilder](get-filter-builder.md)(): [HabitFilter.Builder](../-habit-filter/-builder/index.md) |
| [toString](to-string.md) | [app]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [updateSortOption](update-sort-option.md) | [app]<br>fun [updateSortOption](update-sort-option.md)(sortOption: [HabitSortOption](../-habit-sort-option/index.md)): [HabitQuery](index.md) |
