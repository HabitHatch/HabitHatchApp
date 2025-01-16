//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[GoalQuery](index.md)

# GoalQuery

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [GoalQuery](index.md)(val filterBuilder: [GoalFilter.Builder](../-goal-filter/-builder/index.md), val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; = emptyList(), val defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; = compareBy { 0 })

Query for filtering and sorting goals.

#### Parameters

app

| | |
|---|---|
| filter | The filter for the goals. |
| sortOptions | The sort options for the goals. |
| defaultComparator | The default comparator for the goals. |

## Constructors

| | |
|---|---|
| [GoalQuery](-goal-query.md) | [app]<br>constructor(filterBuilder: [GoalFilter.Builder](../-goal-filter/-builder/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; = compareBy { 0 }) |

## Types

| Name | Summary |
|---|---|
| [Factory](-factory/index.md) | [app]<br>class [Factory](-factory/index.md)@Injectconstructor<br>Factory for creating [GoalQuery](index.md) instances. |

## Properties

| Name | Summary |
|---|---|
| [defaultComparator](default-comparator.md) | [app]<br>val [defaultComparator](default-comparator.md): [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [filter](filter.md) | [app]<br>val [filter](filter.md): [GoalFilter](../-goal-filter/index.md) |
| [filterBuilder](filter-builder.md) | [app]<br>val [filterBuilder](filter-builder.md): [GoalFilter.Builder](../-goal-filter/-builder/index.md) |
| [sortOptions](sort-options.md) | [app]<br>val [sortOptions](sort-options.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getComparator](get-comparator.md) | [app]<br>fun [getComparator](get-comparator.md)(): [Comparator](https://developer.android.com/reference/kotlin/java/util/Comparator.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; |
| [updateSortOption](update-sort-option.md) | [app]<br>fun [updateSortOption](update-sort-option.md)(sortOption: [GoalSortOption](../-goal-sort-option/index.md)): [GoalQuery](index.md) |