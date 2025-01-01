//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.signup](../index.md)/[SignupScreenState](index.md)

# SignupScreenState

[app]\
data class [SignupScreenState](index.md)(val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt;, val signUpState: [SignUpState](../-sign-up-state/index.md), val onPetConfirmed: ([Pet](../../com.habithatch.demo.data.entities/-pet/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the signup screen.

## Constructors

| | |
|---|---|
| [SignupScreenState](-signup-screen-state.md) | [app]<br>constructor(pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt;, signUpState: [SignUpState](../-sign-up-state/index.md), onPetConfirmed: ([Pet](../../com.habithatch.demo.data.entities/-pet/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [onPetConfirmed](on-pet-confirmed.md) | [app]<br>val [onPetConfirmed](on-pet-confirmed.md): ([Pet](../../com.habithatch.demo.data.entities/-pet/index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| [pets](pets.md) | [app]<br>val [pets](pets.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Pet](../../com.habithatch.demo.data.entities/-pet/index.md)&gt; |
| [signUpState](sign-up-state.md) | [app]<br>val [signUpState](sign-up-state.md): [SignUpState](../-sign-up-state/index.md) |