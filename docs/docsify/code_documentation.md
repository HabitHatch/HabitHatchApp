# Code Documentation

## Core


### HabitHatchApp


<span class="kotlin-kw">class</span> <span class="kotlin-name">HabitHatchApp</span> : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)

#### Constructors

| | |
|---|---|
| HabitHatchApp | constructor() |


### ImmediatelyFinishingActivity


<span class="kotlin-kw">class</span> <span class="kotlin-name">ImmediatelyFinishingActivity</span> : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)

An activity that immediately finishes itself when created. This is used for having an Activity change without any visual change.

#### Constructors

| | |
|---|---|
| ImmediatelyFinishingActivity | constructor() |


### MainActivity


<span class="kotlin-kw">class</span> <span class="kotlin-name">MainActivity</span> : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)

The main activity of the app. This activity is responsible for setting up the app's theme and navigation.

#### Constructors

| | |
|---|---|
| MainActivity | constructor() |

#### Properties

| Name | Summary |
|---|---|
| config | <span class="decorator">@Inject</span> <br>lateinit <span class="kotlin-kw">var</span> <span class="kotlin-name">config</span>: HabitHatchConfig |
| typographyFactory | <span class="decorator">@Inject</span> <br>lateinit <span class="kotlin-kw">var</span> <span class="kotlin-name">typographyFactory</span>: TypographyFactory |


### AssistantClient


<span class="kotlin-kw">class</span> <span class="kotlin-name">AssistantClient</span>

#### Constructors

| | |
|---|---|
| AssistantClient | constructor() |


### AppBindingModule


<span class="decorator">@Module</span> 

abstract <span class="kotlin-kw">class</span> <span class="kotlin-name">AppBindingModule</span>

Configures Hilt DI bindings for the app.

#### Constructors

| | |
|---|---|
| AppBindingModule | constructor() |

#### Functions

| Name | Summary |
|---|---|
| bindConfig | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">bindConfig</span>(devConfig: HabitHatchDevConfig): HabitHatchConfig |
| bindPrioritiesProvider | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">bindPrioritiesProvider</span>(devConfig: HabitHatchDevConfig): GoalPriorityProvider |
| bindStatusProvider | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">bindStatusProvider</span>(devConfig: HabitHatchDevConfig): GoalStatusProvider |


### AppModule


<span class="decorator">@Module</span> 

<span class="kotlin-kw">class</span> <span class="kotlin-name">AppModule</span>

Configures Hilt DI providers for the app.

#### Constructors

| | |
|---|---|
| AppModule | constructor() |

#### Functions

| Name | Summary |
|---|---|
| provideDatabase | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br><span class="kotlin-kw">fun</span> <span class="kotlin-name">provideDatabase</span>(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): AppDatabase |
| provideGoalDao | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br><span class="kotlin-kw">fun</span> <span class="kotlin-name">provideGoalDao</span>(database: AppDatabase): GoalDao |
| provideGoogleFontProvider | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br><span class="kotlin-kw">fun</span> <span class="kotlin-name">provideGoogleFontProvider</span>(): [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html) |
| provideUserDao | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br><span class="kotlin-kw">fun</span> <span class="kotlin-name">provideUserDao</span>(database: AppDatabase): UserDao |


### GoalPriorityProvider

<span class="kotlin-kw">interface</span> <span class="kotlin-name">GoalPriorityProvider</span>

Provides the priorities for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

#### Properties

| Name | Summary |
|---|---|
| defaultPriority | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">defaultPriority</span>: GoalModel.Priority |
| priorities | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">priorities</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |

#### Functions

| Name | Summary |
|---|---|
| getPriorityByLabel | open <span class="kotlin-kw">fun</span> <span class="kotlin-name">getPriorityByLabel</span>(priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): GoalModel.Priority |


### GoalStatusProvider

<span class="kotlin-kw">interface</span> <span class="kotlin-name">GoalStatusProvider</span>

Provides the statuses for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

#### Properties

| Name | Summary |
|---|---|
| defaultStatus | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">defaultStatus</span>: GoalModel.Status |
| statuses | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">statuses</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Status&gt; |

#### Functions

| Name | Summary |
|---|---|
| getStatusByLabel | open <span class="kotlin-kw">fun</span> <span class="kotlin-name">getStatusByLabel</span>(statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): GoalModel.Status |


### HabitHatchConfig

<span class="kotlin-kw">interface</span> <span class="kotlin-name">HabitHatchConfig</span> : GoalStatusProvider, GoalPriorityProvider

The main application configuration.

#### Inheritors

| |
|---|
| HabitHatchDevConfig |

#### Properties

| Name | Summary |
|---|---|
| aiNavItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">aiNavItem</span>: Screen |
| bodyFontFamily | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">bodyFontFamily</span>: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| defaultGoalQuery | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">defaultGoalQuery</span>: GoalQuery |
| displayFontFamily | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">displayFontFamily</span>: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| exampleGoals | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">exampleGoals</span>: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| homeNavigationItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">homeNavigationItem</span>: Screen |
| navigationItems | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">navigationItems</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt; |
| pets | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">pets</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| settingsNavigationItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">settingsNavigationItem</span>: Screen |
| signUpNavigationItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">signUpNavigationItem</span>: Screen |
| topLeftNavItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">topLeftNavItem</span>: Screen |
| topRightNavItem | abstract <span class="kotlin-kw">val</span> <span class="kotlin-name">topRightNavItem</span>: Screen |


### HabitHatchDevConfig


<span class="kotlin-kw">class</span> <span class="kotlin-name">HabitHatchDevConfig</span><span class="decorator">@Inject</span> <br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: GoalModel.Factory) : HabitHatchConfig

