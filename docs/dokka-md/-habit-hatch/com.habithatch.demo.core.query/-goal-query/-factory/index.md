//[HabitHatch](../../../../index.md)/[com.habithatch.demo.core.query](../../index.md)/[GoalQuery](../index.md)/[Factory](index.md)

# Factory

[app]\
class [Factory](index.md)@Injectconstructor(priorityProvider: [GoalPriorityProvider](../../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../../com.habithatch.demo.core.config/-goal-status-provider/index.md))

## Constructors

| | |
|---|---|
| [Factory](-factory.md) | [app]<br>@Inject<br>constructor(priorityProvider: [GoalPriorityProvider](../../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../../com.habithatch.demo.core.config/-goal-status-provider/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createFilterQuery](create-filter-query.md) | [app]<br>fun [createFilterQuery](create-filter-query.md)(filter: [GoalFilter](../../-goal-filter/index.md)): [GoalQuery](../index.md) |
| [createGoalQuery](create-goal-query.md) | [app]<br>fun [createGoalQuery](create-goal-query.md)(filter: [GoalFilter](../../-goal-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../../-goal-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; = compareBy { 0 }): [GoalQuery](../index.md) |