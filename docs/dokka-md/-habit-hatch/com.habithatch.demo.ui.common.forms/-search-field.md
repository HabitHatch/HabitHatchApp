//[HabitHatch](../../index.md)/[com.habithatch.demo.ui.common.forms](index.md)/[SearchField](-search-field.md)

# SearchField

[app]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [SearchField](-search-field.md)(searchQuery: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onQueryChange: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, shape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) = MaterialTheme.shapes.large, textStyle: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = MaterialTheme.typography.bodySmall)

A search field that allows the user to input a search query.

#### Parameters

app

| | |
|---|---|
| searchQuery | The current search query. |
| onQueryChange | The callback to be called when the search query changes. |
| modifier | The modifier to be applied to the search field. |
| shape | The shape of the search field. |
| textStyle | The text style of the search field. |