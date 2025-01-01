//[HabitHatch](../../index.md)/[com.habithatch.demo.ui.goals.item](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [GoalStyle](-goal-style/index.md) | [app]<br>data class [GoalStyle](-goal-style/index.md)(val borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, val iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html))<br>The style of a goal. |

## Functions

| Name | Summary |
|---|---|
| [GoalItem](-goal-item.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [GoalItem](-goal-item.md)(goal: [GoalModel](../com.habithatch.demo.data.models/-goal-model/index.md), rowPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(12.dp), checkBoxPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) = PaddingValues(end = 8.dp), onCycleGoalStatus: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A card that displays a goal. |