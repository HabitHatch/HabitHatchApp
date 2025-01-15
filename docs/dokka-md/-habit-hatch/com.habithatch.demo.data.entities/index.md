//[HabitHatch](../../index.md)/[com.habithatch.demo.data.entities](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [HabitEntity](-habit-entity/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [HabitEntity](-habit-entity/index.md)(val id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), val title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html))<br>[HabitEntity](-habit-entity/index.md) is a Room entity that represents a habit. |
| [Pet](-pet/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Pet](-pet/index.md)(val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))<br>[Pet](-pet/index.md) represents a pet |
| [User](-user/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [User](-user/index.md)(val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), val pet: [Pet](-pet/index.md))<br>[User](-user/index.md) represents a user. |
