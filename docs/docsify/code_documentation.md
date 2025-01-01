# Code Documentation

---


## HabitHatchApp


<span class="kotlin-class">class</span> HabitHatchApp : [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)

### Constructors

| | |
|---|---|
| HabitHatchApp | constructor() |

---


## ImmediatelyFinishingActivity


<span class="kotlin-class">class</span> ImmediatelyFinishingActivity : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)

An activity that immediately finishes itself when created. This is used for having an Activity change without any visual change.

### Constructors

| | |
|---|---|
| ImmediatelyFinishingActivity | constructor() |

---


## MainActivity


<span class="kotlin-class">class</span> MainActivity : [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html)

The main activity of the app. This activity is responsible for setting up the app's theme and navigation.

### Constructors

| | |
|---|---|
| MainActivity | constructor() |

### Properties

| Name | Summary |
|---|---|
| config | <span class="decorator">@Inject</span> <br>lateinit var config: HabitHatchConfig |
| typographyFactory | <span class="decorator">@Inject</span> <br>lateinit var typographyFactory: TypographyFactory |

---


## AssistantClient


<span class="kotlin-class">class</span> AssistantClient

### Constructors

| | |
|---|---|
| AssistantClient | constructor() |

---


## AppBindingModule


<span class="decorator">@Module</span> 

abstract <span class="kotlin-class">class</span> AppBindingModule

Configures Hilt DI bindings for the app.

### Constructors

| | |
|---|---|
| AppBindingModule | constructor() |

### Functions

| Name | Summary |
|---|---|
| bindConfig | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract fun bindConfig(devConfig: HabitHatchDevConfig): HabitHatchConfig |
| bindPrioritiesProvider | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract fun bindPrioritiesProvider(devConfig: HabitHatchDevConfig): GoalPriorityProvider |
| bindStatusProvider | <span class="decorator">@Binds</span> <br><span class="decorator">@Singleton</span> <br>abstract fun bindStatusProvider(devConfig: HabitHatchDevConfig): GoalStatusProvider |

---


## AppModule


<span class="decorator">@Module</span> 

<span class="kotlin-class">class</span> AppModule

Configures Hilt DI providers for the app.

### Constructors

| | |
|---|---|
| AppModule | constructor() |

### Functions

| Name | Summary |
|---|---|
| provideDatabase | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br>fun provideDatabase(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): AppDatabase |
| provideGoalDao | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br>fun provideGoalDao(database: AppDatabase): GoalDao |
| provideGoogleFontProvider | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br>fun provideGoogleFontProvider(): [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html) |
| provideUserDao | <span class="decorator">@Provides</span> <br><span class="decorator">@Singleton</span> <br>fun provideUserDao(database: AppDatabase): UserDao |

---


## GoalPriorityProvider

<span class="interface">interface</span> GoalPriorityProvider

Provides the priorities for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

### Properties

| Name | Summary |
|---|---|
| defaultPriority | abstract val defaultPriority: GoalModel.Priority |
| priorities | abstract val priorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |

### Functions

| Name | Summary |
|---|---|
| getPriorityByLabel | open fun getPriorityByLabel(priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): GoalModel.Priority |

---


## GoalStatusProvider

<span class="interface">interface</span> GoalStatusProvider

Provides the statuses for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

### Properties

| Name | Summary |
|---|---|
| defaultStatus | abstract val defaultStatus: GoalModel.Status |
| statuses | abstract val statuses: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Status&gt; |

### Functions

| Name | Summary |
|---|---|
| getStatusByLabel | open fun getStatusByLabel(statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): GoalModel.Status |

---


## HabitHatchConfig

<span class="interface">interface</span> HabitHatchConfig : GoalStatusProvider, GoalPriorityProvider

The main application configuration.

#### Inheritors

| |
|---|
| HabitHatchDevConfig |

### Properties

| Name | Summary |
|---|---|
| aiNavItem | abstract val aiNavItem: Screen |
| bodyFontFamily | abstract val bodyFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| defaultGoalQuery | abstract val defaultGoalQuery: GoalQuery |
| displayFontFamily | abstract val displayFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| exampleGoals | abstract val exampleGoals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| homeNavigationItem | abstract val homeNavigationItem: Screen |
| navigationItems | abstract val navigationItems: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt; |
| pets | abstract val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| settingsNavigationItem | abstract val settingsNavigationItem: Screen |
| signUpNavigationItem | abstract val signUpNavigationItem: Screen |
| topLeftNavItem | abstract val topLeftNavItem: Screen |
| topRightNavItem | abstract val topRightNavItem: Screen |

