//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.signup](../index.md)/[SignUpState](index.md)

# SignUpState

[app]\
enum [SignUpState](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[SignUpState](index.md)&gt; 

Represents the state of the signup screen. The [SignUpState.LOADING](-l-o-a-d-i-n-g/index.md) is needed to handle the state, that the UserEntity Information is loading. Since this Information is loaded from the in memory cache, the time to load the information is very short < 100ms. Therefore, the loading state is not visible to the user.

## Entries

| | |
|---|---|
| [SIGNED_UP](-s-i-g-n-e-d_-u-p/index.md) | [app]<br>[SIGNED_UP](-s-i-g-n-e-d_-u-p/index.md) |
| [NOT_SIGNED_UP](-n-o-t_-s-i-g-n-e-d_-u-p/index.md) | [app]<br>[NOT_SIGNED_UP](-n-o-t_-s-i-g-n-e-d_-u-p/index.md) |
| [LOADING](-l-o-a-d-i-n-g/index.md) | [app]<br>[LOADING](-l-o-a-d-i-n-g/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [app]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[SignUpState](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [app]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [SignUpState](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [app]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[SignUpState](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |