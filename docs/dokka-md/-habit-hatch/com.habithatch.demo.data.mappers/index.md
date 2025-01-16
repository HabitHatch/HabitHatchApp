//[HabitHatch](../../index.md)/[com.habithatch.demo.data.mappers](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [EntityModelMapper](-entity-model-mapper/index.md) | [app]<br>interface [EntityModelMapper](-entity-model-mapper/index.md)&lt;[E](-entity-model-mapper/index.md), [M](-entity-model-mapper/index.md)&gt; |
| [GoalMapper](-goal-mapper/index.md) | [app]<br>class [GoalMapper](-goal-mapper/index.md)@Injectconstructor(statusProvider: [GoalStatusProvider](../com.habithatch.demo.core.config/-goal-status-provider/index.md), priorityProvider: [GoalPriorityProvider](../com.habithatch.demo.core.config/-goal-priority-provider/index.md), goalModelFactory: [GoalModel.Factory](../com.habithatch.demo.data.models/-goal-model/-factory/index.md)) : [EntityModelMapper](-entity-model-mapper/index.md)&lt;[GoalEntity](../com.habithatch.demo.data.entities/-goal-entity/index.md), [GoalModel](../com.habithatch.demo.data.models/-goal-model/index.md)&gt; <br>[GoalMapper](-goal-mapper/index.md) is a mapper that maps [GoalModel](../com.habithatch.demo.data.models/-goal-model/index.md) to [GoalEntity](../com.habithatch.demo.data.entities/-goal-entity/index.md) and vice versa. [GoalEntity](../com.habithatch.demo.data.entities/-goal-entity/index.md) is a RoomEntity, used for storing goals in the database. [GoalModel](../com.habithatch.demo.data.models/-goal-model/index.md) is a model used for creating and displaying goals. |
| [UserMapper](-user-mapper/index.md) | [app]<br>class [UserMapper](-user-mapper/index.md)@Injectconstructor(config: [HabitHatchConfig](../com.habithatch.demo.core.config/-habit-hatch-config/index.md)) : [EntityModelMapper](-entity-model-mapper/index.md)&lt;[UserEntity](../com.habithatch.demo.data.entities/-user-entity/index.md), [UserModel](../com.habithatch.demo.data.models/-user-model/index.md)&gt; |