---


## HabitHatchDevConfig


<span class="kotlin-class">class</span> HabitHatchDevConfig<span class="decorator">@Injectconstructor</span> (googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: GoalModel.Factory) : HabitHatchConfig

The main application configuration for the development environment.

### Constructors

| | |
|---|---|
| HabitHatchDevConfig | <span class="decorator">@Inject</span> <br>constructor(googleFontProvider: [GoogleFont.Provider](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/googlefonts/GoogleFont.Provider.html), goalModelFactory: GoalModel.Factory) |

### Properties

| Name | Summary |
|---|---|
| aiNavItem | open override val aiNavItem: Screen |
| bodyFontFamily | open override val bodyFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| defaultGoalQuery | open override var defaultGoalQuery: GoalQuery |
| defaultPriority | open override val defaultPriority: GoalModel.Priority |
| defaultStatus | open override val defaultStatus: GoalModel.Status |
| displayFontFamily | open override val displayFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html) |
| exampleGoals | open override val exampleGoals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| homeNavigationItem | open override val homeNavigationItem: Screen |
| navigationItems | open override val navigationItems: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt; |
| numberExampleGoals | val numberExampleGoals: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 12 |
| pets | open override val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| priorities | open override val priorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |
| settingsNavigationItem | open override val settingsNavigationItem: Screen |
| signUpNavigationItem | open override val signUpNavigationItem: Screen |
| statuses | open override val statuses: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Status&gt; |
| topLeftNavItem | open override val topLeftNavItem: Screen |
| topRightNavItem | open override val topRightNavItem: Screen |

---


## InvalidUUIdException


<span class="kotlin-class">class</span> InvalidUUIdException(uuid: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), causedBy: [Exception](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-exception/index.html)) : [IllegalArgumentException](https://developer.android.com/reference/kotlin/java/lang/IllegalArgumentException.html)

Exception thrown when a UUID is invalid.

### Constructors

| | |
|---|---|
| InvalidUUIdException | constructor(uuid: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), causedBy: [Exception](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-exception/index.html)) |

---


## UserExistsException


<span class="kotlin-class">class</span> UserExistsException(user: User) : [IllegalStateException](https://developer.android.com/reference/kotlin/java/lang/IllegalStateException.html)

Exception thrown when a user already exists in the database. Only one user is allowed in the local database.

### Constructors

| | |
|---|---|
| UserExistsException | constructor(user: User) |

---


## Screen


data <span class="kotlin-class">class</span> Screen(val route: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true)

### Constructors

| | |
|---|---|
| Screen | constructor(route: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true) |

### Properties

| Name | Summary |
|---|---|
| enabled | val enabled: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true |
| iconResourceId | val iconResourceId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| route | val route: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| title | val title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |

---


## Companion


object Companion

### Functions

| Name | Summary |
|---|---|
| createFromFilter | fun createFromFilter(goalFilter: GoalFilter, priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider): GoalFilter.Builder<br>Creates a GoalFilter.Builder from a GoalFilter. |
| matchAllBuilder | fun matchAllBuilder(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider): GoalFilter.Builder<br>Creates a GoalFilter.Builder that matches all goals. |

---


## GoalFilterBuilderFactory


<span class="kotlin-class">class</span> GoalFilterBuilderFactory<span class="decorator">@Injectconstructor</span> (priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider)

### Constructors

| | |
|---|---|
| GoalFilterBuilderFactory | <span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider) |

### Properties

| Name | Summary |
|---|---|
| matchAllBuilder | val matchAllBuilder: GoalFilter.Builder |

---


## Factory


<span class="kotlin-class">class</span> Factory<span class="decorator">@Injectconstructor</span> (priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider)

### Constructors

| | |
|---|---|
| Factory | <span class="decorator">@Inject</span> <br>constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider) |

### Functions

| Name | Summary |
|---|---|
| createFilterQuery | fun createFilterQuery(filter: GoalFilter): GoalQuery |
| createGoalQuery | fun createGoalQuery(filter: GoalFilter, sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; = emptyList(), defaultComparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt; = compareBy { 0 }): GoalQuery |

---


