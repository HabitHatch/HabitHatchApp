//[HabitHatch](../../../index.md)/[com.habithatch.demo.core.config](../index.md)/[GoalStatusProvider](index.md)

# GoalStatusProvider

interface [GoalStatusProvider](index.md)

Provides the statuses for goals.

#### Inheritors

| |
|---|
| [HabitHatchConfig](../-habit-hatch-config/index.md) |

## Properties

| Name | Summary |
|---|---|
| [defaultStatus](default-status.md) | [app]<br>abstract val [defaultStatus](default-status.md): [GoalModel.Status](../../com.habithatch.demo.data.models/-goal-model/-status/index.md) |
| [statuses](statuses.md) | [app]<br>abstract val [statuses](statuses.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[GoalModel.Status](../../com.habithatch.demo.data.models/-goal-model/-status/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [getStatusByLabel](get-status-by-label.md) | [app]<br>open fun [getStatusByLabel](get-status-by-label.md)(statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [GoalModel.Status](../../com.habithatch.demo.data.models/-goal-model/-status/index.md) |