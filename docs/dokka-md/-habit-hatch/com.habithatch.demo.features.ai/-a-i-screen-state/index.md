//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.ai](../index.md)/[AIScreenState](index.md)

# AIScreenState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

class [AIScreenState](index.md)(val text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the AI screen.

#### Parameters

app

| | |
|---|---|
| text | The text to display on the screen. |
| isListening | Whether the AI assistant is currently listening. |
| showPermissionDialog | Whether to show the permission dialog. |
| onStartListening | The callback to start listening. |

## Constructors

| | |
|---|---|
| [AIScreenState](-a-i-screen-state.md) | [app]<br>constructor(text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [isListening](is-listening.md) | [app]<br>val [isListening](is-listening.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [onStartListening](on-start-listening.md) | [app]<br>val [onStartListening](on-start-listening.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [showPermissionDialog](show-permission-dialog.md) | [app]<br>val [showPermissionDialog](show-permission-dialog.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [text](text.md) | [app]<br>val [text](text.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |