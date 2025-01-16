# Code Documentation
## Core

The core package of the HabitHatch application contains the foundational components that drive the app's functionality. It is responsible for managing configuration, application lifecycle, navigation, and essential utilities that power various features of the app.

### Purpose
The core package promotes modularity and maintainability by organizing related functionalities into distinct subpackages. This design allows for clear separation of concerns, making the application easier to develop, test, and extend.

### Key Responsibilities
- **Application Lifecycle** – Manages the initialization and configuration of the app.
- **Dependency Injection** – Provides the necessary dependencies across the app using modules and binding configurations.
- **Navigation** – Defines the structure for in-app navigation, screen transitions, and route management.
- **Configuration Management** – Centralizes application settings, priorities, and environment configurations.
- **Error Handling** – Implements custom exception classes to manage app-specific errors gracefully.
- **Utilities** – Provides general-purpose extension functions and utility classes for common operations.
- **AI Interaction** – Facilitates communication with AI components and clients.
- **UI and Theming** – Manages the theming, color schemes, and typography to ensure consistent styling across the app.

### Design Philosophy
The core package follows best practices for Kotlin development, emphasizing:
- **Immutability** – Leveraging immutable data classes to ensure thread safety and predictable behavior.
- **Reusability** – Building reusable components that can be easily integrated across different parts of the application.
- **Extensibility** – Designing for future growth by organizing code in a way that new features can be added with minimal disruption to existing functionality.
- **Consistency** – Maintaining consistent design patterns across different modules to enhance readability and reduce complexity.




### HabitHatchApp


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">HabitHatchApp</span> : <span class="kotlin-type">Application</span>

The main application <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">for</span><span class="kotlin-type"></span> the app.




### ImmediatelyFinishingActivity


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">ImmediatelyFinishingActivity</span> : <span class="kotlin-type">ComponentActivity</span>

An activity that immediately finishes itself when created. This is used for having an Activity change without any visual change.




### MainActivity


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">MainActivity</span> : <span class="kotlin-type">ComponentActivity</span>

The main activity of the app. This activity is responsible for setting up the app's theme and navigation.

#### Properties

| Name | Summary |
|---|---|
| config | <span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw modifier lateinit">lateinit</span> <span class="kotlin-kw declaration var">var</span> <span class="kotlin-name var">config</span>: <span class="kotlin-type">HabitHatchConfig</span> |
| typographyFactory | <span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw modifier lateinit">lateinit</span> <span class="kotlin-kw declaration var">var</span> <span class="kotlin-name var">typographyFactory</span>: <span class="kotlin-type">TypographyFactory</span> |


### AssistantClient


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AssistantClient</span><span class="kotlin-type"></span>




### Frame


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Frame</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">imageRes</span>: <span class="kotlin-type">ImageResource</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">duration</span>: <span class="kotlin-type">Long</span> = 1000)

#### Properties

| Name | Summary |
|---|---|
| duration | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">duration</span>: <span class="kotlin-type">Long</span> = 1000 |
| imageRes | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">imageRes</span>: <span class="kotlin-type">ImageResource</span> |


### Companion


<span class="kotlin-kw declaration object">object</span> <span class="kotlin-name object">Companion</span><span class="kotlin-type"></span>

#### Functions

| Name | Summary |
|---|---|
| createFromFrames | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createFromFrames</span><span class="kotlin-type"></span>(frames: List&lt;Frame&gt;): FrameStateAnimation |
| createFromImages | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createFromImages</span><span class="kotlin-type"></span>(images: List&lt;ImageResource&gt;, duration: Long = 1000): FrameStateAnimation |


### IStateAnimation

<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">IStateAnimation</span><span class="kotlin-type"></span>

#### Inheritors

| |
|---|
| FrameStateAnimation |

#### Properties

| Name | Summary |
|---|---|
| state | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">state</span>: <span class="kotlin-type">StateFlow</span>&lt;Any?&gt; |

#### Functions

| Name | Summary |
|---|---|
| start | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">start</span><span class="kotlin-type"></span>() |
| stop | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">stop</span><span class="kotlin-type"></span>() |


### ImageResource


<span class="kotlin-kw declaration typealias">typealias</span> <span class="kotlin-name typealias">ImageResource</span><span class="kotlin-type"></span> = Int


### ImageStateAnimation


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">ImageStateAnimation</span><span class="kotlin-type"></span>(image: ImageResource) : FrameStateAnimation




### AppBindingModule


<span class="kotlin-kw decorator">@Module</span>

<span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AppBindingModule</span><span class="kotlin-type"></span>

Configures Hilt DI bindings for the app.

#### Functions

| Name | Summary |
|---|---|
| bindConfig | <span class="kotlin-kw decorator">@Binds</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">bindConfig</span><span class="kotlin-type"></span>(devConfig: HabitHatchDevConfig): HabitHatchConfig |
| bindPrioritiesProvider | <span class="kotlin-kw decorator">@Binds</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">bindPrioritiesProvider</span><span class="kotlin-type"></span>(devConfig: HabitHatchDevConfig): GoalPriorityProvider |
| bindStatusProvider | <span class="kotlin-kw decorator">@Binds</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">bindStatusProvider</span><span class="kotlin-type"></span>(devConfig: HabitHatchDevConfig): GoalStatusProvider |


### AppModule


<span class="kotlin-kw decorator">@Module</span>

<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AppModule</span><span class="kotlin-type"></span>

Configures Hilt DI providers for the app.

#### Functions

| Name | Summary |
|---|---|
| provideDatabase | <span class="kotlin-kw decorator">@Provides</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">provideDatabase</span><span class="kotlin-type"></span>(context: Context): AppDatabase |
| provideGoalDao | <span class="kotlin-kw decorator">@Provides</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">provideGoalDao</span><span class="kotlin-type"></span>(database: AppDatabase): GoalDao |
| provideGoogleFontProvider | <span class="kotlin-kw decorator">@Provides</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">provideGoogleFontProvider</span><span class="kotlin-type"></span>(): GoogleFont.Provider |
| provideUserDao | <span class="kotlin-kw decorator">@Provides</span><br><span class="kotlin-kw decorator">@Singleton</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">provideUserDao</span><span class="kotlin-type"></span>(database: AppDatabase): UserDao |


### GoalPriorityProvider

<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">GoalPriorityProvider</span><span class="kotlin-type"></span>

Provides the priorities for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

#### Properties

| Name | Summary |
|---|---|
| defaultPriority | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">defaultPriority</span>: <span class="kotlin-type">GoalModel</span>.Priority |
| priorities | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">priorities</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Priority&gt; |

#### Functions

| Name | Summary |
|---|---|
| getPriorityByLabel | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getPriorityByLabel</span><span class="kotlin-type"></span>(priorityLabel: String): GoalModel.Priority |


### GoalStatusProvider

<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">GoalStatusProvider</span><span class="kotlin-type"></span>

Provides the statuses for goals.

#### Inheritors

| |
|---|
| HabitHatchConfig |

#### Properties

| Name | Summary |
|---|---|
| defaultStatus | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">defaultStatus</span>: <span class="kotlin-type">GoalModel</span>.Status |
| statuses | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">statuses</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Status&gt; |

#### Functions

| Name | Summary |
|---|---|
| getStatusByLabel | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getStatusByLabel</span><span class="kotlin-type"></span>(statusLabel: String): GoalModel.Status |


### HabitHatchConfig

<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">HabitHatchConfig</span> : <span class="kotlin-type">GoalStatusProvider</span>, GoalPriorityProvider

The main application configuration.

#### Inheritors

| |
|---|
| HabitHatchDevConfig |

#### Properties

| Name | Summary |
|---|---|
| bodyFontFamily | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">bodyFontFamily</span>: <span class="kotlin-type">FontFamily</span> |
| defaultGoalQuery | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">defaultGoalQuery</span>: <span class="kotlin-type">GoalQuery</span> |
| displayFontFamily | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">displayFontFamily</span>: <span class="kotlin-type">FontFamily</span> |
| homeNavItem | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">homeNavItem</span>: <span class="kotlin-type">Screen</span> |
| navItems | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">navItems</span>: <span class="kotlin-type">List</span>&lt;Screen&gt; |
| numberExampleGoals | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">numberExampleGoals</span>: <span class="kotlin-type">Int</span> |
| pets | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pets</span>: <span class="kotlin-type">List</span>&lt;Pet&gt; |
| settingsNavigationItem | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">settingsNavigationItem</span>: <span class="kotlin-type">Screen</span> |
| signUpNavItem | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">signUpNavItem</span>: <span class="kotlin-type">Screen</span> |
| topRightNavItem | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">topRightNavItem</span>: <span class="kotlin-type">Screen</span> |

#### Functions

| Name | Summary |
|---|---|
| getActiveNavItem | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getActiveNavItem</span><span class="kotlin-type"></span>(navController: NavController): Screen |
| getPetById | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getPetById</span><span class="kotlin-type"></span>(id: Int): Pet |


### HabitHatchDevConfig


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">HabitHatchDevConfig</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(googleFontProvider: GoogleFont.Provider, petMoodAnimationsBuilder: PetMoodAnimationsFactory)</span> : HabitHatchConfig

The main application configuration for the development environment.

#### Properties

| Name | Summary |
|---|---|
| bodyFontFamily | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">bodyFontFamily</span>: <span class="kotlin-type">FontFamily</span> |
| catAnimation | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">catAnimation</span>: <span class="kotlin-type">PetMoodAnimations</span> |
| defaultGoalQuery | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration var">var</span> <span class="kotlin-name var">defaultGoalQuery</span>: <span class="kotlin-type">GoalQuery</span> |
| defaultPriority | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">defaultPriority</span>: <span class="kotlin-type">GoalModel</span>.Priority |
| defaultStatus | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">defaultStatus</span>: <span class="kotlin-type">GoalModel</span>.Status |
| displayFontFamily | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">displayFontFamily</span>: <span class="kotlin-type">FontFamily</span> |
| happyCatAnimation | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">happyCatAnimation</span>: <span class="kotlin-type">FrameStateAnimation</span> |
| homeNavItem | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">homeNavItem</span>: <span class="kotlin-type">Screen</span> |
| navItems | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">navItems</span>: <span class="kotlin-type">List</span>&lt;Screen&gt; |
| numberExampleGoals | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">numberExampleGoals</span>: <span class="kotlin-type">Int</span> = 12 |
| pets | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pets</span>: <span class="kotlin-type">List</span>&lt;Pet&gt; |
| priorities | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">priorities</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Priority&gt; |
| sadCatAnimation | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">sadCatAnimation</span>: <span class="kotlin-type">FrameStateAnimation</span> |
| settingsNavigationItem | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">settingsNavigationItem</span>: <span class="kotlin-type">Screen</span> |
| signUpNavItem | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">signUpNavItem</span>: <span class="kotlin-type">Screen</span> |
| statuses | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">statuses</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Status&gt; |
| topRightNavItem | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">topRightNavItem</span>: <span class="kotlin-type">Screen</span> |


### InvalidUUIdException


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">InvalidUUIdException</span><span class="kotlin-type"></span>(uuid: String, causedBy: Exception) : IllegalArgumentException

Exception thrown when a UUID is invalid.




### UserExistsException


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">UserExistsException</span><span class="kotlin-type"></span>(user: UserEntity) : IllegalStateException

Exception thrown when a user already exists in the database. Only one user is allowed in the local database.




### Screen


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Screen</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">route</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">iconResourceId</span>: <span class="kotlin-type">Int</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">enabled</span>: <span class="kotlin-type">Boolean</span> = true)

Represents a screen in the app. Is used to generate the navigation graph.

#### Properties

| Name | Summary |
|---|---|
| enabled | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">enabled</span>: <span class="kotlin-type">Boolean</span> = true |
| iconResourceId | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">iconResourceId</span>: <span class="kotlin-type">Int</span> |
| route | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">route</span>: <span class="kotlin-type">String</span> |
| title | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">title</span>: <span class="kotlin-type">String</span> |


### Companion


<span class="kotlin-kw declaration object">object</span> <span class="kotlin-name object">Companion</span><span class="kotlin-type"></span>

#### Functions

| Name | Summary |
|---|---|
| matchAllBuilder | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">matchAllBuilder</span><span class="kotlin-type"></span>(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider): GoalFilter.Builder<br>Creates a GoalFilter.Builder that matches all goals. |


### GoalFilterBuilderFactory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalFilterBuilderFactory</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider)</span>

Factory for creating GoalFilter.Builder instances.

#### Properties

| Name | Summary |
|---|---|
| matchAllBuilder | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">matchAllBuilder</span>: <span class="kotlin-type">GoalFilter</span>.Builder |


### Factory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Factory</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br>constructor

Factory for creating GoalQuery instances.

#### Functions

| Name | Summary |
|---|---|
| createQuery | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createQuery</span><span class="kotlin-type"></span>(filterBuilder: GoalFilter.Builder, sortOptions: List&lt;GoalSortOption&gt; = emptyList(), defaultComparator: Comparator&lt;GoalModel&gt; = compareBy { 0 }): GoalQuery |


### GoalSortOption

<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalSortOption</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">label</span>: <span class="kotlin-type">String</span>, _comparator: Comparator&lt;GoalModel&gt;, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">sortState</span>: <span class="kotlin-type">SortState</span> = SortState.NOT_USED, uiIndex: Int) : Comparable&lt;GoalSortOption&gt; 

Represents a sort option for goals.

#### Parameters


| Name | Description |
|---|---|
| label | The label of the sort option. |
| _comparator | The comparator for the sort option. |
| sortState | The current state of the sort option. |
| uiIndex | changes the position of the sort option in the UI. |

#### Properties

