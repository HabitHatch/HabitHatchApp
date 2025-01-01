//[HabitHatch](../../index.md)/[com.habithatch.demo.features.ai](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AIAssistantViewModel](-a-i-assistant-view-model/index.md) | [app]<br>class [AIAssistantViewModel](-a-i-assistant-view-model/index.md)@Injectconstructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |
| [AIScreenState](-a-i-screen-state/index.md) | [app]<br>@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)<br>class [AIScreenState](-a-i-screen-state/index.md)(val text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Represents the state of the AI screen. |

## Functions

| Name | Summary |
|---|---|
| [AIScreen](-a-i-screen.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [AIScreen](-a-i-screen.md)(state: [AIScreenState](-a-i-screen-state/index.md) = rememberAIScreenState(), topNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), bottomNavBar: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>The AI screen composable. |
| [rememberAIScreenState](remember-a-i-screen-state.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [rememberAIScreenState](remember-a-i-screen-state.md)(viewModel: [AIAssistantViewModel](-a-i-assistant-view-model/index.md) = hiltViewModel()): [AIScreenState](-a-i-screen-state/index.md) |