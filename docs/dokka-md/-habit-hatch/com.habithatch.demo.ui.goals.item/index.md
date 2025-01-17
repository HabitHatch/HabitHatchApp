//[HabitHatch](../../index.md)/[com.habithatch.demo.ui.habits.item](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [HabitStyle](-habit-style/index.md) | [app]<br>data class [HabitStyle](-habit-style/index.md)(val borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, val iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html))<br>The style of a habit. |

## Functions

| Name | Summary |
|---|---|
| [HabitItem](-habit-item.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [HabitItem](-habit-item.md)(habit: [HabitModel](../com.habithatch.demo.data.models/-habit-model/index.md), rowPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(12.dp), checkBoxPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(end = 8.dp), onCycleHabitStatus: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A card that displays a habit. |
