//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[HabitStatusProvider](index.md)

# HabitStatusProvider

interface [HabitStatusProvider](index.md)

Provides the statuses for habits.

#### Inheritors

| |
|---|
| [HabitHatchConfig](../-habit-hatch-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [defaultStatus](default-status.md) | [app]<br>abstract val [defaultStatus](default-status.md): [HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md) |
| [statuses](statuses.md) | [app]<br>abstract val [statuses](statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getStatusByLabel](get-status-by-label.md) | [app]<br>open fun [getStatusByLabel](get-status-by-label.md)(statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [HabitModel.Status](../../com.habithatch.demo.data.models/-habit-model/-status/index.md) |
