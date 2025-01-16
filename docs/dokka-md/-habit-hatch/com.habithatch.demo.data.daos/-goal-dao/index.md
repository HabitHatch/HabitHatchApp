//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[GoalDao](index.md)

# GoalDao

[app]\
interface [GoalDao](index.md)

The Data Access Object for the [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md) class.

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>abstract suspend fun [deleteAll](delete-all.md)()<br>Deletes all goals from the database. |
| [getAll](get-all.md) | [app]<br>abstract fun [getAll](get-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)&gt;&gt; |
| [insert](insert.md) | [app]<br>abstract suspend fun [insert](insert.md)(goal: [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md))<br>abstract suspend fun [insert](insert.md)(goals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)&gt;) |
| [update](update.md) | [app]<br>abstract suspend fun [update](update.md)(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Updates the goal with the given [id](update.md) with the given [title](update.md), [statusLabel](update.md), and [priorityLabel](update.md). [GoalEntity.createdAt](../../com.habithatch.demo.data.entities/-goal-entity/created-at.md) and [GoalEntity.id](../../com.habithatch.demo.data.entities/-goal-entity/id.md) are not allowed tto be updated. |