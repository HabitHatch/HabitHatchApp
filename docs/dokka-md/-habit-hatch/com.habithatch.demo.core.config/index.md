//[HabitHatch](../../index.md)/[com.habithatch.demo.core.config](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [GoalPriorityProvider](-goal-priority-provider/index.md) | [app]<br>interface [GoalPriorityProvider](-goal-priority-provider/index.md)<br>Provides the priorities for goals. |
| [GoalStatusProvider](-goal-status-provider/index.md) | [app]<br>interface [GoalStatusProvider](-goal-status-provider/index.md)<br>Provides the statuses for goals. |
| [HabitHatchConfig](-habit-hatch-config/index.md) | [app]<br>interface [HabitHatchConfig](-habit-hatch-config/index.md) : [GoalStatusProvider](-goal-status-provider/index.md), [GoalPriorityProvider](-goal-priority-provider/index.md)<br>The main application configuration. |
| [HabitHatchDevConfig](-habit-hatch-dev-config/index.md) | [app]<br>class [HabitHatchDevConfig](-habit-hatch-dev-config/index.md)@Injectconstructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), petMoodAnimationsBuilder: [PetMoodAnimationsFactory](../com.habithatch.demo.data.entities/-pet-mood-animations-factory/index.md)) : [HabitHatchConfig](-habit-hatch-config/index.md)<br>The main application configuration for the development environment. |