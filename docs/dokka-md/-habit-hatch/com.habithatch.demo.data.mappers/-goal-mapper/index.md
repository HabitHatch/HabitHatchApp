//[HabitHatch](../../../index.md)/[com.habithatch.demo.data.mappers](../index.md)/[GoalMapper](index.md)

# GoalMapper

[app]\
class [GoalMapper](index.md)@Injectconstructor(statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md), priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), goalModelFactory: [GoalModel.Factory](../../com.habithatch.demo.data.models/-goal-model/-factory/index.md))

[GoalMapper](index.md) is a mapper that maps [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) to [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md) and vice versa. [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md) is a RoomEntity, used for storing goals in the database. [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) is a model used for creating and displaying goals.

## Constructors

| | |
|---|---|
| [GoalMapper](-goal-mapper.md) | [app]<br>@Inject<br>constructor(statusProvider: [GoalStatusProvider](../../com.habithatch.demo.core.config/-goal-status-provider/index.md), priorityProvider: [GoalPriorityProvider](../../com.habithatch.demo.core.config/-goal-priority-provider/index.md), goalModelFactory: [GoalModel.Factory](../../com.habithatch.demo.data.models/-goal-model/-factory/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [asEntity](as-entity.md) | [app]<br>fun [asEntity](as-entity.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)<br>Maps a [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) to a [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md). Every Goal in the Database needs to have a createdAt date. If the goal is a draft, the createdAt date is set to the current date. |
| [asModel](as-model.md) | [app]<br>fun [asModel](as-model.md)(entity: [GoalEntity](../../com.habithatch.demo.data.entities/-goal-entity/index.md)): [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md) |