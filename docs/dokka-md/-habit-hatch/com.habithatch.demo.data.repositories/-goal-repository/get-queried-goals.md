//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.repositories](../index.md)/[GoalRepository](index.md)/[getQueriedGoals](get-queried-goals.md)

# getQueriedGoals

[app]\
fun [getQueriedGoals](get-queried-goals.md)(query: [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md)): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;&gt;

Returns a flow of goals that match the given [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md). Sorted by GoalQuery's comparator.