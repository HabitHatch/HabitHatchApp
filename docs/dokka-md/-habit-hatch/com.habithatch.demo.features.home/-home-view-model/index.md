//[HabitHatch](../../../index.md)/[com.habithatch.demo.features.home](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

[app]\
class [HomeViewModel](index.md)@Injectconstructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), habitRepository: [HabitRepository](../../com.habithatch.demo.data.repositories/-habit-repository/index.md), val config: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md), val habitQueryFactory: [HabitQuery.Factory](../../com.habithatch.demo.core.query/-habit-query/-factory/index.md), val builderFactory: [HabitFilterBuilderFactory](../../com.habithatch.demo.core.query/-habit-filter-builder-factory/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [app]<br>@Inject<br>constructor(userRepository: [UserRepository](../../com.habithatch.demo.data.repositories/-user-repository/index.md), habitRepository: [HabitRepository](../../com.habithatch.demo.data.repositories/-habit-repository/index.md), config: [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md), habitQueryFactory: [HabitQuery.Factory](../../com.habithatch.demo.core.query/-habit-query/-factory/index.md), builderFactory: [HabitFilterBuilderFactory](../../com.habithatch.demo.core.query/-habit-filter-builder-factory/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [allHabitsDone](all-habits-done.md) | [app]<br>val [allHabitsDone](all-habits-done.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [builderFactory](builder-factory.md) | [app]<br>val [builderFactory](builder-factory.md): [HabitFilterBuilderFactory](../../com.habithatch.demo.core.query/-habit-filter-builder-factory/index.md) |
| [config](config.md) | [app]<br>val [config](config.md): [HabitHatchConfig](../../com.habithatch.demo.core.config/-habit-hatch-config/index.md) |
| [habitQuery](habit-query.md) | [app]<br>val [habitQuery](habit-query.md): StateFlow&lt;[HabitQuery](../../com.habithatch.demo.core.query/-habit-query/index.md)&gt; |
| [habitQueryFactory](habit-query-factory.md) | [app]<br>val [habitQueryFactory](habit-query-factory.md): [HabitQuery.Factory](../../com.habithatch.demo.core.query/-habit-query/-factory/index.md) |
| [hasAnyHabits](has-any-habits.md) | [app]<br>val [hasAnyHabits](has-any-habits.md): StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| [queriedHabits](queried-habits.md) | [app]<br>val [queriedHabits](queried-habits.md): StateFlow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)&gt;&gt; |
| [user](user.md) | [app]<br>val [user](user.md): StateFlow&lt;[User](../../com.habithatch.demo.data.entities/-user/index.md)?&gt; |

## Functions

| Name | Summary |
|---|---|
| [addHabit](add-habit.md) | [app]<br>fun [addHabit](add-habit.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) |
| [seedHabits](seed-habits.md) | [app]<br>fun [seedHabits](seed-habits.md)() |
| [toggleHabitStatus](toggle-habit-status.md) | [app]<br>fun [toggleHabitStatus](toggle-habit-status.md)(habit: [HabitModel](../../com.habithatch.demo.data.models/-habit-model/index.md)) |
| [updateHabitFilter](update-habit-filter.md) | [app]<br>fun [updateHabitFilter](update-habit-filter.md)(newHabitFilter: [HabitFilter](../../com.habithatch.demo.core.query/-habit-filter/index.md)) |
| [updateHabitSortOption](update-habit-sort-option.md) | [app]<br>fun [updateHabitSortOption](update-habit-sort-option.md)(newHabitSortOption: [HabitSortOption](../../com.habithatch.demo.core.query/-habit-sort-option/index.md)) |
