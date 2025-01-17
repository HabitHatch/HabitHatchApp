//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.entities](../index.md)/[Pet](index.md)

# Pet

[app]\
data class [Pet](index.md)(val id: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = generateId(), val nameRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val coverImage: [ImageResource](../../com.habithatch.demo.core.animation/-image-resource/index.md), petMoodAnimations: [PetMoodAnimations](../-pet-mood-animations/index.md)? = null, mood: [PetMood](../-pet-mood/index.md)? = null)

[Pet](index.md) represents a pet

## Constructors

| | |
|---|---|
| [Pet](-pet.md) | [app]<br>constructor(id: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = generateId(), nameRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), coverImage: [ImageResource](../../com.habithatch.demo.core.animation/-image-resource/index.md), petMoodAnimations: [PetMoodAnimations](../-pet-mood-animations/index.md)? = null, mood: [PetMood](../-pet-mood/index.md)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [app]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [animationState](animation-state.md) | [app]<br>var [animationState](animation-state.md): MutableStateFlow&lt;[FrameStateAnimation](../../com.habithatch.demo.core.animation/-frame-state-animation/index.md)?&gt; |
| [coverImage](cover-image.md) | [app]<br>val [coverImage](cover-image.md): [ImageResource](../../com.habithatch.demo.core.animation/-image-resource/index.md) |
| [id](id.md) | [app]<br>val [id](id.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [nameRes](name-res.md) | [app]<br>val [nameRes](name-res.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [app]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [app]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [app]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [updateMood](update-mood.md) | [app]<br>fun [updateMood](update-mood.md)(allHabits: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;) |