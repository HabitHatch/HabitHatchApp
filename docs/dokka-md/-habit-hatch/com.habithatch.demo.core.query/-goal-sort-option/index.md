//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.query](../index.md)/[HabitSortOption](index.md)

# HabitSortOption

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data class [HabitSortOption](index.md)(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, val sortState: [SortState](../-sort-state/index.md) = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;[HabitSortOption](index.md)&gt; 

Represents a sort option for habits.

#### Parameters

app

| | |
|---|---|
| label | The label of the sort option. |
| _comparator | The comparator for the sort option. |
| sortState | The current state of the sort option. |
| uiIndex | changes the position of the sort option in the UI. |

## Constructors

| | |
|---|---|
| [HabitSortOption](-habit-sort-option.md) | [app]<br>constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;, sortState: [SortState](../-sort-state/index.md) = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [comparator](comparator.md) | [app]<br>val [comparator](comparator.md): [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt; |
| [label](label.md) | [app]<br>val [label](label.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [sortState](sort-state.md) | [app]<br>val [sortState](sort-state.md): [SortState](../-sort-state/index.md) |

## Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | [app]<br>open operator override fun [compareTo](compare-to.md)(other: [HabitSortOption](index.md)): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [cycleState](cycle-state.md) | [app]<br>fun [cycleState](cycle-state.md)(): [HabitSortOption](index.md)<br>Returns a copy of this sort option with the sort state cycled. |
| [equals](equals.md) | [app]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [app]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [isUsed](is-used.md) | [app]<br>fun [isUsed](is-used.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [toString](to-string.md) | [app]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