The main application configuration for the development environment.

#### Constructors

| | |
|---|---|
| HabitHatchDevConfig | <span class="decorator">@Inject</span> <br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: GoalModel.Factory) |

#### Properties

| Name | Summary |
|---|---|
| aiNavItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">aiNavItem</span>: Screen |
| bodyFontFamily | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">bodyFontFamily</span>: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| defaultGoalQuery | open override <span class="kotlin-kw">var</span> <span class="kotlin-name">defaultGoalQuery</span>: GoalQuery |
| defaultPriority | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">defaultPriority</span>: GoalModel.Priority |
| defaultStatus | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">defaultStatus</span>: GoalModel.Status |
| displayFontFamily | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">displayFontFamily</span>: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| exampleGoals | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">exampleGoals</span>: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| homeNavigationItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">homeNavigationItem</span>: Screen |
| navigationItems | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">navigationItems</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt; |
| numberExampleGoals | <span class="kotlin-kw">val</span> <span class="kotlin-name">numberExampleGoals</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 12 |
| pets | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">pets</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| priorities | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">priorities</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |
| settingsNavigationItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">settingsNavigationItem</span>: Screen |
| signUpNavigationItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">signUpNavigationItem</span>: Screen |
| statuses | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">statuses</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Status&gt; |
| topLeftNavItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">topLeftNavItem</span>: Screen |
| topRightNavItem | open override <span class="kotlin-kw">val</span> <span class="kotlin-name">topRightNavItem</span>: Screen |


### InvalidUUIdException


<span class="kotlin-kw">class</span> <span class="kotlin-name">InvalidUUIdException</span>(uuid: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), causedBy: [Exception](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-exception/index.html)) : [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html)

Exception thrown when a UUID is invalid.

#### Constructors

| | |
|---|---|
| InvalidUUIdException | constructor(uuid: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), causedBy: [Exception](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-exception/index.html)) |


### UserExistsException


<span class="kotlin-kw">class</span> <span class="kotlin-name">UserExistsException</span>(user: User) : [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html)

Exception thrown when a user already exists in the database. Only one user is allowed in the local database.

#### Constructors

| | |
|---|---|
| UserExistsException | constructor(user: User) |


### Screen


data <span class="kotlin-kw">class</span> <span class="kotlin-name">Screen</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">route</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">iconResourceId</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">enabled</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true)

#### Constructors

| | |
|---|---|
| Screen | constructor(route: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true) |

#### Properties

| Name | Summary |
|---|---|
| enabled | <span class="kotlin-kw">val</span> <span class="kotlin-name">enabled</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true |
| iconResourceId | <span class="kotlin-kw">val</span> <span class="kotlin-name">iconResourceId</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| route | <span class="kotlin-kw">val</span> <span class="kotlin-name">route</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| title | <span class="kotlin-kw">val</span> <span class="kotlin-name">title</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |


### Companion


object Companion

#### Functions

| Name | Summary |
|---|---|
| createFromFilter | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createFromFilter</span>(goalFilter: GoalFilter, priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider): GoalFilter.Builder<br>Creates a GoalFilter.Builder from a GoalFilter. |
| matchAllBuilder | <span class="kotlin-kw">fun</span> <span class="kotlin-name">matchAllBuilder</span>(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider): GoalFilter.Builder<br>Creates a GoalFilter.Builder that matches all goals. |


### GoalFilterBuilderFactory


<span class="kotlin-kw">class</span> <span class="kotlin-name">GoalFilterBuilderFactory</span><span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider)

#### Constructors

| | |
|---|---|
| GoalFilterBuilderFactory | <span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider) |

#### Properties

| Name | Summary |
|---|---|
| matchAllBuilder | <span class="kotlin-kw">val</span> <span class="kotlin-name">matchAllBuilder</span>: GoalFilter.Builder |


### Factory


<span class="kotlin-kw">class</span> <span class="kotlin-name">Factory</span><span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider)

#### Constructors

| | |
|---|---|
| Factory | <span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider) |

#### Functions

| Name | Summary |
|---|---|
| createFilterQuery | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createFilterQuery</span>(filter: GoalFilter): GoalQuery |
| createGoalQuery | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createGoalQuery</span>(filter: GoalFilter, sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt; = compareBy { 0 }): GoalQuery |


### GoalSortOption

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">GoalSortOption</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">label</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt;, <span class="kotlin-kw">val</span> <span class="kotlin-name">sortState</span>: SortState = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;GoalSortOption&gt; 

Represents a sort option for goals.

##### Parameters


| | |
|---|---|
| label | The label of the sort option. |
| _comparator | The comparator for the sort option. |
| sortState | The current state of the sort option. |
| uiIndex | changes the position of the sort option in the UI. |

#### Constructors

| | |
|---|---|
| GoalSortOption | constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt;, sortState: SortState = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |

#### Properties

| Name | Summary |
|---|---|
| comparator | <span class="kotlin-kw">val</span> <span class="kotlin-name">comparator</span>: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt; |
| label | <span class="kotlin-kw">val</span> <span class="kotlin-name">label</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| sortState | <span class="kotlin-kw">val</span> <span class="kotlin-name">sortState</span>: SortState |

#### Functions

