//[HabitHatch](../../../../../index.md)/[com.habithatch.demo.core.query](../../../index.md)/[GoalFilter](../../index.md)/[Builder](../index.md)/[Companion](index.md)/[createFromFilter](create-from-filter.md)

# createFromFilter

[app]\
fun [createFromFilter](create-from-filter.md)(goalFilter: [GoalFilter](../../index.md), priorityProvider: [GoalPriorityProvider](../../../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), statusProvider: [GoalStatusProvider](../../../../com.habithatch.demo.core.config/-goal-status-provider/index.md)): [GoalFilter.Builder](../index.md)

Creates a [GoalFilter.Builder](../index.md) from a [GoalFilter](../../index.md).

#### Parameters

app

| | |
|---|---|
| goalFilter | The [GoalFilter](../../index.md) to copy. |
| priorityProvider | Provides the priorities for goals. |
| statusProvider | Provides the statuses for goals. |