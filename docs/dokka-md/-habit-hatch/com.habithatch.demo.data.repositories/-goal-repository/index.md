//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.repositories](../index.md)/[HabitRepository](index.md)

# HabitRepository

[app]\
class [HabitRepository](index.md)@Injectconstructor(habitDao: [HabitDao](../../com.habithatch.demo.data.daos/-habit-dao/index.md), habitMapper: [HabitMapper](../../com.habithatch.demo.data.mappers/-habit-mapper/index.md), userRepository: [UserRepository](../-user-repository/index.md))

[HabitRepository](index.md) is a repository that provides access to habits in the database.

## Constructors

| | |
|---|---|
| [HabitRepository](-habit-repository.md) | [app]<br>@Inject<br>constructor(habitDao: [HabitDao](../../com.habithatch.demo.data.daos/-habit-dao/index.md), habitMapper: [HabitMapper](../../com.habithatch.demo.data.mappers/-habit-mapper/index.md), userRepository: [UserRepository](../-user-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>suspend fun [deleteAll](delete-all.md)()<br>Deletes all habits permanently from the database. |
| [getQueriedHabits](get-queried-habits.md) | [app]<br>fun [getQueriedHabits](get-queried-habits.md)(query: [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md)): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;&gt;<br>Returns a flow of habits that match the given [HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md). Sorted by HabitQuery's comparator. |
| [insert](insert.md) | [app]<br>suspend fun [insert](insert.md)(vararg habits: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md))<br>Inserts the given habits into the database. |
| [update](update.md) | [app]<br>suspend fun [update](update.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md))<br>Updates the given habit in the database. |
