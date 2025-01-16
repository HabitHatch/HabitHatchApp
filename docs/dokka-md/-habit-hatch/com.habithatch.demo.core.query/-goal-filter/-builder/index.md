//[HabitHatch](../../../../index.md)/[com.habithatch.demo.core.query](../../index.md)/[GoalFilter](../index.md)/[Builder](index.md)

# Builder

[app]\
data class [Builder](index.md)

Builder for [GoalFilter](../index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [app]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [allPriorities](all-priorities.md) | [app]<br>val [allPriorities](all-priorities.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Priority](../../../com.habithatch.demo.data.models/-goal-model/-priority/index.md)&gt; |
| [allStatuses](all-statuses.md) | [app]<br>val [allStatuses](all-statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Status](../../../com.habithatch.demo.data.models/-goal-model/-status/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [app]<br>fun [build](build.md)(): [GoalFilter](../index.md) |
| [matchAll](match-all.md) | [app]<br>fun [matchAll](match-all.md)(): [GoalFilter.Builder](index.md) |
| [matchAllPriorities](match-all-priorities.md) | [app]<br>fun [matchAllPriorities](match-all-priorities.md)(): [GoalFilter.Builder](index.md) |
| [matchAllStatuses](match-all-statuses.md) | [app]<br>fun [matchAllStatuses](match-all-statuses.md)(): [GoalFilter.Builder](index.md) |
| [matchNoneStatuses](match-none-statuses.md) | [app]<br>fun [matchNoneStatuses](match-none-statuses.md)(): [GoalFilter.Builder](index.md) |
| [onlyMatch](only-match.md) | [app]<br>fun [onlyMatch](only-match.md)(status: [GoalModel.Status](../../../com.habithatch.demo.data.models/-goal-model/-status/index.md)): [GoalFilter.Builder](index.md) |
| [priorityVisibility](priority-visibility.md) | [app]<br>fun [priorityVisibility](priority-visibility.md)(priorityVisibility: [PriorityVisibility](../../-priority-visibility/index.md)): [GoalFilter.Builder](index.md)<br>fun [priorityVisibility](priority-visibility.md)(priority: [GoalModel.Priority](../../../com.habithatch.demo.data.models/-goal-model/-priority/index.md), visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [GoalFilter.Builder](index.md) |
| [setDoneStatusVisibility](set-done-status-visibility.md) | [app]<br>fun [setDoneStatusVisibility](set-done-status-visibility.md)(visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [GoalFilter.Builder](index.md) |
| [setSearchQuery](set-search-query.md) | [app]<br>fun [setSearchQuery](set-search-query.md)(searchQuery: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?): [GoalFilter.Builder](index.md) |
| [statusVisibility](status-visibility.md) | [app]<br>fun [statusVisibility](status-visibility.md)(statusVisibility: [StatusVisibility](../../-status-visibility/index.md)): [GoalFilter.Builder](index.md)<br>fun [statusVisibility](status-visibility.md)(status: [GoalModel.Status](../../../com.habithatch.demo.data.models/-goal-model/-status/index.md), visible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [GoalFilter.Builder](index.md) |