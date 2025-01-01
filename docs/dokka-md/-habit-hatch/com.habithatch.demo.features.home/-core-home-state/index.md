//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[CoreHomeState](index.md)

# CoreHomeState

[app]\
data class [CoreHomeState](index.md)(val pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)?, val isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Represents the main state information for the home screen.

## Constructors

| | |
|---|---|
| [CoreHomeState](-core-home-state.md) | [app]<br>constructor(pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)?, isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [allGoalsDone](all-goals-done.md) | [app]<br>val [allGoalsDone](all-goals-done.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| [isUserLoggedIn](is-user-logged-in.md) | [app]<br>val [isUserLoggedIn](is-user-logged-in.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| [onAddGoalClicked](on-add-goal-clicked.md) | [app]<br>val [onAddGoalClicked](on-add-goal-clicked.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [pet](pet.md) | [app]<br>val [pet](pet.md): [Pet](../../com.habithatch.demo.data.entities/-pet/index.md)? |