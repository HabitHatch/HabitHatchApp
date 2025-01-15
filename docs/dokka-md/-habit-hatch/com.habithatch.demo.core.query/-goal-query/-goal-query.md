//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[HabitQuery](index.md)/[HabitQuery](-habit-query.md)

# HabitQuery

[app]\
constructor(filter: [HabitFilter](../-habit-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../-habit-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, priorityProvider: [HabitPriorityProvider](../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../com.habithatch.demo.core.config/-habit-status-provider/index.md))

#### Parameters

app

| | |
|---|---|
| filter | The filter for the habits. |
| sortOptions | The sort options for the habits. |
| defaultComparator | The default comparator for the habits. |
| priorityProvider | Provides the priorities for habits. |
| statusProvider | Provides the statuses for habits. |
