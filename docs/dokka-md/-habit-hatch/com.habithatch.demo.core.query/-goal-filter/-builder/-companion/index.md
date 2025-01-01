//[HabitHatch](../../../../../index.md)/[com.habithatch.demo.core.query](../../../index.md)/[GoalFilter](../../index.md)/[Builder](../index.md)/[Companion](index.md)

# Companion

[app]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [createFromFilter](create-from-filter.md) | [app]<br>fun [createFromFilter](create-from-filter.md)(goalFilter: [GoalFilter](../../index.md), priorityProvider: [GoalPriorityProvider](../../../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../../../com.habithatch.demo.core.config/-goal-status-provider/index.md)): [GoalFilter.Builder](../index.md)<br>Creates a [GoalFilter.Builder](../index.md) from a [GoalFilter](../../index.md). |
| [matchAllBuilder](match-all-builder.md) | [app]<br>fun [matchAllBuilder](match-all-builder.md)(priorityProvider: [GoalPriorityProvider](../../../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../../../com.habithatch.demo.core.config/-goal-status-provider/index.md)): [GoalFilter.Builder](../index.md)<br>Creates a [GoalFilter.Builder](../index.md) that matches all goals. |