| Name | Summary |
|---|---|
| comparator | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">comparator</span>: <span class="kotlin-type">Comparator</span>&lt;GoalModel&gt; |
| label | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">label</span>: <span class="kotlin-type">String</span> |
| sortState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">sortState</span>: <span class="kotlin-type">SortState</span> |

#### Functions

| Name | Summary |
|---|---|
| cycleState | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">cycleState</span><span class="kotlin-type"></span>(): GoalSortOption<br>Returns a copy of this sort option with the sort state cycled. |
| isUsed | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">isUsed</span><span class="kotlin-type"></span>(): Boolean<br>Returns a copy of this sort option with the sort state set to SortState.NOT_USED. |


### PriorityVisibility


<span class="kotlin-kw declaration typealias">typealias</span> <span class="kotlin-name typealias">PriorityVisibility</span><span class="kotlin-type"></span> = Map&lt;GoalModel.Priority, Boolean&gt;


### SortState

<span class="kotlin-kw declaration enum">enum</span> <span class="kotlin-name enum">SortState</span> : <span class="kotlin-type">Enum</span>&lt;SortState&gt; 

Represents the state of a sort option.

#### Parameters


| Name | Description |
|---|---|
| iconId | The icon resource ID for the sort option. |

#### Properties

| Name | Summary |
|---|---|
| entries | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">entries</span>: <span class="kotlin-type">EnumEntries</span>&lt;SortState&gt;<br>Returns a representation of an immutable list of all <span class="kotlin-kw declaration enum">enum</span> <span class="kotlin-name enum">entries</span><span class="kotlin-type"></span>, in the order they're declared. |
| iconId | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">iconId</span>: <span class="kotlin-type">Int</span> |

#### Functions

| Name | Summary |
|---|---|
| nextInCycle | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">nextInCycle</span><span class="kotlin-type"></span>(): SortState<br>Returns the next state in the cycle. |
| valueOf | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">valueOf</span><span class="kotlin-type"></span>(value: String): SortState<br>Returns the <span class="kotlin-kw declaration enum">enum</span> <span class="kotlin-name enum">constant</span><span class="kotlin-type"></span> of this type with the specified name. The string must match exactly an identifier used to declare an <span class="kotlin-kw declaration enum">enum</span> <span class="kotlin-name enum">constant</span><span class="kotlin-type"></span> in this type. (Extraneous whitespace characters are not permitted.) |
| values | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">values</span><span class="kotlin-type"></span>(): Array&lt;SortState&gt;<br>Returns an array containing the constants of this <span class="kotlin-kw declaration enum">enum</span> <span class="kotlin-name enum">type</span><span class="kotlin-type"></span>, in the order they're declared. |


### StatusVisibility


<span class="kotlin-kw declaration typealias">typealias</span> <span class="kotlin-name typealias">StatusVisibility</span><span class="kotlin-type"></span> = Map&lt;GoalModel.Status, Boolean&gt;


### Companion


<span class="kotlin-kw declaration object">object</span> <span class="kotlin-name object">Companion</span><span class="kotlin-type"></span>


### SchemeColor


<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">SchemeColor</span><span class="kotlin-type"></span>(lightColor: Color, darkColor: Color)

A color scheme that provides a light and dark color.

#### Properties

| Name | Summary |
|---|---|
| color | <span class="kotlin-kw decorator">@get:Composable</span><br><span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">color</span>: <span class="kotlin-type">Color</span> |


### TypographyFactory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">TypographyFactory</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(config: HabitHatchConfig)</span>

Factory for creating Typography instances.

#### Functions

| Name | Summary |
|---|---|
| create | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">create</span><span class="kotlin-type"></span>(): Typography |


### Util

#### Functions

| Name | Summary |
|---|---|
| allDone | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Collection</span><span class="kotlin-type"></span>&lt;GoalModel&gt;.allDone(): Boolean |
| createRandomDate | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createRandomDate</span><span class="kotlin-type"></span>(pastYears: Long): Instant<br>Returns a new random Instant, that is at most pastYears years in the past. |
| darken | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Color</span><span class="kotlin-type"></span>.darken(factor: Float): Color<br>Darkens the **color** by the given factor. |
| disableAll | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Iterable</span><span class="kotlin-type"></span>&lt;GoalSortOption&gt;.disableAll(): List&lt;GoalSortOption&gt;<br>Disables all GoalSortOption's. |
| getAlphaFactor | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">GoalModel</span><span class="kotlin-type"></span>.Priority.getAlphaFactor(): Float<br>Returns the alpha factor for the priority. Used to give more weight to high importance goals. |
| getNextHigherOrLowest | fun &lt;T, R : Comparable&lt;R&gt;&gt; Collection&lt;T&gt;.getNextHigherOrLowest(bySelector: (T) -&gt; R, element: T): T<br>Returns the next higher element in the collection, based on the given selector. |
| getUsed | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Iterable</span><span class="kotlin-type"></span>&lt;GoalSortOption&gt;.getUsed(): List&lt;GoalSortOption&gt;<br>Returns all GoalSortOption's that are used. |
| lighten | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Color</span><span class="kotlin-type"></span>.lighten(factor: Float): Color<br>Lightens the **color** by the given factor. |
| minusYears | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Instant</span><span class="kotlin-type"></span>.minusYears(years: Long): Instant<br>Returns a new Instant that is years years after this instant. |
| navigateTo | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">NavController</span><span class="kotlin-type"></span>.navigateTo(screen: Screen) |
| removeByLabel | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Iterable</span><span class="kotlin-type"></span>&lt;GoalSortOption&gt;.removeByLabel(label: String): List&lt;GoalSortOption&gt;<br>Removes all GoalSortOption's with the given label. |
| withFontFamily | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Typography</span><span class="kotlin-type"></span>.withFontFamily(displayFontFamily: FontFamily, bodyFontFamily: FontFamily): Typography<br>Returns a new Typography with the specified font families. |

---
## Data

The data package in the HabitHatch application is responsible for managing the app's data layer. It provides access to local databases, entity mapping, and data transfer between the application and persistent storage. This package serves as the backbone for data persistence, retrieval, and manipulation.

### Purpose
The data package ensures efficient data management by encapsulating database operations, handling entities, and managing data transfer objects (DTOs). It acts as a bridge between the app's core logic and the underlying data storage systems, ensuring consistency and reliability in data handling.

### Key Responsibilities
- **Database Management** – Defines the app's database structure and provides configuration for data storage.
- **Data Access Objects (DAO)** – Facilitates communication with the database by providing methods for querying, inserting, updating, and deleting data.
- **Entities** – Represents tables in the database, mapping application data models to persistent storage.
- **Repositories** – Acts as an intermediary between DAOs and the application logic, handling complex data operations and providing a clean API for data access.
- **Mappers** – Transforms database entities into domain models and vice versa, ensuring seamless data conversion and transfer.
- **Models** – Provides data models used throughout the application, representing business logic and encapsulating related properties.

