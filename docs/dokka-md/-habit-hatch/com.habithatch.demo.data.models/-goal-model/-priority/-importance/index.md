//[HabitHatch](../../../../../index.md)/[com.habithatch.demo.data.models](../../../index.md)/[GoalModel](../../index.md)/[Priority](../index.md)/[Importance](index.md)

# Importance

sealed class [Importance](index.md) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;[GoalModel.Priority.Importance](index.md)&gt; 

#### Inheritors

| |
|---|
| [VeryLow](-very-low/index.md) |
| [Low](-low/index.md) |
| [Normal](-normal/index.md) |
| [High](-high/index.md) |
| [VeryHigh](-very-high/index.md) |

## Types

| Name | Summary |
|---|---|
| [High](-high/index.md) | [app]<br>object [High](-high/index.md) : [GoalModel.Priority.Importance](index.md) |
| [Low](-low/index.md) | [app]<br>object [Low](-low/index.md) : [GoalModel.Priority.Importance](index.md) |
| [Normal](-normal/index.md) | [app]<br>object [Normal](-normal/index.md) : [GoalModel.Priority.Importance](index.md) |
| [VeryHigh](-very-high/index.md) | [app]<br>object [VeryHigh](-very-high/index.md) : [GoalModel.Priority.Importance](index.md) |
| [VeryLow](-very-low/index.md) | [app]<br>object [VeryLow](-very-low/index.md) : [GoalModel.Priority.Importance](index.md) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [app]<br>val [value](value.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | [app]<br>open operator override fun [compareTo](compare-to.md)(other: [GoalModel.Priority.Importance](index.md)): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |