//[HabitHatch](../../index.md)/[com.habithatch.demo.ui.common](index.md)/[SelectionGrid](-selection-grid.md)

# SelectionGrid

[app]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun &lt;[T](-selection-grid.md)&gt; [SelectionGrid](-selection-grid.md)(elements: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[T](-selection-grid.md)&gt;, columns: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 2, outSidePadding: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 50.dp, spaceBetween: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 30.dp, onConfirm: ([T](-selection-grid.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), card: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)([T](-selection-grid.md), [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

A grid of elements that can be selected.