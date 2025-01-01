//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[GoalQuery](index.md)

# GoalQuery

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [GoalQuery](index.md)(val filter: [GoalFilter](../-goal-filter/index.md), val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; = emptyList(), val defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md))

Query for filtering and sorting goals.

#### Parameters

app

| | |
|---|---|
| filter | The filter for the goals. |
| sortOptions | The sort options for the goals. |
| defaultComparator | The default comparator for the goals. |
| priorityProvider | Provides the priorities for goals. |
| statusProvider | Provides the statuses for goals. |

## Constructors

| | |
|---|---|
| [GoalQuery](-goal-query.md) | [app]<br>constructor(filter: [GoalFilter](../-goal-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Factory](-factory/index.md) | [app]<br>class [Factory](-factory/index.md)@Injectconstructor(priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [defaultComparator](default-comparator.md) | [app]<br>val [defaultComparator](default-comparator.md): [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [filter](filter.md) | [app]<br>val [filter](filter.md): [GoalFilter](../-goal-filter/index.md) |
| [sortOptions](sort-options.md) | [app]<br>val [sortOptions](sort-options.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getComparator](get-comparator.md) | [app]<br>fun [getComparator](get-comparator.md)(): [Comparator](https://developer.android.com/reference/kotlin/java/util/Comparator.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [getFilterBuilder](get-filter-builder.md) | [app]<br>fun [getFilterBuilder](get-filter-builder.md)(): [GoalFilter.Builder](../-goal-filter/-builder/index.md) |
| [toString](to-string.md) | [app]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [updateSortOption](update-sort-option.md) | [app]<br>fun [updateSortOption](update-sort-option.md)(sortOption: [GoalSortOption](../-goal-sort-option/index.md)): [GoalQuery](index.md) |