## GoalSortOption

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> GoalSortOption(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt;, val sortState: SortState = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;GoalSortOption&gt; 

Represents a sort option for goals.

#### Parameters


| | |
|---|---|
| label | The label of the sort option. |
| _comparator | The comparator for the sort option. |
| sortState | The current state of the sort option. |
| uiIndex | changes the position of the sort option in the UI. |

### Constructors

| | |
|---|---|
| GoalSortOption | constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), _comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt;, sortState: SortState = SortState.NOT_USED, uiIndex: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |

### Properties

| Name | Summary |
|---|---|
| comparator | val comparator: [Comparator](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparator/index.html)&lt;GoalModel&gt; |
| label | val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| sortState | val sortState: SortState |

### Functions

| Name | Summary |
|---|---|
| compareTo | open operator override fun compareTo(other: GoalSortOption): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| cycleState | fun cycleState(): GoalSortOption<br>Returns a copy of this sort option with the sort state cycled. |
| equals | open operator override fun equals(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| hashCode | open override fun hashCode(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| isUsed | fun isUsed(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| toString | open override fun toString(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |

---


## PriorityVisibility


typealias PriorityVisibility = [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;GoalModel.Priority, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;

---


## ASCENDING


ASCENDING

---


## DESCENDING


DESCENDING

---


## NOT_USED


NOT_USED

---


## StatusVisibility


typealias StatusVisibility = [Map](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-map/index.html)&lt;GoalModel.Status, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt;

---


## Companion


object Companion

---


## SchemeColor


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> SchemeColor(lightColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), darkColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html))

A color scheme that provides a light and dark color.

### Constructors

| | |
|---|---|
| SchemeColor | constructor(lightColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), darkColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)) |

### Properties

| Name | Summary |
|---|---|
| color | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val color: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |

---


## TypographyFactory


<span class="kotlin-class">class</span> TypographyFactory<span class="decorator">@Injectconstructor</span> (config: HabitHatchConfig)

### Constructors

| | |
|---|---|
| TypographyFactory | <span class="decorator">@Inject</span> <br>constructor(config: HabitHatchConfig) |

### Functions

| Name | Summary |
|---|---|
| create | fun create(): [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| createRandomDate | fun createRandomDate(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)<br>Returns a new random [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html), that is at most pastYears years in the past. |
| darken | fun [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html).darken(factor: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)<br>Darkens the **color** by the given factor. |
| disableAll | fun [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.disableAll(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| getAlphaFactor | fun GoalModel.Priority.getAlphaFactor(): [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)<br>Returns the alpha factor for the priority. Used to give more weight to high importance goals. |
| getNextHigherOrLowest | fun &lt;T, R : [Comparable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-comparable/index.html)&lt;R&gt;&gt; [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;T&gt;.getNextHigherOrLowest(bySelector: (T) -&gt; R, element: T): T |
| getUsed | fun [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.getUsed(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| lighten | fun [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html).lighten(factor: [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html)<br>Lightens the **color** by the given factor. |
| minusYears | fun [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html).minusYears(years: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)<br>Returns a new [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) that is years years after this instant. |
| removeByLabel | fun [Iterable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-iterable/index.html)&lt;GoalSortOption&gt;.removeByLabel(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |
| withFontFamily | fun [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html).withFontFamily(displayFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html), bodyFontFamily: [FontFamily](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/font/FontFamily.html)): [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html)<br>Returns a new [Typography](https://developer.android.com/reference/kotlin/androidx/compose/material3/Typography.html) with the specified font families. |

---


## GoalDao


<span class="interface">interface</span> GoalDao

The Data Access Object for the GoalEntity class.

### Functions

| Name | Summary |
|---|---|
| deleteAll | abstract suspend fun deleteAll() |
| getAll | abstract fun getAll(): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalEntity&gt;&gt; |
| getGoalById | abstract fun getGoalById(goalId: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)): Flow&lt;GoalEntity?&gt; |
| insert | abstract suspend fun insert(goal: GoalEntity) |
| insertAll | abstract suspend fun insertAll(goals: [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalEntity&gt;) |
| update | abstract suspend fun update(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

---


## UserDao


<span class="interface">interface</span> UserDao

The Data Access Object for the User class.

### Functions

| Name | Summary |
|---|---|
| deleteAll | abstract suspend fun deleteAll() |
| getUser | abstract fun getUser(): Flow&lt;User?&gt; |
| insert | abstract suspend fun insert(user: User) |

---


## AppDatabase


abstract <span class="kotlin-class">class</span> AppDatabase : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

The Room database for this app.

### Constructors

| | |
|---|---|
| AppDatabase | constructor() |

### Functions

| Name | Summary |
|---|---|
| goalDao | abstract fun goalDao(): GoalDao |
| userDao | abstract fun userDao(): UserDao |

---


## Converters


<span class="kotlin-class">class</span> Converters

Converters is a <span class="kotlin-class">class</span> that provides type converters for Room. Converts between UUID and String and Instant and String.

### Constructors

| | |
|---|---|
| Converters | constructor() |

### Functions

| Name | Summary |
|---|---|
| fromInstant | fun fromInstant(instant: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| fromUUID | fun fromUUID(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| toInstant | fun toInstant(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| toUUID | fun toUUID(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |

---


## DatabaseProvider


object DatabaseProvider

### Functions

| Name | Summary |
|---|---|
| getDatabase | fun getDatabase(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): AppDatabase |

---


## GoalEntity


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> GoalEntity(val id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), val title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), val statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html))

GoalEntity is a Room entity that represents a goal.

### Constructors

| | |
|---|---|
| GoalEntity | constructor(id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html), statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)) |

### Properties

| Name | Summary |
|---|---|
| createdAt | val createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html) |
| id | val id: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) |
| priorityLabel | val priorityLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| statusLabel | val statusLabel: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| title | val title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| userId | val userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |

---


## Pet


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> Pet(val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html))

Pet represents a pet

### Constructors

| | |
|---|---|
| Pet | constructor(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) |

### Properties

| Name | Summary |
|---|---|
| imageRes | val imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |
| name | val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |

---


## User

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> User(val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), val pet: Pet)

User represents a user.

#### Parameters


| | |
|---|---|
| uuid | the UUID of the user, for global identification |
| pet | the pet of the user |

### Constructors

| | |
|---|---|
| User | constructor(uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) = UUID.randomUUID(), pet: Pet) |

### Properties

| Name | Summary |
|---|---|
| pet | val pet: Pet |
| uuid | val uuid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html) |

---


## GoalMapper


<span class="kotlin-class">class</span> GoalMapper<span class="decorator">@Injectconstructor</span> (statusProvider: GoalStatusProvider, priorityProvider: GoalPriorityProvider, goalModelFactory: GoalModel.Factory)

GoalMapper is a mapper that maps GoalModel to GoalEntity and vice versa. GoalEntity is a RoomEntity, used for storing goals in the database. GoalModel is a model used for creating and displaying goals.

### Constructors

| | |
|---|---|
| GoalMapper | <span class="decorator">@Inject</span> <br>constructor(statusProvider: GoalStatusProvider, priorityProvider: GoalPriorityProvider, goalModelFactory: GoalModel.Factory) |

### Functions

| Name | Summary |
|---|---|
| asEntity | fun asEntity(goal: GoalModel, userId: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)): GoalEntity<br>Maps a GoalModel to a GoalEntity. Every Goal in the Database needs to have a createdAt date. If the goal is a draft, the createdAt date is set to the current date. |
| asModel | fun asModel(entity: GoalEntity): GoalModel |

---


## ExampleGoalFactory


<span class="kotlin-class">class</span> ExampleGoalFactory(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider, goalModelFactory: GoalModel.Factory)

ExampleGoalFactory is a factory that creates example goals for testing purposes.

### Constructors

| | |
|---|---|
| ExampleGoalFactory | constructor(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider, goalModelFactory: GoalModel.Factory) |

### Functions

| Name | Summary |
|---|---|
| createExampleGoal | fun createExampleGoal(pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1): GoalModel |
| createExampleGoals | fun createExampleGoals(count: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), pastYears: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html) = 1, uniqueTitles: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [Collection](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-collection/index.html)&lt;GoalModel&gt; |
| randomPriority | fun randomPriority(): GoalModel.Priority |
| randomStatus | fun randomStatus(): GoalModel.Status |

---


## Factory


<span class="kotlin-class">class</span> Factory<span class="decorator">@Injectconstructor</span> 

### Constructors

| | |
|---|---|
| Factory | <span class="decorator">@Inject</span> <br>constructor() |

### Functions

| Name | Summary |
|---|---|
| createDraft | fun createDraft(status: GoalModel.Status, priority: GoalModel.Priority): GoalModel<br>fun createDraft(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;&quot;, status: GoalModel.Status, priority: GoalModel.Priority): GoalModel |
| createExample | fun createExample(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), status: GoalModel.Status, priority: GoalModel.Priority, createdAt: [Instant](https://developer.android.com/reference/kotlin/java/time/Instant.html)): GoalModel |
| createFromEntity | fun createFromEntity(entity: GoalEntity, status: GoalModel.Status, priority: GoalModel.Priority): GoalModel |

---


## High


object High : GoalModel.Priority.Importance

---


## Low


object Low : GoalModel.Priority.Importance

---


## Normal


object Normal : GoalModel.Priority.Importance

---


## VeryHigh


object VeryHigh : GoalModel.Priority.Importance

---


## VeryLow


object VeryLow : GoalModel.Priority.Importance

---


## Status


@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> Status(val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val stepNumber: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), val isDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false)

### Constructors

| | |
|---|---|
| Status | constructor(label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), stepNumber: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), isDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false) |

