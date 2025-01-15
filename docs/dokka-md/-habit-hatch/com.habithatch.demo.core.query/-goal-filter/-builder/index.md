//[HabitHatch](../../../../index.md)/[com.habithatch.demo.core.query](../../index.md)/[HabitFilter](../index.md)/[Builder](index.md)

# Builder

data class [Builder](index.md)

Builder for [HabitFilter](../index.md).

#### Parameters

app

| | |
|---|---|
| priorityProvider | Provides the priorities for habits. |
| statusProvider | Provides the statuses for habits. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [app]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [app]<br>fun [build](build.md)(): [HabitFilter](../index.md) |
| [excludeStatus](exclude-status.md) | [app]<br>fun [excludeStatus](exclude-status.md)(status: [HabitModel.Status](../../../com.habithatch.demo.data.models/-habit-model/-status/index.md)): [HabitFilter.Builder](index.md) |
| [includeStatus](include-status.md) | [app]<br>fun [includeStatus](include-status.md)(status: [HabitModel.Status](../../../com.habithatch.demo.data.models/-habit-model/-status/index.md)): [HabitFilter.Builder](index.md) |
| [matchAll](match-all.md) | [app]<br>fun [matchAll](match-all.md)(): [HabitFilter.Builder](index.md) |
| [matchAllPriorities](match-all-priorities.md) | [app]<br>fun [matchAllPriorities](match-all-priorities.md)(): [HabitFilter.Builder](index.md) |
| [matchAllStatuses](match-all-statuses.md) | [app]<br>fun [matchAllStatuses](match-all-statuses.md)(): [HabitFilter.Builder](index.md) |
| [matchNoneStatuses](match-none-statuses.md) | [app]<br>fun [matchNoneStatuses](match-none-statuses.md)(): [HabitFilter.Builder](index.md) |
| [onlyMatch](only-match.md) | [app]<br>fun [onlyMatch](only-match.md)(status: [HabitModel.Status](../../../com.habithatch.demo.data.models/-habit-model/-status/index.md)): [HabitFilter.Builder](index.md) |
| [setDoneStatusVisibility](set-done-status-visibility.md) | [app]<br>fun [setDoneStatusVisibility](set-done-status-visibility.md)(visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [HabitFilter.Builder](index.md) |
| [setPriorityVisibility](set-priority-visibility.md) | [app]<br>fun [setPriorityVisibility](set-priority-visibility.md)(priorityVisibility: [PriorityVisibility](../../-priority-visibility/index.md)): [HabitFilter.Builder](index.md)<br>fun [setPriorityVisibility](set-priority-visibility.md)(priority: [HabitModel.Priority](../../../com.habithatch.demo.data.models/-habit-model/-priority/index.md), visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [HabitFilter.Builder](index.md) |
| [setSearchQuery](set-search-query.md) | [app]<br>fun [setSearchQuery](set-search-query.md)(searchQuery: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?): [HabitFilter.Builder](index.md) |
| [statusVisibility](status-visibility.md) | [app]<br>fun [statusVisibility](status-visibility.md)(statusVisibility: [StatusVisibility](../../-status-visibility/index.md)): [HabitFilter.Builder](index.md)<br>fun [statusVisibility](status-visibility.md)(status: [HabitModel.Status](../../../com.habithatch.demo.data.models/-habit-model/-status/index.md), visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [HabitFilter.Builder](index.md) |