### Design Philosophy
The data package follows the principles of:
- **Separation of Concerns** – Dividing data access, storage, and transformation into distinct components.
- **Reusability** – Creating reusable components to handle data operations across different parts of the application.
- **Scalability** – Designing data structures that can grow with the application, allowing for future expansion and feature additions.
- **Consistency** – Maintaining uniform patterns for database operations and data access.


### GoalDao


<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">GoalDao</span><span class="kotlin-type"></span>

The <span class="kotlin-kw modifier Data">Data</span> Access Object for the GoalEntity class.

#### Functions

| Name | Summary |
|---|---|
| deleteAll | <span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">deleteAll</span><span class="kotlin-type"></span>()<br>Deletes all goals from the database. |
| getAll | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getAll</span><span class="kotlin-type"></span>(): Flow&lt;List&lt;GoalEntity&gt;&gt; |
| insert | <span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">insert</span><span class="kotlin-type"></span>(goal: GoalEntity)<br><span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">insert</span><span class="kotlin-type"></span>(goals: Collection&lt;GoalEntity&gt;) |
| update | <span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">update</span><span class="kotlin-type"></span>(id: Long, title: String, statusLabel: String, priorityLabel: String)<br>Updates the goal with the given id with the given title, statusLabel, and priorityLabel. GoalEntity.createdAt and GoalEntity.id are not allowed tto be updated. |


### UserDao


<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">UserDao</span><span class="kotlin-type"></span>

The <span class="kotlin-kw modifier Data">Data</span> Access Object for the UserEntity class.

#### Functions

| Name | Summary |
|---|---|
| deleteAll | <span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">deleteAll</span><span class="kotlin-type"></span>()<br>Deletes all users from the database. But there should only be one user in the database. |
| getUser | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getUser</span><span class="kotlin-type"></span>(): Flow&lt;UserEntity?&gt; |
| insert | <span class="kotlin-kw modifier abstract">abstract</span> suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">insert</span><span class="kotlin-type"></span>(user: UserEntity) |


### AppDatabase


<span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AppDatabase</span> : <span class="kotlin-type">RoomDatabase</span>

The Room database for this app.

#### Functions

| Name | Summary |
|---|---|
| goalDao | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">goalDao</span><span class="kotlin-type"></span>(): GoalDao |
| userDao | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">userDao</span><span class="kotlin-type"></span>(): UserDao |


### Converters


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Converters</span><span class="kotlin-type"></span>

Converters is a <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">that</span><span class="kotlin-type"></span> provides type converters for Room. Converts between UUID and String and Instant and String.

#### Functions

| Name | Summary |
|---|---|
| fromInstant | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">fromInstant</span><span class="kotlin-type"></span>(instant: Instant): String |
| fromUUID | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">fromUUID</span><span class="kotlin-type"></span>(uuid: UUID): String |
| toInstant | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">toInstant</span><span class="kotlin-type"></span>(value: String): Instant |
| toUUID | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">toUUID</span><span class="kotlin-type"></span>(value: String): UUID |


### DatabaseProvider


<span class="kotlin-kw declaration object">object</span> <span class="kotlin-name object">DatabaseProvider</span><span class="kotlin-type"></span>

#### Functions

| Name | Summary |
|---|---|
| getDatabase | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getDatabase</span><span class="kotlin-type"></span>(context: Context): AppDatabase |


### GoalEntity


<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalEntity</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">id</span>: <span class="kotlin-type">Long</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">title</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">userId</span>: <span class="kotlin-type">UUID</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">statusLabel</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">priorityLabel</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">createdAt</span>: <span class="kotlin-type">Instant</span>)

GoalEntity is a Room entity that represents a goal.

#### Properties

| Name | Summary |
|---|---|
| createdAt | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">createdAt</span>: <span class="kotlin-type">Instant</span> |
| id | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">id</span>: <span class="kotlin-type">Long</span> |
| priorityLabel | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">priorityLabel</span>: <span class="kotlin-type">String</span> |
| statusLabel | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">statusLabel</span>: <span class="kotlin-type">String</span> |
| title | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">title</span>: <span class="kotlin-type">String</span> |
| userId | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">userId</span>: <span class="kotlin-type">UUID</span> |


### Pet


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Pet</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">id</span>: <span class="kotlin-type">Int</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">name</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">coverImage</span>: <span class="kotlin-type">ImageResource</span>, petMoodAnimations: PetMoodAnimations? = null, mood: PetMood? = null)

Pet represents a pet

#### Properties

| Name | Summary |
|---|---|
| animationState | <span class="kotlin-kw declaration var">var</span> <span class="kotlin-name var">animationState</span>: <span class="kotlin-type">MutableStateFlow</span>&lt;FrameStateAnimation?&gt; |
| coverImage | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">coverImage</span>: <span class="kotlin-type">ImageResource</span> |
| id | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">id</span>: <span class="kotlin-type">Int</span> |
| name | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">name</span>: <span class="kotlin-type">String</span> |

#### Functions

| Name | Summary |
|---|---|
| equals | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier operator">operator</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">equals</span><span class="kotlin-type"></span>(other: Any?): Boolean |
| hashCode | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">hashCode</span><span class="kotlin-type"></span>(): Int |
| toString | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">toString</span><span class="kotlin-type"></span>(): String |
| updateMood | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">updateMood</span><span class="kotlin-type"></span>(allGoals: Collection&lt;GoalModel&gt;) |


### HAPPY


HAPPY


### SAD


SAD


### PetMoodAnimations


<span class="kotlin-kw declaration typealias">typealias</span> <span class="kotlin-name typealias">PetMoodAnimations</span><span class="kotlin-type"></span> = Map&lt;PetMood, FrameStateAnimation&gt;


### PetMoodAnimationsFactory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">PetMoodAnimationsFactory</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br>constructor

#### Functions

| Name | Summary |
|---|---|
| create | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">create</span><span class="kotlin-type"></span>(animation: FrameStateAnimation): PetMoodAnimations |


### User

<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">User</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span> = UUID.randomUUID(), <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span>)

User represents a user.

#### Parameters


| Name | Description |
|---|---|
| uuid | the UUID of the user, for global identification |
| pet | the pet of the user |

#### Properties

| Name | Summary |
|---|---|
| pet | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span> |
| uuid | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span> |


### UserEntity

<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">UserEntity</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span> = UUID.randomUUID(), <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">petId</span>: <span class="kotlin-type">Int</span>)

UserEntity represents a user.

#### Parameters


| Name | Description |
|---|---|
| uuid | the UUID of the user, for global identification |
| petId | the pet of the user |

#### Properties

| Name | Summary |
|---|---|
| petId | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">petId</span>: <span class="kotlin-type">Int</span> |
| uuid | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span> |


### EntityModelMapper

<span class="kotlin-kw declaration interface">interface</span> <span class="kotlin-name interface">EntityModelMapper</span><span class="kotlin-type"></span>&lt;E, M&gt;

#### Inheritors

| |
|---|
| GoalMapper |
| UserMapper |

#### Functions

| Name | Summary |
|---|---|
| asEntity | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asEntity</span><span class="kotlin-type"></span>(model: M): E |
| asModel | <span class="kotlin-kw modifier abstract">abstract</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asModel</span><span class="kotlin-type"></span>(entity: E): M |


### GoalMapper


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalMapper</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(statusProvider: GoalStatusProvider, priorityProvider: GoalPriorityProvider, goalModelFactory: GoalModel.Factory)</span> : EntityModelMapper&lt;GoalEntity, GoalModel&gt; 

GoalMapper is a mapper that maps GoalModel to GoalEntity and vice versa. GoalEntity is a RoomEntity, used for storing goals in the database. GoalModel is a model used for creating and displaying goals.

#### Functions

| Name | Summary |
|---|---|
| asEntity | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asEntity</span><span class="kotlin-type"></span>(goal: GoalModel): GoalEntity<br>Maps a GoalModel to a GoalEntity. Every Goal in the Database needs to have a createdAt date. If the goal is a draft, the createdAt date is set to the current date. |
| asModel | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asModel</span><span class="kotlin-type"></span>(entity: GoalEntity): GoalModel |


### UserMapper


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">UserMapper</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(config: HabitHatchConfig)</span> : EntityModelMapper&lt;UserEntity, UserModel&gt;

#### Functions

| Name | Summary |
|---|---|
| asEntity | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asEntity</span><span class="kotlin-type"></span>(model: UserModel): UserEntity |
| asModel | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">asModel</span><span class="kotlin-type"></span>(entity: UserEntity): UserModel |


### ExampleGoalFactory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">ExampleGoalFactory</span><span class="kotlin-type"></span>(priorityProvider: GoalPriorityProvider, statusProvider: GoalStatusProvider, goalModelFactory: GoalModel.Factory)

ExampleGoalFactory is a factory that creates example goals for testing purposes.

#### Functions

| Name | Summary |
|---|---|
| createExampleGoals | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createExampleGoals</span><span class="kotlin-type"></span>(count: Int, userId: UUID, pastYears: Long = 1, uniqueTitles: Boolean = false): Collection&lt;GoalModel&gt; |


### Factory


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Factory</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br>constructor

#### Functions

| Name | Summary |
|---|---|
| createDraft | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createDraft</span><span class="kotlin-type"></span>(userId: UUID, status: GoalModel.Status, priority: GoalModel.Priority, title: String = &quot;&quot;, createdAt: Instant? = null): GoalModel |
| createFromEntity | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createFromEntity</span><span class="kotlin-type"></span>(entity: GoalEntity, status: GoalModel.Status, priority: GoalModel.Priority): GoalModel |


### Importance


<span class="kotlin-kw modifier sealed">sealed</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Importance</span> : <span class="kotlin-type">Comparable</span>&lt;GoalModel.Priority.Importance&gt; 

Importance of the priority.

#### Properties

| Name | Summary |
|---|---|
| value | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">value</span>: <span class="kotlin-type">Int</span> |

#### Functions

| Name | Summary |
|---|---|
| compareTo | <span class="kotlin-kw modifier open">open</span> <span class="kotlin-kw modifier operator">operator</span> <span class="kotlin-kw modifier override">override</span> <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">compareTo</span><span class="kotlin-type"></span>(other: GoalModel.Priority.Importance): Int |


### Status


<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">Status</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">label</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">stepNumber</span>: <span class="kotlin-type">Int</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">isDone</span>: <span class="kotlin-type">Boolean</span> = false)

#### Properties

| Name | Summary |
|---|---|
| isDone | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">isDone</span>: <span class="kotlin-type">Boolean</span> = false |
| label | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">label</span>: <span class="kotlin-type">String</span> |
| stepNumber | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">stepNumber</span>: <span class="kotlin-type">Int</span> |


### UserModel


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">UserModel</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span>)

#### Properties

| Name | Summary |
|---|---|
| pet | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span> |
| uuid | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">uuid</span>: <span class="kotlin-type">UUID</span> |


### GoalRepository


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalRepository</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(goalDao: GoalDao, goalMapper: GoalMapper)</span>

GoalRepository is a repository that provides access to goals in the database.

#### Functions

| Name | Summary |
|---|---|
| deleteAll | suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">deleteAll</span><span class="kotlin-type"></span>()<br>Deletes all goals permanently from the database. |
| getAll | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getAll</span><span class="kotlin-type"></span>(): Flow&lt;List&lt;GoalModel&gt;&gt; |
| insert | suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">insert</span><span class="kotlin-type"></span>(vararg goals: GoalModel)<br>Inserts the given goals into the database. |
| search | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">search</span><span class="kotlin-type"></span>(query: GoalQuery): Flow&lt;List&lt;GoalModel&gt;&gt;<br>Returns a flow of goals that match the given GoalQuery. Sorted by GoalQuery's comparator. |
| update | suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">update</span><span class="kotlin-type"></span>(goal: GoalModel)<br>Updates the given goal in the database. |


### UserRepository


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">UserRepository</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(userDao: UserDao, userMapper: UserMapper)</span>

UserRepository is a repository that provides access to the user in the database. Since there is only one user, the repository provides methods to create, read, update and delete the user.

#### Functions

| Name | Summary |
|---|---|
| createUser | suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createUser</span><span class="kotlin-type"></span>(user: UserModel) |
| deleteUser | suspend <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">deleteUser</span><span class="kotlin-type"></span>()<br>Deletes all(only one) user from the database. There can only be one user in the database. |
| getUser | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getUser</span><span class="kotlin-type"></span>(): Flow&lt;UserModel?&gt; |

---
## Features

The features package in the HabitHatch application contains the core UI and business logic components for distinct application features. Each subpackage corresponds to a feature or screen, encapsulating its state, view, and business logic.

### Purpose
The features package organizes the app into modular and maintainable components, enabling scalable development. Each feature is self-contained, allowing independent development, testing, and future expansion without affecting other parts of the application.

### Key Responsibilities
- **Screen Management** – Defines and manages the UI for specific features or screens.
- **State Management** – Tracks the state and behavior of individual screens, ensuring responsiveness and proper user interaction.
- **ViewModels** – Encapsulates business logic and handles communication between the UI and data layers.
- **User Experience** – Provides cohesive and intuitive interfaces tailored to each feature's purpose.

### Design Philosophy
The features package follows the principles of:
- **Modularity** – Each feature resides in its dedicated subpackage, ensuring separation of concerns.
- **Scalability** – Facilitates the addition of new features by following a consistent architecture pattern.
- **Maintainability** – Clear structure and separation between UI, state, and logic improve code readability and maintenance.
- **Reusability** – Encourages the reuse of ViewModels and state patterns across different features.


### AIAssistantViewModel


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AIAssistantViewModel</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(application: Application)</span> : ViewModel

#### Properties

| Name | Summary |
|---|---|
| isListening | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">isListening</span>: <span class="kotlin-type">StateFlow</span>&lt;Boolean&gt; |
| showPermissionDialog | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showPermissionDialog</span>: <span class="kotlin-type">StateFlow</span>&lt;Boolean&gt; |
| text | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">text</span>: <span class="kotlin-type">StateFlow</span>&lt;String&gt; |

