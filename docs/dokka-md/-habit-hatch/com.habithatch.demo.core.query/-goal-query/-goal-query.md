//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[GoalQuery](index.md)/[GoalQuery](-goal-query.md)

# GoalQuery

[app]\
constructor(filter: [GoalFilter](../-goal-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../-goal-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;, priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md))

#### Parameters

app

| | |
|---|---|
| filter | The filter for the goals. |
| sortOptions | The sort options for the goals. |
| defaultComparator | The default comparator for the goals. |
| priorityProvider | Provides the priorities for goals. |
| statusProvider | Provides the statuses for goals. |