| Name | Summary |
|---|---|
| compareTo | open operator override <span class="kotlin-kw">fun</span> <span class="kotlin-name">compareTo</span>(other: GoalSortOption): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| cycleState | <span class="kotlin-kw">fun</span> <span class="kotlin-name">cycleState</span>(): GoalSortOption<br>Returns a copy of this sort option with the sort state cycled. |
| equals | open operator override <span class="kotlin-kw">fun</span> <span class="kotlin-name">equals</span>(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| hashCode | open override <span class="kotlin-kw">fun</span> <span class="kotlin-name">hashCode</span>(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| isUsed | <span class="kotlin-kw">fun</span> <span class="kotlin-name">isUsed</span>(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| toString | open override <span class="kotlin-kw">fun</span> <span class="kotlin-name">toString</span>(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |


### PriorityVisibility


typealias PriorityVisibility = [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;GoalModel.Priority, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;


### ASCENDING


ASCENDING


### DESCENDING


DESCENDING


### NOT_USED


NOT_USED


### StatusVisibility


typealias StatusVisibility = [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;GoalModel.Status, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;


### Companion


object Companion


### SchemeColor


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">SchemeColor</span>(lightColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), darkColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html))

A color scheme that provides a light and dark color.

#### Constructors

| | |
|---|---|
| SchemeColor | constructor(lightColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), darkColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |

#### Properties

| Name | Summary |
|---|---|
| color | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">val</span> <span class="kotlin-name">color</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |


### TypographyFactory


<span class="kotlin-kw">class</span> <span class="kotlin-name">TypographyFactory</span><span class="decorator">@Inject</span> <br>constructor(config: HabitHatchConfig)

#### Constructors

| | |
|---|---|
| TypographyFactory | <span class="decorator">@Inject</span> <br>constructor(config: HabitHatchConfig) |

#### Functions

| Name | Summary |
|---|---|
| create | <span class="kotlin-kw">fun</span> <span class="kotlin-name">create</span>(): [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) |


util

#### Functions

| Name | Summary |
|---|---|
| createRandomDate | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createRandomDate</span>(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)<br>Returns a new random [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), that is at most pastYears years in the past. |
| darken | <span class="kotlin-kw fun">fun</span> [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html).darken(factor: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)<br>Darkens the **color** by the given factor. |
| disableAll | <span class="kotlin-kw fun">fun</span> [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.disableAll(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| getAlphaFactor | <span class="kotlin-kw">fun</span> <span class="kotlin-name">GoalModel</span>.Priority.getAlphaFactor(): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)<br>Returns the alpha factor for the priority. Used to give more weight to high importance goals. |
| getNextHigherOrLowest | <span class="kotlin-kw fun">fun</span> &lt;T, R : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;R&gt;&gt; [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;T&gt;.getNextHigherOrLowest(bySelector: (T) -&gt; R, element: T): T |
| getUsed | <span class="kotlin-kw fun">fun</span> [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.getUsed(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| lighten | <span class="kotlin-kw fun">fun</span> [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html).lighten(factor: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)<br>Lightens the **color** by the given factor. |
| minusYears | <span class="kotlin-kw fun">fun</span> [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html).minusYears(years: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)<br>Returns a new [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) that is years years after this instant. |
| removeByLabel | <span class="kotlin-kw fun">fun</span> [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.removeByLabel(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| withFontFamily | <span class="kotlin-kw fun">fun</span> [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html).withFontFamily(displayFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html), bodyFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html)): [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html)<br>Returns a new [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) with the specified font families. |

---

## Data


### GoalDao


<span class="kotlin-kw">interface</span> <span class="kotlin-name">GoalDao</span>

The Data Access Object for the GoalEntity class.

#### Functions

| Name | Summary |
|---|---|
| deleteAll | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">deleteAll</span>() |
| getAll | abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">getAll</span>(): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalEntity&gt;&gt; |
| getGoalById | abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">getGoalById</span>(goalId: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): Flow&lt;GoalEntity?&gt; |
| insert | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">insert</span>(goal: GoalEntity) |
| insertAll | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">insertAll</span>(goals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalEntity&gt;) |
| update | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">update</span>(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |


### UserDao


<span class="kotlin-kw">interface</span> <span class="kotlin-name">UserDao</span>

The Data Access Object for the User class.

#### Functions

| Name | Summary |
|---|---|
| deleteAll | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">deleteAll</span>() |
| getUser | abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">getUser</span>(): Flow&lt;User?&gt; |
| insert | abstract suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">insert</span>(user: User) |


### AppDatabase


abstract <span class="kotlin-kw">class</span> <span class="kotlin-name">AppDatabase</span> : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

The Room database for this app.

#### Constructors

| | |
|---|---|
| AppDatabase | constructor() |

#### Functions

| Name | Summary |
|---|---|
| goalDao | abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">goalDao</span>(): GoalDao |
| userDao | abstract <span class="kotlin-kw">fun</span> <span class="kotlin-name">userDao</span>(): UserDao |


### Converters


<span class="kotlin-kw">class</span> <span class="kotlin-name">Converters</span>

Converters is a <span class="kotlin-kw">class</span> <span class="kotlin-name">that</span> provides type converters for Room. Converts between UUID and String and Instant and String.

#### Constructors

| | |
|---|---|
| Converters | constructor() |

#### Functions

| Name | Summary |
|---|---|
| fromInstant | <span class="kotlin-kw">fun</span> <span class="kotlin-name">fromInstant</span>(instant: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| fromUUID | <span class="kotlin-kw">fun</span> <span class="kotlin-name">fromUUID</span>(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| toInstant | <span class="kotlin-kw">fun</span> <span class="kotlin-name">toInstant</span>(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| toUUID | <span class="kotlin-kw">fun</span> <span class="kotlin-name">toUUID</span>(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |


### DatabaseProvider


object DatabaseProvider

#### Functions

| Name | Summary |
|---|---|
| getDatabase | <span class="kotlin-kw">fun</span> <span class="kotlin-name">getDatabase</span>(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): AppDatabase |


### GoalEntity


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">GoalEntity</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">id</span>: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">title</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">userId</span>: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">statusLabel</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">priorityLabel</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">createdAt</span>: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html))

GoalEntity is a Room entity that represents a goal.

#### Constructors

| | |
|---|---|
| GoalEntity | constructor(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)) |

#### Properties

| Name | Summary |
|---|---|
| createdAt | <span class="kotlin-kw">val</span> <span class="kotlin-name">createdAt</span>: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| id | <span class="kotlin-kw">val</span> <span class="kotlin-name">id</span>: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) |
| priorityLabel | <span class="kotlin-kw">val</span> <span class="kotlin-name">priorityLabel</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| statusLabel | <span class="kotlin-kw">val</span> <span class="kotlin-name">statusLabel</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| title | <span class="kotlin-kw">val</span> <span class="kotlin-name">title</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| userId | <span class="kotlin-kw">val</span> <span class="kotlin-name">userId</span>: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |


### Pet


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">Pet</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">name</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">imageRes</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))

Pet represents a pet

#### Constructors

| | |
|---|---|
| Pet | constructor(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |

#### Properties

| Name | Summary |
|---|---|
| imageRes | <span class="kotlin-kw">val</span> <span class="kotlin-name">imageRes</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| name | <span class="kotlin-kw">val</span> <span class="kotlin-name">name</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |


### User

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">User</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">uuid</span>: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), <span class="kotlin-kw">val</span> <span class="kotlin-name">pet</span>: Pet)

User represents a user.

##### Parameters


| | |
|---|---|
| uuid | the UUID of the user, for global identification |
| pet | the pet of the user |

#### Constructors

| | |
|---|---|
| User | constructor(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), pet: Pet) |

#### Properties

| Name | Summary |
|---|---|
| pet | <span class="kotlin-kw">val</span> <span class="kotlin-name">pet</span>: Pet |
| uuid | <span class="kotlin-kw">val</span> <span class="kotlin-name">uuid</span>: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |


### GoalMapper


<span class="kotlin-kw">class</span> <span class="kotlin-name">GoalMapper</span><span class="decorator">@Inject</span> <br>constructor(statusProvider: GoalStatusProvider, priorityProvider: GoalPriorityProvider, goalModelFactory: GoalModel.Factory)

GoalMapper is a mapper that maps GoalModel to GoalEntity and vice versa. GoalEntity is a RoomEntity, used for storing goals in the database. GoalModel is a model used for creating and displaying goals.

#### Constructors

| | |
|---|---|
| GoalMapper | <span class="decorator">@Inject</span> <br>constructor(statusProvider: GoalStatusProvider, priorityProvider: GoalPriorityProvider, goalModelFactory: GoalModel.Factory) |

#### Functions

| Name | Summary |
|---|---|
| asEntity | <span class="kotlin-kw">fun</span> <span class="kotlin-name">asEntity</span>(goal: GoalModel, userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): GoalEntity<br>Maps a GoalModel to a GoalEntity. Every Goal in the Database needs to have a createdAt date. If the goal is a draft, the createdAt date is set to the current date. |
| asModel | <span class="kotlin-kw">fun</span> <span class="kotlin-name">asModel</span>(entity: GoalEntity): GoalModel |


### ExampleGoalFactory


<span class="kotlin-kw">class</span> <span class="kotlin-name">ExampleGoalFactory</span>(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider, goalModelFactory: GoalModel.Factory)

ExampleGoalFactory is a factory that creates example goals for testing purposes.

#### Constructors

| | |
|---|---|
| ExampleGoalFactory | constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider, goalModelFactory: GoalModel.Factory) |

#### Functions

| Name | Summary |
|---|---|
| createExampleGoal | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createExampleGoal</span>(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1): GoalModel |
| createExampleGoals | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createExampleGoals</span>(count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1, uniqueTitles: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| randomPriority | <span class="kotlin-kw">fun</span> <span class="kotlin-name">randomPriority</span>(): GoalModel.Priority |
| randomStatus | <span class="kotlin-kw">fun</span> <span class="kotlin-name">randomStatus</span>(): GoalModel.Status |


### Factory


<span class="kotlin-kw">class</span> <span class="kotlin-name">Factory</span><span class="decorator">@Inject</span> <br>constructor

#### Constructors

| | |
|---|---|
| Factory | <span class="decorator">@Inject</span> <br>constructor() |

#### Functions

| Name | Summary |
|---|---|
| createDraft | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createDraft</span>(status: GoalModel.Status, priority: GoalModel.Priority): GoalModel<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">createDraft</span>(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, status: GoalModel.Status, priority: GoalModel.Priority): GoalModel |
| createExample | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createExample</span>(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), status: GoalModel.Status, priority: GoalModel.Priority, createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): GoalModel |
| createFromEntity | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createFromEntity</span>(entity: GoalEntity, status: GoalModel.Status, priority: GoalModel.Priority): GoalModel |


### High


object High : GoalModel.Priority.Importance


### Low


object Low : GoalModel.Priority.Importance


### Normal


object Normal : GoalModel.Priority.Importance


### VeryHigh


object VeryHigh : GoalModel.Priority.Importance


### VeryLow


object VeryLow : GoalModel.Priority.Importance


### Status


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">Status</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">label</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">stepNumber</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">isDone</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false)

#### Constructors

| | |
|---|---|
| Status | constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), stepNumber: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), isDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false) |

#### Properties

| Name | Summary |
|---|---|
| isDone | <span class="kotlin-kw">val</span> <span class="kotlin-name">isDone</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| label | <span class="kotlin-kw">val</span> <span class="kotlin-name">label</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| stepNumber | <span class="kotlin-kw">val</span> <span class="kotlin-name">stepNumber</span>: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

#### Functions

| Name | Summary |
|---|---|
| equals | open operator override <span class="kotlin-kw">fun</span> <span class="kotlin-name">equals</span>(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| hashCode | open override <span class="kotlin-kw">fun</span> <span class="kotlin-name">hashCode</span>(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |


### GoalRepository


<span class="kotlin-kw">class</span> <span class="kotlin-name">GoalRepository</span><span class="decorator">@Inject</span> <br>constructor(goalDao: GoalDao, goalMapper: GoalMapper, userRepository: UserRepository)

GoalRepository is a repository that provides access to goals in the database.

#### Constructors

| | |
|---|---|
| GoalRepository | <span class="decorator">@Inject</span> <br>constructor(goalDao: GoalDao, goalMapper: GoalMapper, userRepository: UserRepository) |

#### Functions

| Name | Summary |
|---|---|
| deleteAll | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">deleteAll</span>()<br>Deletes all goals permanently from the database. |
| getQueriedGoals | <span class="kotlin-kw">fun</span> <span class="kotlin-name">getQueriedGoals</span>(query: GoalQuery): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;&gt;<br>Returns a flow of goals that match the given GoalQuery. Sorted by GoalQuery's comparator. |
| insert | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">insert</span>(vararg goals: GoalModel)<br>Inserts the given goals into the database. |
| update | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">update</span>(goal: GoalModel)<br>Updates the given goal in the database. |


### UserRepository


<span class="kotlin-kw">class</span> <span class="kotlin-name">UserRepository</span><span class="decorator">@Inject</span> <br>constructor(userDao: UserDao)

UserRepository is a repository that provides access to the user in the database. Since there is only one user, the repository provides methods to create, read, update and delete the user.

#### Constructors

| | |
|---|---|
| UserRepository | <span class="decorator">@Inject</span> <br>constructor(userDao: UserDao) |

#### Functions

| Name | Summary |
|---|---|
| createUser | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">createUser</span>(user: User) |
| deleteUser | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">deleteUser</span>() |
| getUser | <span class="kotlin-kw">fun</span> <span class="kotlin-name">getUser</span>(): Flow&lt;User?&gt; |
| hasUser | suspend <span class="kotlin-kw">fun</span> <span class="kotlin-name">hasUser</span>(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |

---

## Features


### AIAssistantViewModel


<span class="kotlin-kw">class</span> <span class="kotlin-name">AIAssistantViewModel</span><span class="decorator">@Inject</span> <br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

#### Constructors

| | |
|---|---|
| AIAssistantViewModel | <span class="decorator">@Inject</span> <br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) |

#### Properties

| Name | Summary |
|---|---|
| isListening | <span class="kotlin-kw">val</span> <span class="kotlin-name">isListening</span>: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| showPermissionDialog | <span class="kotlin-kw">val</span> <span class="kotlin-name">showPermissionDialog</span>: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| text | <span class="kotlin-kw">val</span> <span class="kotlin-name">text</span>: StateFlow&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; |

#### Functions

| Name | Summary |
|---|---|
| startListening | <span class="kotlin-kw">fun</span> <span class="kotlin-name">startListening</span>() |


### AIScreenState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-kw">class</span> <span class="kotlin-name">AIScreenState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">text</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">isListening</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">showPermissionDialog</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">onStartListening</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the AI screen.

##### Parameters


| | |
|---|---|
| text | The text to display on the screen. |
| isListening | Whether the AI assistant is currently listening. |
| showPermissionDialog | Whether to show the permission dialog. |
| onStartListening | The callback to start listening. |

#### Constructors

| | |
|---|---|
| AIScreenState | constructor(text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

#### Properties

| Name | Summary |
|---|---|
| isListening | <span class="kotlin-kw">val</span> <span class="kotlin-name">isListening</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onStartListening | <span class="kotlin-kw">val</span> <span class="kotlin-name">onStartListening</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showPermissionDialog | <span class="kotlin-kw">val</span> <span class="kotlin-name">showPermissionDialog</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| text | <span class="kotlin-kw">val</span> <span class="kotlin-name">text</span>: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |


### CoreHomeState


data <span class="kotlin-kw">class</span> <span class="kotlin-name">CoreHomeState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">pet</span>: Pet?, <span class="kotlin-kw">val</span> <span class="kotlin-name">isUserLoggedIn</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, <span class="kotlin-kw">val</span> <span class="kotlin-name">allGoalsDone</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, <span class="kotlin-kw">val</span> <span class="kotlin-name">onAddGoalClicked</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Represents the main state information for the home screen.

#### Constructors

| | |
|---|---|
| CoreHomeState | constructor(pet: Pet?, isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

#### Properties

| Name | Summary |
|---|---|
| allGoalsDone | <span class="kotlin-kw">val</span> <span class="kotlin-name">allGoalsDone</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| isUserLoggedIn | <span class="kotlin-kw">val</span> <span class="kotlin-name">isUserLoggedIn</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| onAddGoalClicked | <span class="kotlin-kw">val</span> <span class="kotlin-name">onAddGoalClicked</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| pet | <span class="kotlin-kw">val</span> <span class="kotlin-name">pet</span>: Pet? |


### HomeScreenState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-kw">class</span> <span class="kotlin-name">HomeScreenState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">addGoalDialogState</span>: AddGoalDialogState, <span class="kotlin-kw">val</span> <span class="kotlin-name">goalsViewState</span>: GoalsViewState, <span class="kotlin-kw">val</span> <span class="kotlin-name">goalFilterState</span>: GoalFilterState, <span class="kotlin-kw">val</span> <span class="kotlin-name">goalSortState</span>: GoalSortState, <span class="kotlin-kw">val</span> <span class="kotlin-name">core</span>: CoreHomeState)

Represents the state of the home screen.

##### Parameters


| | |
|---|---|
| addGoalDialogState | The state of the add goal dialog. |
| goalsViewState | The state of the goals view. |
| goalFilterState | The state of the goal filter. |
| goalSortState | The state of the goal sort. |
| core | The core state of the home screen. |

#### Constructors

| | |
|---|---|
| HomeScreenState | constructor(addGoalDialogState: AddGoalDialogState, goalsViewState: GoalsViewState, goalFilterState: GoalFilterState, goalSortState: GoalSortState, core: CoreHomeState) |

#### Properties

| Name | Summary |
|---|---|
| addGoalDialogState | <span class="kotlin-kw">val</span> <span class="kotlin-name">addGoalDialogState</span>: AddGoalDialogState |
| core | <span class="kotlin-kw">val</span> <span class="kotlin-name">core</span>: CoreHomeState |
| goalFilterState | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalFilterState</span>: GoalFilterState |
| goalSortState | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalSortState</span>: GoalSortState |
| goalsViewState | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalsViewState</span>: GoalsViewState |


### HomeViewModel


<span class="kotlin-kw">class</span> <span class="kotlin-name">HomeViewModel</span><span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository, <span class="kotlin-kw">val</span> <span class="kotlin-name">config</span>: HabitHatchConfig, <span class="kotlin-kw">val</span> <span class="kotlin-name">goalQueryFactory</span>: GoalQuery.Factory, <span class="kotlin-kw">val</span> <span class="kotlin-name">builderFactory</span>: GoalFilterBuilderFactory) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

#### Constructors

| | |
|---|---|
| HomeViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository, config: HabitHatchConfig, goalQueryFactory: GoalQuery.Factory, builderFactory: GoalFilterBuilderFactory) |

#### Properties

| Name | Summary |
|---|---|
| allGoalsDone | <span class="kotlin-kw">val</span> <span class="kotlin-name">allGoalsDone</span>: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| builderFactory | <span class="kotlin-kw">val</span> <span class="kotlin-name">builderFactory</span>: GoalFilterBuilderFactory |
| config | <span class="kotlin-kw">val</span> <span class="kotlin-name">config</span>: HabitHatchConfig |
| goalQuery | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalQuery</span>: StateFlow&lt;GoalQuery&gt; |
| goalQueryFactory | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalQueryFactory</span>: GoalQuery.Factory |
| hasAnyGoals | <span class="kotlin-kw">val</span> <span class="kotlin-name">hasAnyGoals</span>: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| queriedGoals | <span class="kotlin-kw">val</span> <span class="kotlin-name">queriedGoals</span>: StateFlow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;&gt; |
| user | <span class="kotlin-kw">val</span> <span class="kotlin-name">user</span>: StateFlow&lt;User?&gt; |

#### Functions

| Name | Summary |
|---|---|
| addGoal | <span class="kotlin-kw">fun</span> <span class="kotlin-name">addGoal</span>(goal: GoalModel) |
| seedGoals | <span class="kotlin-kw">fun</span> <span class="kotlin-name">seedGoals</span>() |
| toggleGoalStatus | <span class="kotlin-kw">fun</span> <span class="kotlin-name">toggleGoalStatus</span>(goal: GoalModel) |
| updateGoalFilter | <span class="kotlin-kw">fun</span> <span class="kotlin-name">updateGoalFilter</span>(newGoalFilter: GoalFilter) |
| updateGoalSortOption | <span class="kotlin-kw">fun</span> <span class="kotlin-name">updateGoalSortOption</span>(newGoalSortOption: GoalSortOption) |


### SettingsScreenState

data <span class="kotlin-kw">class</span> <span class="kotlin-name">SettingsScreenState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">onDeleteAccount</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the settings screen.

##### Parameters


| | |
|---|---|
| onDeleteAccount | The callback to delete the user account. |

#### Constructors

| | |
|---|---|
| SettingsScreenState | constructor(onDeleteAccount: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

#### Properties

| Name | Summary |
|---|---|
| onDeleteAccount | <span class="kotlin-kw">val</span> <span class="kotlin-name">onDeleteAccount</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |


### SettingsViewModel


<span class="kotlin-kw">class</span> <span class="kotlin-name">SettingsViewModel</span><span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

SettingsViewModel is a ViewModel that provides the settings screen with the necessary data.

#### Constructors

| | |
|---|---|
| SettingsViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository) |

#### Functions

| Name | Summary |
|---|---|
| deleteAccount | <span class="kotlin-kw">fun</span> <span class="kotlin-name">deleteAccount</span>() |


### LOADING


LOADING


### NOT_SIGNED_UP


NOT_SIGNED_UP


### SIGNED_UP


SIGNED_UP


### SignupScreenState


data <span class="kotlin-kw">class</span> <span class="kotlin-name">SignupScreenState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">pets</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt;, <span class="kotlin-kw">val</span> <span class="kotlin-name">signUpState</span>: SignUpState, <span class="kotlin-kw">val</span> <span class="kotlin-name">onPetConfirmed</span>: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the signup screen.

#### Constructors

| | |
|---|---|
| SignupScreenState | constructor(pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt;, signUpState: SignUpState, onPetConfirmed: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

#### Properties

| Name | Summary |
|---|---|
| onPetConfirmed | <span class="kotlin-kw">val</span> <span class="kotlin-name">onPetConfirmed</span>: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| pets | <span class="kotlin-kw">val</span> <span class="kotlin-name">pets</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| signUpState | <span class="kotlin-kw">val</span> <span class="kotlin-name">signUpState</span>: SignUpState |


### SignupViewModel


<span class="kotlin-kw">class</span> <span class="kotlin-name">SignupViewModel</span><span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, habitHatchConfig: HabitHatchConfig) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

#### Constructors

| | |
|---|---|
| SignupViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, habitHatchConfig: HabitHatchConfig) |

#### Properties

| Name | Summary |
|---|---|
| pets | <span class="kotlin-kw">val</span> <span class="kotlin-name">pets</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| signUpState | <span class="kotlin-kw">val</span> <span class="kotlin-name">signUpState</span>: StateFlow&lt;SignUpState&gt; |

#### Functions

| Name | Summary |
|---|---|
| signUpUser | <span class="kotlin-kw">fun</span> <span class="kotlin-name">signUpUser</span>(user: User) |

---

## Ui


common

#### Functions

| Name | Summary |
|---|---|
| ImageBox | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">ImageBox</span>(imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, isChecked: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))<br>A box with an image and a checkmark indicator. |
| ImageTextCard | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">ImageTextCard</span>(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, imageContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), text: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 8.dp, onSelected: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A card with an image and text. |
| SelectionGrid | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw fun">fun</span> &lt;T&gt; SelectionGrid(elements: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;T&gt;, columns: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 2, outSidePadding: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 50.dp, spaceBetween: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 30.dp, onConfirm: (T) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), card: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(T, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A grid of elements that can be selected. |


### DialogHost


<span class="kotlin-kw">class</span> <span class="kotlin-name">DialogHost</span>

A host for dialogs.

#### Constructors

| | |
|---|---|
| DialogHost | constructor() |

#### Functions

| Name | Summary |
|---|---|
| createConfirmDialog | <span class="kotlin-kw">fun</span> <span class="kotlin-name">createConfirmDialog</span>(titleRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), messageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), confirmButtonRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), dismissButtonRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), onConfirm: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Creates a confirm dialog. |
| Render | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">Render</span>()<br>Renders the dialog. |


forms

#### Functions

| Name | Summary |
|---|---|
| SearchField | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">SearchField</span>(searchQuery: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onQueryChange: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, shape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) = MaterialTheme.shapes.large, textStyle: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = MaterialTheme.typography.bodySmall)<br>A search field that allows the user to input a search query. |
| SearchFieldPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">SearchFieldPreview</span>() |
| SimpleIconButton | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">SimpleIconButton</span>(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier.size(36.dp), labelRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), color: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), painter: [Painter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/painter/Painter.html), onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A simple icon button with a label. |


### AddGoalDialogState


data <span class="kotlin-kw">class</span> <span class="kotlin-name">AddGoalDialogState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">showDialog</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, <span class="kotlin-kw">val</span> <span class="kotlin-name">goal</span>: GoalModel, <span class="kotlin-kw">val</span> <span class="kotlin-name">allPriorities</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt;, <span class="kotlin-kw">val</span> <span class="kotlin-name">onAddGoal</span>: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, <span class="kotlin-kw">val</span> <span class="kotlin-name">onDismiss</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

#### Constructors

| | |
|---|---|
| AddGoalDialogState | constructor(showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, goal: GoalModel, allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt;, onAddGoal: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

#### Properties

| Name | Summary |
|---|---|
| allPriorities | <span class="kotlin-kw">val</span> <span class="kotlin-name">allPriorities</span>: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |
| goal | <span class="kotlin-kw">val</span> <span class="kotlin-name">goal</span>: GoalModel |
| onAddGoal | <span class="kotlin-kw">val</span> <span class="kotlin-name">onAddGoal</span>: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| onDismiss | <span class="kotlin-kw">val</span> <span class="kotlin-name">onDismiss</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showDialog | <span class="kotlin-kw">val</span> <span class="kotlin-name">showDialog</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |


### GoalFilterState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-kw">class</span> <span class="kotlin-name">GoalFilterState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">goalFilterBuilder</span>: GoalFilter.Builder, <span class="kotlin-kw">val</span> <span class="kotlin-name">onGoalFilterChange</span>: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goal filter.

##### Parameters


| | |
|---|---|
| goalFilterBuilder | The builder of the goal filter. |
| onGoalFilterChange | The action to be performed when the goal filter changes. |

#### Constructors

| | |
|---|---|
| GoalFilterState | constructor(goalFilterBuilder: GoalFilter.Builder, onGoalFilterChange: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

#### Properties

| Name | Summary |
|---|---|
| goalFilterBuilder | <span class="kotlin-kw">val</span> <span class="kotlin-name">goalFilterBuilder</span>: GoalFilter.Builder |
| onGoalFilterChange | <span class="kotlin-kw">val</span> <span class="kotlin-name">onGoalFilterChange</span>: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |


### GoalSortState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-kw">class</span> <span class="kotlin-name">GoalSortState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">sortOptions</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt;, <span class="kotlin-kw">val</span> <span class="kotlin-name">onSortOptionChange</span>: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { })

The state of the goal sort.

##### Parameters


| | |
|---|---|
| sortOptions | The list of sort options. |
| onSortOptionChange | The action to be performed when the sort option changes. |

#### Constructors

| | |
|---|---|
| GoalSortState | constructor(sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt;, onSortOptionChange: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { }) |

#### Properties

| Name | Summary |
|---|---|
| onSortOptionChange | <span class="kotlin-kw">val</span> <span class="kotlin-name">onSortOptionChange</span>: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| sortOptions | <span class="kotlin-kw">val</span> <span class="kotlin-name">sortOptions</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |


### GoalStyleProvider


object GoalStyleProvider

The provider of the style of a goal.

#### Functions

| Name | Summary |
|---|---|
| getContainerColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">getContainerColor</span>(goal: GoalModel): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| getGoalStyle | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">getGoalStyle</span>(goal: GoalModel): GoalStyle |


### GoalsViewState

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-kw">class</span> <span class="kotlin-name">GoalsViewState</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">goals</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;, <span class="kotlin-kw">val</span> <span class="kotlin-name">showCreateExampleGoals</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, <span class="kotlin-kw">val</span> <span class="kotlin-name">onCreateExampleGoals</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, <span class="kotlin-kw">val</span> <span class="kotlin-name">onToggleGoalStatus</span>: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goals view.

##### Parameters


| | |
|---|---|
| goals | The list of goals. |
| showCreateExampleGoals | Whether to show the create example goals button. |
| onCreateExampleGoals | The action to be performed when the create example goals button is clicked. |
| onToggleGoalStatus | The action to be performed when the goal status is toggled. |

#### Constructors

| | |
|---|---|
| GoalsViewState | constructor(goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;, showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onToggleGoalStatus: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

#### Properties

| Name | Summary |
|---|---|
| goals | <span class="kotlin-kw">val</span> <span class="kotlin-name">goals</span>: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt; |
| onCreateExampleGoals | <span class="kotlin-kw">val</span> <span class="kotlin-name">onCreateExampleGoals</span>: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| onToggleGoalStatus | <span class="kotlin-kw">val</span> <span class="kotlin-name">onToggleGoalStatus</span>: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showCreateExampleGoals | <span class="kotlin-kw">val</span> <span class="kotlin-name">showCreateExampleGoals</span>: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true |


### GoalStyle

data <span class="kotlin-kw">class</span> <span class="kotlin-name">GoalStyle</span>(<span class="kotlin-kw">val</span> <span class="kotlin-name">borderColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">containerColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">textDecoration</span>: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, <span class="kotlin-kw">val</span> <span class="kotlin-name">iconColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), <span class="kotlin-kw">val</span> <span class="kotlin-name">cardShape</span>: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html))

The style of a goal.

##### Parameters


| | |
|---|---|
| borderColor | The color of the border. |
| containerColor | The color of the container. |
| textDecoration | The text decoration. |
| iconColor | The color of the icon. |
| cardShape | The shape of the card. |

#### Constructors

| | |
|---|---|
| GoalStyle | constructor(borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html)) |

#### Properties

| Name | Summary |
|---|---|
| borderColor | <span class="kotlin-kw">val</span> <span class="kotlin-name">borderColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| cardColors | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">val</span> <span class="kotlin-name">cardColors</span>: [CardColors](https://developer.android.com/reference/kotlin/androidx/compose/material3/CardColors.html) |
| cardShape | <span class="kotlin-kw">val</span> <span class="kotlin-name">cardShape</span>: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) |
| containerColor | <span class="kotlin-kw">val</span> <span class="kotlin-name">containerColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| iconColor | <span class="kotlin-kw">val</span> <span class="kotlin-name">iconColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| textColor | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">val</span> <span class="kotlin-name">textColor</span>: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| textDecoration | <span class="kotlin-kw">val</span> <span class="kotlin-name">textDecoration</span>: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) |
| textStyle | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">val</span> <span class="kotlin-name">textStyle</span>: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |


table

#### Functions

| Name | Summary |
|---|---|
| getDoneColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">getDoneColor</span>(isDoneStatusVisible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| GoalFilterBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">GoalFilterBar</span>(state: GoalFilterState, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>A bar that contains a search field and a button to toggle the visibility of done goals. |
| GoalQueryTable | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">GoalQueryTable</span>(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, filterContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(defaultModifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), sortContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(defaultModifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), goalsContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A table that displays a list of goals. With filter and sort options. |
| GoalSortBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">GoalSortBar</span>(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: GoalSortState)<br>A bar that displays sort options for goals. |


navigation

#### Functions

| Name | Summary |
|---|---|
| NavItem | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">NavItem</span>(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier.size(24.dp), navScreen: Screen, iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A navigation item that displays an icon. |
| TopAppInformationBarPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">TopAppInformationBarPreview</span>() |
| TopNavBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">TopNavBar</span>(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), rightNavItem: Screen? = null, leftNavItem: Screen? = null, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onRightNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onLeftNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A top navigation bar that displays the title and navigation items. |


pets

#### Functions

| Name | Summary |
|---|---|
| borderColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">borderColor</span>(isPetHappy: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| PetAnimation | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">PetAnimation</span>(pet: Pet, isPetHappy: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>A pet animation that displays a pet. |


settings

#### Functions

| Name | Summary |
|---|---|
| AccountSettings | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">AccountSettings</span>(onOpenDeleteAccountDialog: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A view that displays account settings. |

---

## [root]


[root]

#### Functions

| Name | Summary |
|---|---|
| BottomNavBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">BottomNavBar</span>(navigationItems: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt;, activeNavScreen: Screen? = null, onNavigationItemClicked: (Screen) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A bottom navigation bar that displays the navigation items. |
| BottomNavigationBarPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br><span class="kotlin-kw">fun</span> <span class="kotlin-name">BottomNavigationBarPreview</span>() |

---
