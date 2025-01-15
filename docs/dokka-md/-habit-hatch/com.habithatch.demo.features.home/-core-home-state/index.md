//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[CoreHomeState](index.md)

# CoreHomeState

[app]\
data class [CoreHomeState](index.md)(val pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)?, val isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val allHabitsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val onAddHabitClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Represents the main state information for the home screen.

## Constructors

| | |
|---|---|
| [CoreHomeState](-core-home-state.md) | [app]<br>constructor(pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)?, isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, allHabitsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onAddHabitClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [allHabitsDone](all-habits-done.md) | [app]<br>val [allHabitsDone](all-habits-done.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| [isUserLoggedIn](is-user-logged-in.md) | [app]<br>val [isUserLoggedIn](is-user-logged-in.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| [onAddHabitClicked](on-add-habit-clicked.md) | [app]<br>val [onAddHabitClicked](on-add-habit-clicked.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [pet](pet.md) | [app]<br>val [pet](pet.md): [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)? |