#### Functions

| Name | Summary |
|---|---|
| startListening | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">startListening</span><span class="kotlin-type"></span>() |


### AIScreenState

<span class="kotlin-kw decorator">@Stable</span>

<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AIScreenState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">text</span>: <span class="kotlin-type">String</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">isListening</span>: <span class="kotlin-type">Boolean</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showPermissionDialog</span>: <span class="kotlin-type">Boolean</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onStartListening</span><span class="kotlin-type"></span>: () -&gt; Unit)

Represents the state of the AI screen.

#### Parameters


| Name | Description |
|---|---|
| text | The text to display on the screen. |
| isListening | Whether the AI assistant is currently listening. |
| showPermissionDialog | Whether to show the permission dialog. |
| onStartListening | The callback to start listening. |

#### Properties

| Name | Summary |
|---|---|
| isListening | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">isListening</span>: <span class="kotlin-type">Boolean</span> |
| onStartListening | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onStartListening</span><span class="kotlin-type"></span>: () -&gt; Unit |
| showPermissionDialog | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showPermissionDialog</span>: <span class="kotlin-type">Boolean</span> |
| text | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">text</span>: <span class="kotlin-type">String</span> |


### CoreHomeState

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">CoreHomeState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onFabClicked</span><span class="kotlin-type"></span>: () -&gt; Unit = {})

Represents the main state information for the home screen.

#### Parameters


| Name | Description |
|---|---|
| pet | The pet to display. |
| onFabClicked | The callback for when the Floating Action Button is clicked. |

#### Properties

| Name | Summary |
|---|---|
| onFabClicked | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onFabClicked</span><span class="kotlin-type"></span>: () -&gt; Unit |
| pet | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pet</span>: <span class="kotlin-type">Pet</span> |


### HomeScreenState


<span class="kotlin-kw decorator">@Stable</span>

<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">HomeScreenState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalsViewState</span>: <span class="kotlin-type">GoalsViewState</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalFilterState</span>: <span class="kotlin-type">GoalFilterState</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">core</span>: <span class="kotlin-type">CoreHomeState</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">addGoalDialogState</span>: <span class="kotlin-type">AddGoalDialogState</span> = AddGoalDialogState(), <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalSortState</span>: <span class="kotlin-type">GoalSortState</span> = GoalSortState(emptyList()))

Represents the state of the home screen.

#### Properties

| Name | Summary |
|---|---|
| addGoalDialogState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">addGoalDialogState</span>: <span class="kotlin-type">AddGoalDialogState</span> |
| core | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">core</span>: <span class="kotlin-type">CoreHomeState</span> |
| goalFilterState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalFilterState</span>: <span class="kotlin-type">GoalFilterState</span> |
| goalSortState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalSortState</span>: <span class="kotlin-type">GoalSortState</span> |
| goalsViewState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalsViewState</span>: <span class="kotlin-type">GoalsViewState</span> |


### HomeViewModel


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">HomeViewModel</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(userRepository: UserRepository, goalRepository: GoalRepository, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">config</span>: <span class="kotlin-type">HabitHatchConfig</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalQueryFactory</span>: <span class="kotlin-type">GoalQuery</span>.Factory, goalModelFactory: GoalModel.Factory, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">builderFactory</span>: <span class="kotlin-type">GoalFilterBuilderFactory</span>)</span> : ViewModel

#### Properties

| Name | Summary |
|---|---|
| builderFactory | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">builderFactory</span>: <span class="kotlin-type">GoalFilterBuilderFactory</span> |
| config | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">config</span>: <span class="kotlin-type">HabitHatchConfig</span> |
| goalQuery | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalQuery</span>: <span class="kotlin-type">StateFlow</span>&lt;GoalQuery&gt; |
| goalQueryFactory | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalQueryFactory</span>: <span class="kotlin-type">GoalQuery</span>.Factory |
| hasAnyGoals | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">hasAnyGoals</span>: <span class="kotlin-type">StateFlow</span>&lt;Boolean&gt; |
| queriedGoals | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">queriedGoals</span>: <span class="kotlin-type">StateFlow</span>&lt;List&lt;GoalModel&gt;&gt; |
| user | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">user</span>: <span class="kotlin-type">StateFlow</span>&lt;UserModel?&gt; |

#### Functions

| Name | Summary |
|---|---|
| addGoal | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">addGoal</span><span class="kotlin-type"></span>(goal: GoalModel) |
| seedGoals | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">seedGoals</span><span class="kotlin-type"></span>() |
| toggleGoalStatus | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">toggleGoalStatus</span><span class="kotlin-type"></span>(goal: GoalModel) |
| updateGoalFilter | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">updateGoalFilter</span><span class="kotlin-type"></span>(newGoalFilter: GoalFilter.Builder) |
| updateGoalSortOption | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">updateGoalSortOption</span><span class="kotlin-type"></span>(newGoalSortOption: GoalSortOption) |


### SettingsScreenState


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">SettingsScreenState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onDeleteAccount</span><span class="kotlin-type"></span>: () -&gt; Unit)

Represents the state of the settings screen.

#### Properties

| Name | Summary |
|---|---|
| onDeleteAccount | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onDeleteAccount</span><span class="kotlin-type"></span>: () -&gt; Unit |


### SettingsViewModel


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">SettingsViewModel</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(userRepository: UserRepository, goalRepository: GoalRepository)</span> : ViewModel

SettingsViewModel is a ViewModel that provides the settings screen with the necessary data.

#### Functions

| Name | Summary |
|---|---|
| deleteAccount | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">deleteAccount</span><span class="kotlin-type"></span>() |


### LOADING


LOADING


### NOT_SIGNED_UP


NOT_SIGNED_UP


### SIGNED_UP


SIGNED_UP


### SignupScreenState


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">SignupScreenState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pets</span>: <span class="kotlin-type">List</span>&lt;Pet&gt;, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">signUpState</span>: <span class="kotlin-type">SignUpState</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onPetConfirmed</span><span class="kotlin-type"></span>: (Pet) -&gt; Unit)

Represents the state of the signup screen.

#### Properties

| Name | Summary |
|---|---|
| onPetConfirmed | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onPetConfirmed</span><span class="kotlin-type"></span>: (Pet) -&gt; Unit |
| pets | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pets</span>: <span class="kotlin-type">List</span>&lt;Pet&gt; |
| signUpState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">signUpState</span>: <span class="kotlin-type">SignUpState</span> |


### SignupViewModel


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">SignupViewModel</span><span class="kotlin-type"></span><span class="kotlin-kw decorator">@Inject</span><br><span class="kotlin-kw constructor">constructor</span><span class="kotlin-params constructor">(userRepository: UserRepository, habitHatchConfig: HabitHatchConfig)</span> : ViewModel

#### Properties

