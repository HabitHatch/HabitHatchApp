//[HabitHatch](../../../../index.md)/[com.habithatch.demo.data.models](../../index.md)/[GoalModel](../index.md)/[Factory](index.md)

# Factory

[app]\
class [Factory](index.md)@Injectconstructor

## Constructors

| | |
|---|---|
| [Factory](-factory.md) | [app]<br>@Inject<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [createDraft](create-draft.md) | [app]<br>fun [createDraft](create-draft.md)(status: [GoalModel.Status](../-status/index.md), priority: [GoalModel.Priority](../-priority/index.md)): [GoalModel](../index.md)<br>fun [createDraft](create-draft.md)(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, status: [GoalModel.Status](../-status/index.md), priority: [GoalModel.Priority](../-priority/index.md)): [GoalModel](../index.md) |
| [createExample](create-example.md) | [app]<br>fun [createExample](create-example.md)(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), status: [GoalModel.Status](../-status/index.md), priority: [GoalModel.Priority](../-priority/index.md), createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [GoalModel](../index.md) |
| [createFromEntity](create-from-entity.md) | [app]<br>fun [createFromEntity](create-from-entity.md)(entity: [GoalEntity](../../../com.habithatch.demo.data.entities/-goal-entity/index.md), status: [GoalModel.Status](../-status/index.md), priority: [GoalModel.Priority](../-priority/index.md)): [GoalModel](../index.md) |