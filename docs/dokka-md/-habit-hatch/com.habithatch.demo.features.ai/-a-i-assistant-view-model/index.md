//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.ai](../index.md)/[AIAssistantViewModel](index.md)

# AIAssistantViewModel

[app]\
class [AIAssistantViewModel](index.md)@Injectconstructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [AIAssistantViewModel](-a-i-assistant-view-model.md) | [app]<br>@Inject<br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) |

## Properties

| Name | Summary |
|---|---|
| [isListening](is-listening.md) | [app]<br>val [isListening](is-listening.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [showPermissionDialog](show-permission-dialog.md) | [app]<br>val [showPermissionDialog](show-permission-dialog.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [text](text.md) | [app]<br>val [text](text.md): StateFlow&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [startListening](start-listening.md) | [app]<br>fun [startListening](start-listening.md)() |