### Properties

| Name | Summary |
|---|---|
| isDone | val isDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| label | val label: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| stepNumber | val stepNumber: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| equals | open operator override fun equals(other: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| hashCode | open override fun hashCode(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

---


## GoalRepository


<span class="kotlin-class">class</span> GoalRepository<span class="decorator">@Injectconstructor</span> (goalDao: GoalDao, goalMapper: GoalMapper, userRepository: UserRepository)

GoalRepository is a repository that provides access to goals in the database.

### Constructors

| | |
|---|---|
| GoalRepository | <span class="decorator">@Inject</span> <br>constructor(goalDao: GoalDao, goalMapper: GoalMapper, userRepository: UserRepository) |

### Functions

| Name | Summary |
|---|---|
| deleteAll | suspend fun deleteAll()<br>Deletes all goals permanently from the database. |
| getQueriedGoals | fun getQueriedGoals(query: GoalQuery): Flow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;&gt;<br>Returns a flow of goals that match the given GoalQuery. Sorted by GoalQuery's comparator. |
| insert | suspend fun insert(vararg goals: GoalModel)<br>Inserts the given goals into the database. |
| update | suspend fun update(goal: GoalModel)<br>Updates the given goal in the database. |

---


## UserRepository


<span class="kotlin-class">class</span> UserRepository<span class="decorator">@Injectconstructor</span> (userDao: UserDao)

UserRepository is a repository that provides access to the user in the database. Since there is only one user, the repository provides methods to create, read, update and delete the user.

### Constructors

| | |
|---|---|
| UserRepository | <span class="decorator">@Inject</span> <br>constructor(userDao: UserDao) |

### Functions

| Name | Summary |
|---|---|
| createUser | suspend fun createUser(user: User) |
| deleteUser | suspend fun deleteUser() |
| getUser | fun getUser(): Flow&lt;User?&gt; |
| hasUser | suspend fun hasUser(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |

---


## AIAssistantViewModel


<span class="kotlin-class">class</span> AIAssistantViewModel<span class="decorator">@Injectconstructor</span> (application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

### Constructors

| | |
|---|---|
| AIAssistantViewModel | <span class="decorator">@Inject</span> <br>constructor(application: [Application](https://developer.android.com/reference/kotlin/android/app/Application.html)) |

### Properties

| Name | Summary |
|---|---|
| isListening | val isListening: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| showPermissionDialog | val showPermissionDialog: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| text | val text: StateFlow&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; |

### Functions

| Name | Summary |
|---|---|
| startListening | fun startListening() |

---


## AIScreenState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-class">class</span> AIScreenState(val text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), val onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the AI screen.

#### Parameters


| | |
|---|---|
| text | The text to display on the screen. |
| isListening | Whether the AI assistant is currently listening. |
| showPermissionDialog | Whether to show the permission dialog. |
| onStartListening | The callback to start listening. |

### Constructors

| | |
|---|---|
| AIScreenState | constructor(text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

### Properties

| Name | Summary |
|---|---|
| isListening | val isListening: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| onStartListening | val onStartListening: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showPermissionDialog | val showPermissionDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) |
| text | val text: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |

---


## CoreHomeState


data <span class="kotlin-class">class</span> CoreHomeState(val pet: Pet?, val isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

Represents the main state information for the home screen.

### Constructors

| | |
|---|---|
| CoreHomeState | constructor(pet: Pet?, isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

### Properties

| Name | Summary |
|---|---|
| allGoalsDone | val allGoalsDone: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| isUserLoggedIn | val isUserLoggedIn: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |
| onAddGoalClicked | val onAddGoalClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| pet | val pet: Pet? |

---


## HomeScreenState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-class">class</span> HomeScreenState(val addGoalDialogState: AddGoalDialogState, val goalsViewState: GoalsViewState, val goalFilterState: GoalFilterState, val goalSortState: GoalSortState, val core: CoreHomeState)

Represents the state of the home screen.

#### Parameters


| | |
|---|---|
| addGoalDialogState | The state of the add goal dialog. |
| goalsViewState | The state of the goals view. |
| goalFilterState | The state of the goal filter. |
| goalSortState | The state of the goal sort. |
| core | The core state of the home screen. |

### Constructors

| | |
|---|---|
| HomeScreenState | constructor(addGoalDialogState: AddGoalDialogState, goalsViewState: GoalsViewState, goalFilterState: GoalFilterState, goalSortState: GoalSortState, core: CoreHomeState) |

### Properties

| Name | Summary |
|---|---|
| addGoalDialogState | val addGoalDialogState: AddGoalDialogState |
| core | val core: CoreHomeState |
| goalFilterState | val goalFilterState: GoalFilterState |
| goalSortState | val goalSortState: GoalSortState |
| goalsViewState | val goalsViewState: GoalsViewState |

---


## HomeViewModel


<span class="kotlin-class">class</span> HomeViewModel<span class="decorator">@Injectconstructor</span> (userRepository: UserRepository, goalRepository: GoalRepository, val config: HabitHatchConfig, val goalQueryFactory: GoalQuery.Factory, val builderFactory: GoalFilterBuilderFactory) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

### Constructors

| | |
|---|---|
| HomeViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository, config: HabitHatchConfig, goalQueryFactory: GoalQuery.Factory, builderFactory: GoalFilterBuilderFactory) |

### Properties

| Name | Summary |
|---|---|
| allGoalsDone | val allGoalsDone: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| builderFactory | val builderFactory: GoalFilterBuilderFactory |
| config | val config: HabitHatchConfig |
| goalQuery | val goalQuery: StateFlow&lt;GoalQuery&gt; |
| goalQueryFactory | val goalQueryFactory: GoalQuery.Factory |
| hasAnyGoals | val hasAnyGoals: StateFlow&lt;[Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)&gt; |
| queriedGoals | val queriedGoals: StateFlow&lt;[List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;&gt; |
| user | val user: StateFlow&lt;User?&gt; |

### Functions

| Name | Summary |
|---|---|
| addGoal | fun addGoal(goal: GoalModel) |
| seedGoals | fun seedGoals() |
| toggleGoalStatus | fun toggleGoalStatus(goal: GoalModel) |
| updateGoalFilter | fun updateGoalFilter(newGoalFilter: GoalFilter) |
| updateGoalSortOption | fun updateGoalSortOption(newGoalSortOption: GoalSortOption) |

---


## SettingsScreenState

data <span class="kotlin-class">class</span> SettingsScreenState(val onDeleteAccount: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the settings screen.

#### Parameters


| | |
|---|---|
| onDeleteAccount | The callback to delete the user account. |

### Constructors

| | |
|---|---|
| SettingsScreenState | constructor(onDeleteAccount: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

### Properties

| Name | Summary |
|---|---|
| onDeleteAccount | val onDeleteAccount: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |

---


## SettingsViewModel


<span class="kotlin-class">class</span> SettingsViewModel<span class="decorator">@Injectconstructor</span> (userRepository: UserRepository, goalRepository: GoalRepository) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

SettingsViewModel is a ViewModel that provides the settings screen with the necessary data.

### Constructors

| | |
|---|---|
| SettingsViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, goalRepository: GoalRepository) |

### Functions

| Name | Summary |
|---|---|
| deleteAccount | fun deleteAccount() |

---


## LOADING


LOADING

---


## NOT_SIGNED_UP


NOT_SIGNED_UP

---


## SIGNED_UP


SIGNED_UP

---


## SignupScreenState


data <span class="kotlin-class">class</span> SignupScreenState(val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt;, val signUpState: SignUpState, val onPetConfirmed: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))

Represents the state of the signup screen.

### Constructors

| | |
|---|---|
| SignupScreenState | constructor(pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt;, signUpState: SignUpState, onPetConfirmed: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) |

### Properties

| Name | Summary |
|---|---|
| onPetConfirmed | val onPetConfirmed: (Pet) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| pets | val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| signUpState | val signUpState: SignUpState |

---


## SignupViewModel


<span class="kotlin-class">class</span> SignupViewModel<span class="decorator">@Injectconstructor</span> (userRepository: UserRepository, habitHatchConfig: HabitHatchConfig) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

### Constructors

| | |
|---|---|
| SignupViewModel | <span class="decorator">@Inject</span> <br>constructor(userRepository: UserRepository, habitHatchConfig: HabitHatchConfig) |

### Properties

| Name | Summary |
|---|---|
| pets | val pets: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Pet&gt; |
| signUpState | val signUpState: StateFlow&lt;SignUpState&gt; |

### Functions

| Name | Summary |
|---|---|
| signUpUser | fun signUpUser(user: User) |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| ImageBox | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun ImageBox(imageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, isChecked: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))<br>A box with an image and a checkmark indicator. |
| ImageTextCard | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun ImageTextCard(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, imageContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), text: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), spacing: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 8.dp, onSelected: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A card with an image and text. |
| SelectionGrid | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun &lt;T&gt; SelectionGrid(elements: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;T&gt;, columns: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 2, outSidePadding: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 50.dp, spaceBetween: [Dp](https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/Dp.html) = 30.dp, onConfirm: (T) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), card: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(T, [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A grid of elements that can be selected. |

---


## DialogHost


<span class="kotlin-class">class</span> DialogHost

A host for dialogs.

### Constructors

| | |
|---|---|
| DialogHost | constructor() |

### Functions

| Name | Summary |
|---|---|
| createConfirmDialog | fun createConfirmDialog(titleRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), messageRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), confirmButtonRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), dismissButtonRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), onConfirm: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Creates a confirm dialog. |
| Render | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun Render()<br>Renders the dialog. |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| SearchField | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun SearchField(searchQuery: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), onQueryChange: ([String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, shape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) = MaterialTheme.shapes.large, textStyle: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) = MaterialTheme.typography.bodySmall)<br>A search field that allows the user to input a search query. |
| SearchFieldPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)(showBackground = true)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun SearchFieldPreview() |
| SimpleIconButton | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun SimpleIconButton(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier.size(36.dp), labelRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), color: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), painter: [Painter](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/painter/Painter.html), onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A simple icon button with a label. |

---


## AddGoalDialogState


data <span class="kotlin-class">class</span> AddGoalDialogState(val showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val goal: GoalModel, val allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt;, val onAddGoal: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, val onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

### Constructors

| | |
|---|---|
| AddGoalDialogState | constructor(showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, goal: GoalModel, allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt;, onAddGoal: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

### Properties

| Name | Summary |
|---|---|
| allPriorities | val allPriorities: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;GoalModel.Priority&gt; |
| goal | val goal: GoalModel |
| onAddGoal | val onAddGoal: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| onDismiss | val onDismiss: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showDialog | val showDialog: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false |

---


## GoalFilterState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-class">class</span> GoalFilterState(val goalFilterBuilder: GoalFilter.Builder, val onGoalFilterChange: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goal filter.

#### Parameters


| | |
|---|---|
| goalFilterBuilder | The builder of the goal filter. |
| onGoalFilterChange | The action to be performed when the goal filter changes. |

### Constructors

| | |
|---|---|
| GoalFilterState | constructor(goalFilterBuilder: GoalFilter.Builder, onGoalFilterChange: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

### Properties

| Name | Summary |
|---|---|
| goalFilterBuilder | val goalFilterBuilder: GoalFilter.Builder |
| onGoalFilterChange | val onGoalFilterChange: (GoalFilter) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |

---


## GoalSortState

@[Stable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Stable.html)

<span class="kotlin-class">class</span> GoalSortState(val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt;, val onSortOptionChange: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { })

The state of the goal sort.

#### Parameters


| | |
|---|---|
| sortOptions | The list of sort options. |
| onSortOptionChange | The action to be performed when the sort option changes. |

### Constructors

| | |
|---|---|
| GoalSortState | constructor(sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt;, onSortOptionChange: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = { }) |

### Properties

| Name | Summary |
|---|---|
| onSortOptionChange | val onSortOptionChange: (GoalSortOption) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| sortOptions | val sortOptions: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalSortOption&gt; |

---


## GoalStyleProvider


object GoalStyleProvider

The provider of the style of a goal.

### Functions

| Name | Summary |
|---|---|
| getContainerColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun getContainerColor(goal: GoalModel): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| getGoalStyle | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun getGoalStyle(goal: GoalModel): GoalStyle |

---


## GoalsViewState

@[Immutable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Immutable.html)

data <span class="kotlin-class">class</span> GoalsViewState(val goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;, val showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, val onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, val onToggleGoalStatus: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})

The state of the goals view.

#### Parameters


| | |
|---|---|
| goals | The list of goals. |
| showCreateExampleGoals | Whether to show the create example goals button. |
| onCreateExampleGoals | The action to be performed when the create example goals button is clicked. |
| onToggleGoalStatus | The action to be performed when the goal status is toggled. |

### Constructors

| | |
|---|---|
| GoalsViewState | constructor(goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt;, showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true, onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onToggleGoalStatus: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}) |

### Properties

| Name | Summary |
|---|---|
| goals | val goals: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;GoalModel&gt; |
| onCreateExampleGoals | val onCreateExampleGoals: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| onToggleGoalStatus | val onToggleGoalStatus: (GoalModel) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) |
| showCreateExampleGoals | val showCreateExampleGoals: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = true |

---


## GoalStyle

data <span class="kotlin-class">class</span> GoalStyle(val borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, val iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), val cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html))

