//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.entities](../index.md)/[User](index.md)

# User

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [User](index.md)(val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), val pet: [Pet](../-pet/index.md))

[User](index.md) represents a user.

#### Parameters

app

| | |
|---|---|
| uuid | the UUID of the user, for global identification |
| pet | the pet of the user |

## Constructors

| | |
|---|---|
| [User](-user.md) | [app]<br>constructor(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), pet: [Pet](../-pet/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [pet](pet.md) | [app]<br>val [pet](pet.md): [Pet](../-pet/index.md) |
| [uuid](uuid.md) | [app]<br>val [uuid](uuid.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |