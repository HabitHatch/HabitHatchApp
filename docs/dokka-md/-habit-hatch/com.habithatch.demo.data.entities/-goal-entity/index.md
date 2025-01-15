//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.entities](../index.md)/[HabitEntity](index.md)

# HabitEntity

[app]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [HabitEntity](index.md)(val id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), val title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html))

[HabitEntity](index.md) is a Room entity that represents a habit.

## Constructors

| | |
|---|---|
| [HabitEntity](-habit-entity.md) | [app]<br>constructor(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)) |

## Properties

| Name | Summary |
|---|---|
| [createdAt](created-at.md) | [app]<br>val [createdAt](created-at.md): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| [id](id.md) | [app]<br>val [id](id.md): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) |
| [priorityLabel](priority-label.md) | [app]<br>val [priorityLabel](priority-label.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [statusLabel](status-label.md) | [app]<br>val [statusLabel](status-label.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [title](title.md) | [app]<br>val [title](title.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [userId](user-id.md) | [app]<br>val [userId](user-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |
