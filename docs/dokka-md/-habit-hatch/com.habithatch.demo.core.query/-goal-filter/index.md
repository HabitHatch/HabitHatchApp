//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[HabitFilter](index.md)

# HabitFilter

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [HabitFilter](index.md)

Filters habits based on priority, statuses and a search query.

#### Parameters

app

| | |
|---|---|
| priorityVisibility | Maps each priority to its visibility. |
| statusVisibility | Maps each status to its visibility. |
| searchQuery | Optional search term for filtering habits. |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [app]<br>data class [Builder](-builder/index.md)<br>Builder for [HabitFilter](index.md). |

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
| [isMatch](is-match.md) | [app]<br>fun [isMatch](is-match.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if a habit matches the filter. |
| [toString](to-string.md) | [app]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
