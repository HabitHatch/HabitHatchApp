//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.models](../index.md)/[GoalModel](index.md)

# GoalModel

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [GoalModel](index.md)

[GoalModel](index.md) represents a goal.

#### Parameters

app

| | |
|---|---|
| title | the title of the goal |
| status | the status of the goal |
| priority | the priority of the goal |
| createdAt | the creation date of the goal |
| isDraft | whether the goal is a draft |

## Types

| Name | Summary |
|---|---|
| [Factory](-factory/index.md) | [app]<br>class [Factory](-factory/index.md)@Injectconstructor |
| [Priority](-priority/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Priority](-priority/index.md)(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val importance: [GoalModel.Priority.Importance](-priority/-importance/index.md), val iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val getColor: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |
| [Status](-status/index.md) | [app]<br>@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)<br>data class [Status](-status/index.md)(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val stepNumber: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val isDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false) |

## Properties

| Name | Summary |
|---|---|
| [createdAt](created-at.md) | [app]<br>val [createdAt](created-at.md): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)? |
| [isDraft](is-draft.md) | [app]<br>val [isDraft](is-draft.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| [priority](priority.md) | [app]<br>val [priority](priority.md): [GoalModel.Priority](-priority/index.md) |
| [status](status.md) | [app]<br>val [status](status.md): [GoalModel.Status](-status/index.md) |
| [title](title.md) | [app]<br>val [title](title.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [userId](user-id.md) | [app]<br>val [userId](user-id.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |

## Functions

| Name | Summary |
|---|---|
| [getCreatedAtOrNow](get-created-at-or-now.md) | [app]<br>fun [getCreatedAtOrNow](get-created-at-or-now.md)(): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| [getUniqueId](get-unique-id.md) | [app]<br>fun [getUniqueId](get-unique-id.md)(): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) |
| [isDone](is-done.md) | [app]<br>fun [isDone](is-done.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |