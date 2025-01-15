//[HabitHatch](../../../../index.md)/[com.habithatch.demo.core.query](../../index.md)/[HabitQuery](../index.md)/[Factory](index.md)

# Factory

[app]\
class [Factory](index.md)@Injectconstructor(priorityProvider: [HabitPriorityProvider](../../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../../com.habithatch.demo.core.config/-habit-status-provider/index.md))

## Constructors

| | |
|---|---|
| [Factory](-factory.md) | [app]<br>@Inject<br>constructor(priorityProvider: [HabitPriorityProvider](../../../com.habithatch.demo.core.config/-habit-priority-provider/index.md), statusProvider: [HabitStatusProvider](../../../com.habithatch.demo.core.config/-habit-status-provider/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createFilterQuery](create-filter-query.md) | [app]<br>fun [createFilterQuery](create-filter-query.md)(filter: [HabitFilter](../../-habit-filter/index.md)): [HabitQuery](../index.md) |
| [createHabitQuery](create-habit-query.md) | [app]<br>fun [createHabitQuery](create-habit-query.md)(filter: [HabitFilter](../../-habit-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitSortOption](../../-habit-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../../com.habithatch.demo.data.models/-habit-model/index.md)&gt; = compareBy { 0 }): [HabitQuery](../index.md) |
