//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

[app]\
class [HomeViewModel](index.md)@Injectconstructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), goalRepository: [GoalRepository](../../com.habithatch.demo.data.repositories/-goal-repository/index.md), val config: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md), val goalQueryFactory: [GoalQuery.Factory](../../com.habithatch.demo.core.query/-goal-query/-factory/index.md), val builderFactory: [GoalFilterBuilderFactory](../../com.habithatch.demo.core.query/-goal-filter-builder-factory/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [app]<br>@Inject<br>constructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), goalRepository: [GoalRepository](../../com.habithatch.demo.data.repositories/-goal-repository/index.md), config: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md), goalQueryFactory: [GoalQuery.Factory](../../com.habithatch.demo.core.query/-goal-query/-factory/index.md), builderFactory: [GoalFilterBuilderFactory](../../com.habithatch.demo.core.query/-goal-filter-builder-factory/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [allGoalsDone](all-goals-done.md) | [app]<br>val [allGoalsDone](all-goals-done.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [builderFactory](builder-factory.md) | [app]<br>val [builderFactory](builder-factory.md): [GoalFilterBuilderFactory](../../com.habithatch.demo.core.query/-goal-filter-builder-factory/index.md) |
| [config](config.md) | [app]<br>val [config](config.md): [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md) |
| [goalQuery](goal-query.md) | [app]<br>val [goalQuery](goal-query.md): StateFlow&lt;[GoalQuery](../../com.habithatch.demo.core.query/-goal-query/index.md)&gt; |
| [goalQueryFactory](goal-query-factory.md) | [app]<br>val [goalQueryFactory](goal-query-factory.md): [GoalQuery.Factory](../../com.habithatch.demo.core.query/-goal-query/-factory/index.md) |
| [hasAnyGoals](has-any-goals.md) | [app]<br>val [hasAnyGoals](has-any-goals.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [queriedGoals](queried-goals.md) | [app]<br>val [queriedGoals](queried-goals.md): StateFlow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)&gt;&gt; |
| [user](user.md) | [app]<br>val [user](user.md): StateFlow&lt;[User](../../com.habithatch.demo.data.entities/-user/index.md)?&gt; |

## Functions

| Name | Summary |
|---|---|
| [addGoal](add-goal.md) | [app]<br>fun [addGoal](add-goal.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) |
| [seedGoals](seed-goals.md) | [app]<br>fun [seedGoals](seed-goals.md)() |
| [toggleGoalStatus](toggle-goal-status.md) | [app]<br>fun [toggleGoalStatus](toggle-goal-status.md)(goal: [GoalModel](../../com.habithatch.demo.data.models/-goal-model/index.md)) |
| [updateGoalFilter](update-goal-filter.md) | [app]<br>fun [updateGoalFilter](update-goal-filter.md)(newGoalFilter: [GoalFilter](../../com.habithatch.demo.core.query/-goal-filter/index.md)) |
| [updateGoalSortOption](update-goal-sort-option.md) | [app]<br>fun [updateGoalSortOption](update-goal-sort-option.md)(newGoalSortOption: [GoalSortOption](../../com.habithatch.demo.core.query/-goal-sort-option/index.md)) |