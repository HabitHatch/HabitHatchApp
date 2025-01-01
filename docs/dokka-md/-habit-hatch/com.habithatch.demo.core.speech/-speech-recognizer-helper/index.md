//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.speech](../index.md)/[SpeechRecognizerHelper](index.md)

# SpeechRecognizerHelper

class [SpeechRecognizerHelper](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), onResult: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), endOfSpeechCallback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Helper class for speech recognition.

#### Parameters

app

| | |
|---|---|
| context | The context to use for creating the SpeechRecognizer. |
| onResult | Callback to be called when speech recognition is successful. |
| endOfSpeechCallback | Callback to be called when speech input ends. |

## Constructors

| | |
|---|---|
| [SpeechRecognizerHelper](-speech-recognizer-helper.md) | [app]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), onResult: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), endOfSpeechCallback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [app]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [destroy](destroy.md) | [app]<br>fun [destroy](destroy.md)() |
| [startListening](start-listening.md) | [app]<br>fun [startListening](start-listening.md)(prompt: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;Speak now&quot;) |