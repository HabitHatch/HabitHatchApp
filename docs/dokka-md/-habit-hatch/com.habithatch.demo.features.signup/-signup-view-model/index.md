//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.signup](../index.md)/[SignupViewModel](index.md)

# SignupViewModel

[app]\
class [SignupViewModel](index.md)@Injectconstructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), habitHatchConfig: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [SignupViewModel](-signup-view-model.md) | [app]<br>@Inject<br>constructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), habitHatchConfig: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [pets](pets.md) | [app]<br>val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [signUpState](sign-up-state.md) | [app]<br>val [signUpState](sign-up-state.md): StateFlow&lt;[SignUpState](../-sign-up-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [signUpUser](sign-up-user.md) | [app]<br>fun [signUpUser](sign-up-user.md)(user: [User](../../com.habithatch.demo.data.entities/-user/index.md)) |