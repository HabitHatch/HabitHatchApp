//[HabitHatch](../../../../index.md)/[com.habithatch.demo.data.models](../../index.md)/[HabitModel](../index.md)/[Priority](index.md)

# Priority

[app]\
@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [Priority](index.md)(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val importance: [HabitModel.Priority.Importance](-importance/index.md), val iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val getColor: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html))

## Constructors

| | |
|---|---|
| [Priority](-priority.md) | [app]<br>constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), importance: [HabitModel.Priority.Importance](-importance/index.md), iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), getColor: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |

## Types

| Name | Summary |
|---|---|
| [Importance](-importance/index.md) | [app]<br>sealed class [Importance](-importance/index.md) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;[HabitModel.Priority.Importance](-importance/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [getColor](get-color.md) | [app]<br>val [getColor](get-color.md): @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| [iconResourceId](icon-resource-id.md) | [app]<br>val [iconResourceId](icon-resource-id.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [importance](importance.md) | [app]<br>val [importance](importance.md): [HabitModel.Priority.Importance](-importance/index.md) |
| [label](label.md) | [app]<br>val [label](label.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [getAlphaFactor](../../../com.habithatch.demo.core.util/get-alpha-factor.md) | [app]<br>fun [HabitModel.Priority](index.md).[getAlphaFactor](../../../com.habithatch.demo.core.util/get-alpha-factor.md)(): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)<br>Returns the alpha factor for the priority. Used to give more weight to high importance habits. |
| [isImportant](is-important.md) | [app]<br>fun [isImportant](is-important.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
