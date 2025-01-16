//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[GoalFilter](index.md)

# GoalFilter

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [GoalFilter](index.md)

Filters goals based on priority, statuses and a search query.

#### Parameters

app

| | |
|---|---|
| priorityVisibility | Maps each priority to its visibility. |
| statusVisibility | Maps each status to its visibility. |
| searchQuery | Optional search term for filtering goals. |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [app]<br>data class [Builder](-builder/index.md)<br>Builder for [GoalFilter](index.md). |

## Properties

| Name | Summary |
|---|---|
| [priorityVisibility](priority-visibility.md) | [app]<br>val [priorityVisibility](priority-visibility.md): [PriorityVisibility](../-priority-visibility/index.md) |
| [searchQuery](search-query.md) | [app]<br>val [searchQuery](search-query.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? |
| [statusVisibility](status-visibility.md) | [app]<br>val [statusVisibility](status-visibility.md): [StatusVisibility](../-status-visibility/index.md) |

## Functions

| Name | Summary |
|---|---|
| [isDoneVisible](is-done-visible.md) | [app]<br>fun [isDoneVisible](is-done-visible.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if a done status is visible. |
| [isMatch](is-match.md) | [app]<br>fun [isMatch](is-match.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if a goal matches the filter. |