The style of a goal.

#### Parameters


| | |
|---|---|
| borderColor | The color of the border. |
| containerColor | The color of the container. |
| textDecoration | The text decoration. |
| iconColor | The color of the icon. |
| cardShape | The shape of the card. |

### Constructors

| | |
|---|---|
| GoalStyle | constructor(borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) = TextDecoration.None, iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html)) |

### Properties

| Name | Summary |
|---|---|
| borderColor | val borderColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| cardColors | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val cardColors: [CardColors](https://developer.android.com/reference/kotlin/androidx/compose/material3/CardColors.html) |
| cardShape | val cardShape: [CornerBasedShape](https://developer.android.com/reference/kotlin/androidx/compose/foundation/shape/CornerBasedShape.html) |
| containerColor | val containerColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| iconColor | val iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| textColor | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val textColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| textDecoration | val textDecoration: [TextDecoration](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration.html) |
| textStyle | <span class="decorator">@get</span> :[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>val textStyle: [TextStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle.html) |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| getDoneColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun getDoneColor(isDoneStatusVisible: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| GoalFilterBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun GoalFilterBar(state: GoalFilterState, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>A bar that contains a search field and a button to toggle the visibility of done goals. |
| GoalQueryTable | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun GoalQueryTable(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, filterContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(defaultModifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), sortContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)(defaultModifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html), goalsContent: @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A table that displays a list of goals. With filter and sort options. |
| GoalSortBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun GoalSortBar(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, state: GoalSortState)<br>A bar that displays sort options for goals. |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| NavItem | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun NavItem(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier.size(24.dp), navScreen: Screen, iconColor: [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html), onClick: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A navigation item that displays an icon. |
| TopAppInformationBarPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun TopAppInformationBarPreview() |
| TopNavBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun TopNavBar(title: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), rightNavItem: Screen? = null, leftNavItem: Screen? = null, modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier, onRightNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {}, onLeftNavItemClicked: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A top navigation bar that displays the title and navigation items. |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| borderColor | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun borderColor(isPetHappy: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [Color](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Color.html) |
| PetAnimation | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun PetAnimation(pet: Pet, isPetHappy: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) = Modifier)<br>A pet animation that displays a pet. |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| AccountSettings | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun AccountSettings(onOpenDeleteAccountDialog: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>A view that displays account settings. |

---


## Package-level declarations

### Functions

| Name | Summary |
|---|---|
| BottomNavBar | @[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun BottomNavBar(navigationItems: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;Screen&gt;, activeNavScreen: Screen? = null, onNavigationItemClicked: (Screen) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html) = {})<br>A bottom navigation bar that displays the navigation items. |
| BottomNavigationBarPreview | @[Preview](https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview.html)<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun BottomNavigationBarPreview() |
