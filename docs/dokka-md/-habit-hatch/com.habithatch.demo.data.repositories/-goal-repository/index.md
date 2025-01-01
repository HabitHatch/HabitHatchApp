//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.repositories](../index.md)/[GoalRepository](index.md)

# GoalRepository

[app]\
class [GoalRepository](index.md)@Injectconstructor(goalDao: [GoalDao](../../com.habithatch.demo.data.daos/-goal-dao/index.md), goalMapper: [GoalMapper](../../com.habithatch.demo.data.mappers/-goal-mapper/index.md), userRepository: [UserRepository](../-user-repository/index.md))

[GoalRepository](index.md) is a repository that provides access to goals in the database.

## Constructors

| | |
|---|---|
| [GoalRepository](-goal-repository.md) | [app]<br>@Inject<br>constructor(goalDao: [GoalDao](../../com.habithatch.demo.data.daos/-goal-dao/index.md), goalMapper: [GoalMapper](../../com.habithatch.demo.data.mappers/-goal-mapper/index.md), userRepository: [UserRepository](../-user-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>suspend fun [deleteAll](delete-all.md)()<br>Deletes all goals permanently from the database. |
| [getQueriedGoals](get-queried-goals.md) | [app]<br>fun [getQueriedGoals](get-queried-goals.md)(query: [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md)): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;&gt;<br>Returns a flow of goals that match the given [GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md). Sorted by GoalQuery's comparator. |
| [insert](insert.md) | [app]<br>suspend fun [insert](insert.md)(vararg goals: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md))<br>Inserts the given goals into the database. |
| [update](update.md) | [app]<br>suspend fun [update](update.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md))<br>Updates the given goal in the database. |