| Name | Summary |
|---|---|
| pets | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">pets</span>: <span class="kotlin-type">List</span>&lt;Pet&gt; |
| signUpState | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">signUpState</span>: <span class="kotlin-type">StateFlow</span>&lt;SignUpState&gt; |

#### Functions

| Name | Summary |
|---|---|
| signUpUser | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">signUpUser</span><span class="kotlin-type"></span>(user: UserModel) |

---
## UI

The UI package in the HabitHatch application manages the presentation layer, encompassing reusable components, screens, and feature-specific user interface elements. It ensures consistent, visually appealing, and responsive designs across the application.

### Purpose
The UI package centralizes all visual and interactive components, promoting reusability and consistency. By structuring the package into modular subpackages, the design and behavior of various screens remain organized and easy to maintain.

### Key Responsibilities
- **Reusable Components** – Provides common UI elements such as cards, grids, buttons, and dialog hosts, allowing for a consistent look and feel across the app.
- **Feature-Specific Views** – Manages feature-related UI elements, such as goal views, filters, and sort states.
- **Navigation** – Contains bottom and top navigation bars, enhancing user experience and enabling smooth app transitions.
- **Theming and Styling** – Implements and standardizes styles to maintain a cohesive visual identity.
- **Forms and Inputs** – Manages form components like search fields and buttons to streamline data entry and interaction.

### Design Philosophy
The UI package follows these principles:
- **Component Reusability** – Common UI elements are designed to be reused across multiple screens to ensure consistency and reduce duplication.
- **Separation of Concerns** – Each subpackage manages a specific aspect of the UI, making it easier to develop and maintain individual components.
- **Scalability** – The package is designed to handle new features and components without disrupting existing functionality.
- **User-Centered Design** – Focuses on enhancing the user experience by providing responsive, visually appealing, and intuitive interfaces.



### Common

#### Functions

| Name | Summary |
|---|---|
| ImageBox | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">ImageBox</span><span class="kotlin-type"></span>(imageRes: Int, modifier: Modifier = Modifier, isChecked: Boolean)<br>A box with an image and a checkmark indicator. |
| ImageTextCard | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">ImageTextCard</span><span class="kotlin-type"></span>(modifier: Modifier = Modifier, imageContent: <span class="kotlin-kw decorator">@Composable()</span> -&gt; Unit, text: <span class="kotlin-kw decorator">@Composable()</span> -&gt; Unit, spacing: Dp = 8.dp, onSelected: () -&gt; Unit)<br>A card with an image and text. |
| SelectionGrid | <span class="kotlin-kw decorator">@Composable</span><br>fun &lt;T&gt; SelectionGrid(elements: List&lt;T&gt;, columns: Int = 2, outSidePadding: Dp = 50.dp, spaceBetween: Dp = 30.dp, onConfirm: (T) -&gt; Unit, card: <span class="kotlin-kw decorator">@Composable(T,</span> Boolean, () -&gt; Unit) -&gt; Unit)<br>A grid of elements that can be selected. |


### DialogHost


<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">DialogHost</span><span class="kotlin-type"></span>

A host for dialogs

#### Functions

| Name | Summary |
|---|---|
| createConfirmDialog | <span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">createConfirmDialog</span><span class="kotlin-type"></span>(titleRes: Int, messageRes: Int, confirmButtonRes: Int, dismissButtonRes: Int, onConfirm: () -&gt; Unit)<br>Creates a confirm dialog. |
| Render | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">Render</span><span class="kotlin-type"></span>()<br>Renders the dialog. |


### Forms

#### Functions

| Name | Summary |
|---|---|
| SearchField | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">SearchField</span><span class="kotlin-type"></span>(searchQuery: String, onQueryChange: (String) -&gt; Unit, modifier: Modifier = Modifier, shape: CornerBasedShape = MaterialTheme.shapes.large, textStyle: TextStyle = MaterialTheme.typography.bodySmall)<br>A search field that allows the user to input a search query. |
| SearchFieldPreview | <span class="kotlin-kw decorator">@Preview(showBackground</span> = true)<br><span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">SearchFieldPreview</span><span class="kotlin-type"></span>() |
| SimpleIconButton | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">SimpleIconButton</span><span class="kotlin-type"></span>(modifier: Modifier = Modifier.size(36.dp), labelRes: Int, color: Color, painter: Painter, onClick: () -&gt; Unit)<br>A simple icon button with a label. |


### AddGoalDialogState


<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">AddGoalDialogState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showDialog</span>: <span class="kotlin-type">Boolean</span> = false, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goal</span>: <span class="kotlin-type">GoalModel</span>? = null, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">allPriorities</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Priority&gt; = emptySet(), <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onAddGoal</span><span class="kotlin-type"></span>: (GoalModel) -&gt; Unit = {}, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onDismiss</span><span class="kotlin-type"></span>: () -&gt; Unit = {})

#### Properties

| Name | Summary |
|---|---|
| allPriorities | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">allPriorities</span>: <span class="kotlin-type">Set</span>&lt;GoalModel.Priority&gt; |
| goal | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goal</span>: <span class="kotlin-type">GoalModel</span>? = null |
| onAddGoal | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onAddGoal</span><span class="kotlin-type"></span>: (GoalModel) -&gt; Unit |
| onDismiss | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onDismiss</span><span class="kotlin-type"></span>: () -&gt; Unit |
| showDialog | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showDialog</span>: <span class="kotlin-type">Boolean</span> = false |


### GoalFilterState

<span class="kotlin-kw decorator">@Stable</span>

<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalFilterState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalFilterBuilder</span>: <span class="kotlin-type">GoalFilter</span>.Builder, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onGoalFilterChange</span><span class="kotlin-type"></span>: (GoalFilter.Builder) -&gt; Unit = {})

The state of the goal filter.

#### Parameters


| Name | Description |
|---|---|
| goalFilterBuilder | The builder of the goal filter. |
| onGoalFilterChange | The action to be performed when the goal filter changes. |

#### Properties

| Name | Summary |
|---|---|
| goalFilterBuilder | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goalFilterBuilder</span>: <span class="kotlin-type">GoalFilter</span>.Builder |
| onGoalFilterChange | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onGoalFilterChange</span><span class="kotlin-type"></span>: (GoalFilter.Builder) -&gt; Unit |


### GoalSortState

<span class="kotlin-kw decorator">@Stable</span>

<span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalSortState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">sortOptions</span>: <span class="kotlin-type">List</span>&lt;GoalSortOption&gt;, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onSortOptionChange</span><span class="kotlin-type"></span>: (GoalSortOption) -&gt; Unit = { })

The state of the goal sort.

#### Parameters


| Name | Description |
|---|---|
| sortOptions | The list of sort options. |
| onSortOptionChange | The action to be performed when the sort option changes. |

#### Properties

| Name | Summary |
|---|---|
| onSortOptionChange | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onSortOptionChange</span><span class="kotlin-type"></span>: (GoalSortOption) -&gt; Unit |
| sortOptions | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">sortOptions</span>: <span class="kotlin-type">List</span>&lt;GoalSortOption&gt; |


### GoalStyleProvider


<span class="kotlin-kw declaration object">object</span> <span class="kotlin-name object">GoalStyleProvider</span><span class="kotlin-type"></span>

The provider of the style of a goal.

#### Functions

| Name | Summary |
|---|---|
| getGoalStyle | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getGoalStyle</span><span class="kotlin-type"></span>(goal: GoalModel): GoalStyle |


### GoalsViewState

<span class="kotlin-kw decorator">@Immutable</span>

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalsViewState</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goals</span>: <span class="kotlin-type">List</span>&lt;GoalModel&gt;, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showCreateExampleGoals</span>: <span class="kotlin-type">Boolean</span> = true, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onCreateExampleGoals</span><span class="kotlin-type"></span>: () -&gt; Unit = {}, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onToggleGoalStatus</span><span class="kotlin-type"></span>: (GoalModel) -&gt; Unit = {})

The state of the goals view.

#### Parameters


| Name | Description |
|---|---|
| goals | The list of goals. |
| showCreateExampleGoals | Whether to show the create example goals button. |
| onCreateExampleGoals | The action to be performed when the create example goals button is clicked. |
| onToggleGoalStatus | The action to be performed when the goal status is toggled. |

#### Properties

| Name | Summary |
|---|---|
| goals | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">goals</span>: <span class="kotlin-type">List</span>&lt;GoalModel&gt; |
| onCreateExampleGoals | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onCreateExampleGoals</span><span class="kotlin-type"></span>: () -&gt; Unit |
| onToggleGoalStatus | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">onToggleGoalStatus</span><span class="kotlin-type"></span>: (GoalModel) -&gt; Unit |
| showCreateExampleGoals | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">showCreateExampleGoals</span>: <span class="kotlin-type">Boolean</span> = true |


### GoalStyle

<span class="kotlin-kw modifier data">data</span> <span class="kotlin-kw declaration class">class</span> <span class="kotlin-name class">GoalStyle</span><span class="kotlin-type"></span>(<span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">borderColor</span>: <span class="kotlin-type">Color</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">containerColor</span>: <span class="kotlin-type">Color</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">textDecoration</span>: <span class="kotlin-type">TextDecoration</span> = TextDecoration.None, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">iconColor</span>: <span class="kotlin-type">Color</span>, <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">cardShape</span>: <span class="kotlin-type">CornerBasedShape</span>)

The style of a goal.

#### Parameters


| Name | Description |
|---|---|
| borderColor | The color of the border. |
| containerColor | The color of the container. |
| textDecoration | The text decoration. |
| iconColor | The color of the icon. |
| cardShape | The shape of the card. |

#### Properties

| Name | Summary |
|---|---|
| borderColor | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">borderColor</span>: <span class="kotlin-type">Color</span> |
| cardColors | <span class="kotlin-kw decorator">@get:Composable</span><br><span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">cardColors</span>: <span class="kotlin-type">CardColors</span> |
| cardShape | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">cardShape</span>: <span class="kotlin-type">CornerBasedShape</span> |
| containerColor | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">containerColor</span>: <span class="kotlin-type">Color</span> |
| iconColor | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">iconColor</span>: <span class="kotlin-type">Color</span> |
| textColor | <span class="kotlin-kw decorator">@get:Composable</span><br><span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">textColor</span>: <span class="kotlin-type">Color</span> |
| textDecoration | <span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">textDecoration</span>: <span class="kotlin-type">TextDecoration</span> |
| textStyle | <span class="kotlin-kw decorator">@get:Composable</span><br><span class="kotlin-kw declaration val">val</span> <span class="kotlin-name val">textStyle</span>: <span class="kotlin-type">TextStyle</span> |


### Table

#### Functions

| Name | Summary |
|---|---|
| getDoneColor | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">getDoneColor</span><span class="kotlin-type"></span>(isDoneStatusVisible: Boolean): Color |
| GoalFilterBar | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">GoalFilterBar</span><span class="kotlin-type"></span>(state: GoalFilterState, modifier: Modifier = Modifier)<br>A bar that contains a search field and a button to toggle the visibility of done goals. |
| GoalQueryTable | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">GoalQueryTable</span><span class="kotlin-type"></span>(modifier: Modifier = Modifier, filterContent: <span class="kotlin-kw decorator">@Composable(defaultModifier:</span> Modifier) -&gt; Unit, sortContent: <span class="kotlin-kw decorator">@Composable(defaultModifier:</span> Modifier) -&gt; Unit, goalsContent: <span class="kotlin-kw decorator">@Composable()</span> -&gt; Unit)<br>A table that displays a list of goals. With filter and sort options. |
| GoalSortBar | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">GoalSortBar</span><span class="kotlin-type"></span>(modifier: Modifier = Modifier, state: GoalSortState)<br>A bar that displays sort options for goals. |


### Navigation

#### Functions

| Name | Summary |
|---|---|
| BottomNavBar | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">BottomNavBar</span><span class="kotlin-type"></span>(navigationItems: List&lt;Screen&gt;, activeNavScreen: Screen? = null, onNavigationItemClicked: (Screen) -&gt; Unit = {})<br>A bottom navigation bar that displays the navigation items. |
| BottomNavigationBarPreview | <span class="kotlin-kw decorator">@Preview</span><br><span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">BottomNavigationBarPreview</span><span class="kotlin-type"></span>() |
| NavItem | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">NavItem</span><span class="kotlin-type"></span>(modifier: Modifier = Modifier.size(24.dp), navScreen: Screen, iconColor: Color, onClick: () -&gt; Unit = {})<br>A navigation item that displays an icon. |
| TopAppInformationBarPreview | <span class="kotlin-kw decorator">@Preview</span><br><span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">TopAppInformationBarPreview</span><span class="kotlin-type"></span>() |
| TopNavBar | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">TopNavBar</span><span class="kotlin-type"></span>(title: String, modifier: Modifier = Modifier, rightNavItem: Screen? = null, leftNavItem: Screen? = null, onRightNavItemClicked: () -&gt; Unit = {}, onLeftNavItemClicked: () -&gt; Unit = {})<br>A top navigation bar that displays the title and navigation items. |


### Pets

#### Functions

| Name | Summary |
|---|---|
| PetAnimation | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">PetAnimation</span><span class="kotlin-type"></span>(pet: Pet, modifier: Modifier = Modifier)<br>A pet animation that displays a pet. |
| PetAnimationPreview | <span class="kotlin-kw decorator">@Preview(showBackground</span> = true)<br><span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">PetAnimationPreview</span><span class="kotlin-type"></span>() |


### Settings

#### Functions

| Name | Summary |
|---|---|
| AccountSettings | <span class="kotlin-kw decorator">@Composable</span><br><span class="kotlin-kw declaration fun">fun</span> <span class="kotlin-name fun">AccountSettings</span><span class="kotlin-type"></span>(onOpenDeleteAccountDialog: () -&gt; Unit)<br>A view that displays account settings. |

---
