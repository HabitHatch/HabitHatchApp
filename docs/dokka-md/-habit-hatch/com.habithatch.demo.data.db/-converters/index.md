//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.db](../index.md)/[Converters](index.md)

# Converters

[app]\
class [Converters](index.md)

[Converters](index.md) is a class that provides type converters for Room. Converts between UUID and String and Instant and String.

## Constructors

| | |
|---|---|
| [Converters](-converters.md) | [app]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [fromInstant](from-instant.md) | [app]<br>fun [fromInstant](from-instant.md)(instant: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [fromUUID](from-u-u-i-d.md) | [app]<br>fun [fromUUID](from-u-u-i-d.md)(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [toInstant](to-instant.md) | [app]<br>fun [toInstant](to-instant.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| [toUUID](to-u-u-i-d.md) | [app]<br>fun [toUUID](to-u-u-i-d.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |