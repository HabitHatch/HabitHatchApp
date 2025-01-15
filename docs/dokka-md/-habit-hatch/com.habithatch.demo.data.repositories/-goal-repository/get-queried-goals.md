//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.repositories](../index.md)/[HabitRepository](index.md)/[getQueriedHabits](get-queried-habits.md)

# getQueriedHabits

[app]\
fun [getQueriedHabits](get-queried-habits.md)(query: [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md)): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;&gt;

Returns a flow of habits that match the given [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md). Sorted by HabitQuery's comparator.
