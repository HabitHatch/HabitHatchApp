//[HabitHatch](../../index.md)/[com.habithatch.demo.features.signup](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SignupScreenState](-signup-screen-state/index.md) | [app]<br>data class [SignupScreenState](-signup-screen-state/index.md)(val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../com.habithatch.demo.data.entities/-pet/index.md)&gt;, val signUpState: [SignUpState](-sign-up-state/index.md), val onPetConfirmed: ([Pet](../com.habithatch.demo.data.entities/-pet/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Represents the state of the signup screen. |
| [SignUpState](-sign-up-state/index.md) | [app]<br>enum [SignUpState](-sign-up-state/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[SignUpState](-sign-up-state/index.md)&gt; <br>Represents the state of the signup screen. The [SignUpState.LOADING](-sign-up-state/-l-o-a-d-i-n-g/index.md) is needed to handle the state, that the User Information is loading. Since this Information is loaded from the in memory cache, the time to load the information is very short < 100ms. Therefore, the loading state is not visible to the user. |
| [SignupViewModel](-signup-view-model/index.md) | [app]<br>class [SignupViewModel](-signup-view-model/index.md)@Injectconstructor(userRepository: [UserRepository](../com.habithatch.demo.data.repositories/-user-repository/index.md), habitHatchConfig: [HabitHatchConfig](../com.habithatch.demo.core.config/-habit-hatch-config/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) |

## Functions

| Name | Summary |
|---|---|
| [rememberSignupScreenState](remember-signup-screen-state.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [rememberSignupScreenState](remember-signup-screen-state.md)(viewModel: [SignupViewModel](-signup-view-model/index.md) = hiltViewModel()): [SignupScreenState](-signup-screen-state/index.md) |
| [SignupScreen](-signup-screen.md) | [app]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [SignupScreen](-signup-screen.md)(state: [SignupScreenState](-signup-screen-state/index.md) = rememberSignupScreenState())<br>The signup screen composable. Is shown when the user first starts the App and is asked to select a pet. |