//[HabitHatch](../../../../index.md)/[com.habithatch.demo.core.query](../../index.md)/[GoalQuery](../index.md)/[Factory](index.md)/[createGoalQuery](create-goal-query.md)

# createGoalQuery

[app]\
fun [createGoalQuery](create-goal-query.md)(filter: [GoalFilter](../../-goal-filter/index.md), sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalSortOption](../../-goal-sort-option/index.md)&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[GoalModel](../../../com.habithatch.demo.data.models/-goal-model/index.md)&gt; = compareBy { 0 }): [GoalQuery](../index.md)