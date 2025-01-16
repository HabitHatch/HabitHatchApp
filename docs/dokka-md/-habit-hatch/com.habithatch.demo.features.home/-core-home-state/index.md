//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[CoreHomeState](index.md)

# CoreHomeState

data class [CoreHomeState](index.md)(val pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md), val onFabClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Represents the main state information for the home screen.

#### Parameters

app

| | |
|---|---|
| pet | The pet to display. |
| onFabClicked | The callback for when the Floating Action Button is clicked. |

## Constructors

| | |
|---|---|
| [CoreHomeState](-core-home-state.md) | [app]<br>constructor(pet: [Pet](../../com.habithatch.demo.data.entities/-pet/index.md), onFabClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

## Properties

| Name | Summary |
|---|---|
| [onFabClicked](on-fab-clicked.md) | [app]<br>val [onFabClicked](on-fab-clicked.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [pet](pet.md) | [app]<br>val [pet](pet.md): [Pet](../../com.habithatch.demo.data.entities/-pet/index.md) |