//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[GoalDao](index.md)/[update](update.md)

# update

[app]\
abstract suspend fun [update](update.md)(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

Updates the goal with the given [id](update.md) with the given [title](update.md), [statusLabel](update.md), and [priorityLabel](update.md). [GoalEntity.createdAt](../../com.habithatch.demo.data.entities/-goal-entity/created-at.md) and [GoalEntity.id](../../com.habithatch.demo.data.entities/-goal-entity/id.md) are not allowed tto be updated.