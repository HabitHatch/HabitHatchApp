//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[GoalDao](index.md)

# GoalDao

[app]\
interface [GoalDao](index.md)

The Data Access Object for the [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md) class.

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>abstract suspend fun [deleteAll](delete-all.md)() |
| [getAll](get-all.md) | [app]<br>abstract fun [getAll](get-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)&gt;&gt; |
| [getGoalById](get-goal-by-id.md) | [app]<br>abstract fun [getGoalById](get-goal-by-id.md)(goalId: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): Flow&lt;[GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)?&gt; |
| [insert](insert.md) | [app]<br>abstract suspend fun [insert](insert.md)(goal: [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)) |
| [insertAll](insert-all.md) | [app]<br>abstract suspend fun [insertAll](insert-all.md)(goals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)&gt;) |
| [update](update.md) | [app]<br>abstract suspend fun [update](update.md)(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |