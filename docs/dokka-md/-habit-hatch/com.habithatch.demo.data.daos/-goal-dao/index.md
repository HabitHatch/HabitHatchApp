//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.daos](../index.md)/[HabitDao](index.md)

# HabitDao

[app]\
interface [HabitDao](index.md)

The Data Access Object for the [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md) class.

## Functions

| Name | Summary |
|---|---|
| [deleteAll](delete-all.md) | [app]<br>abstract suspend fun [deleteAll](delete-all.md)() |
| [getAll](get-all.md) | [app]<br>abstract fun [getAll](get-all.md)(): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)&gt;&gt; |
| [getHabitById](get-habit-by-id.md) | [app]<br>abstract fun [getHabitById](get-habit-by-id.md)(habitId: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): Flow&lt;[HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)?&gt; |
| [insert](insert.md) | [app]<br>abstract suspend fun [insert](insert.md)(habit: [HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)) |
| [insertAll](insert-all.md) | [app]<br>abstract suspend fun [insertAll](insert-all.md)(habits: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[HabitEntity](../../com.habithatch.demo.data.entities/-habit-entity/index.md)&gt;) |
| [update](update.md) | [app]<br>abstract suspend fun [update](update.md)(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |
