# HabitHatch

## Requirements

### Original

**was wir entwickeln?!**

- Beim Start Auswahl von Tier, 4 werden angezeigt, aber nur 1 kann ausgewählt werden
- Aktivity Wechsel von Start zu Home
- Tabelle/Liste an Zielen
- Tabelle sortieren nach erledigt und Deadline oder Prio
- Ziel hinzufügen
- Ziel als erledigt markieren
- Ziel mit Sprachsteuerung einfügen
- Animation von einem Tier anzeigen, indem ein Video angezeigt wird; Besteht aus 4 wechselnden Frames
- Wenn alle Ziele erledigt ist Tier glücklich, das Video bekommt einen hellen Farb filter
- Wenn nicht alle Ziele erledigt dunkler Farbfilter, Tier ist unglücklich
- User Settings anzeigen

---

Sortieren oder Filtern?

Sortieren nach erledigt und Deadline oder Prio
und Filtern nach erledigt und Prio

### Startbildschirm

#### Tierauswahl

| **Funktion**            | **Beschreibung**                                                                     |
|-------------------------|--------------------------------------------------------------------------------------|
| **Tier auswählen**      | 4 Tiere stehen zur Auswahl, jedoch kann nur eines ausgewählt werden.                 |
| **Automatisches Login** | Nach der Auswahl eines Tiers ist man angemeldet und wird bei jedem Start eingeloggt. |

- Es gibt **keine Authentifizierung** oder Registrierung.  
  Die App ist für einen einzigen Benutzer und alle Daten werden nur lokal gespeichert.

---

### Navigation

#### Wechsel zwischen Activities

- Wechsel von der Android Hauptaktivität zu einer anderen Android Aktivität und wieder zurück.  
  **Hinweis:** Diese Funktion hat keine Auswirkung und dient nur dazu, die Anforderung zu erfüllen.

> Android recommend only using one Activity and to use Jetpack Navigation instead.
  https://developer.android.com/topic/architecture/recommendations
---

### Habits


| **Eigenschaft** | **Beschreibung**                      |
|-----------------|---------------------------------------|
| **Titel**       | Der Name des Habits.                  |
| **Priorität**   | Die Wichtigkeit: Normal oder Hoch.    |
| **Status**      | Ob der Habit erledigt ist oder nicht. |


1. **Filtern nach:**
    - Status (erledigt/nicht erledigt).
    - Priorität (Normal oder Hoch).

2. **Neuen Habit erstellen:**
    - Eingabe des Titels und der Priorität.
    - Der Status ist standardmäßig **nicht erledigt**.

3. **Status ändern:**
    - Ein Habit kann durch Klicken auf eine Checkbox als **erledigt** markiert werden.

---

### Animation und Tierzustand

#### Animation

- Darstellung einer Animation (Video) des Tiers, bestehend aus **4 wechselnden Frames**.
- Die Animation wird auf der **Home-Seite** angezeigt.

#### Tierzustand basierend auf Habits

| **Zustand**     | **Beschreibung**                                                                                               |
|-----------------|----------------------------------------------------------------------------------------------------------------|
| **Glücklich**   | Wenn alle Habits erledigt sind: Das Tier wird glücklich, und das Video erhält einen hellen Farbfilter.         |
| **Unglücklich** | Wenn nicht alle Habits erledigt sind: Das Tier bleibt unglücklich, und das Video hat einen dunklen Farbfilter. |

---

### User Settings

#### Anzeige

- **Settings-Seite:**
    - Die User Settings werden angezeigt.
    - **Keine Funktionalitäten vorhanden.**

---

### Entfernte Funktionen

- Die Funktion **"Ziel mit Sprachsteuerung einfügen"** wurde entfernt.

---
## Tech Stack

- **Kotlin Version**: 2.1.0
- **Min Android SDK**: 34

### Jetpack Compose:

- material3: version 1.3.2

### Room Database:

### Unit Testing:

- junit: 4.13.2
- truth: 1.1.6`

### Android Testing:

- androidx.test.ext:junit: 1.2.1
- espresso-core: 3.6.1
- compose.ui:ui-test-junit4: 1.7.6

## Architecture:

![](docs/class_diagram.png)

## Activities / Navigation

Android recommend only using one Activity, to use Jetpack Navigation instead.
https://developer.android.com/topic/architecture/recommendations

# HabitHatch - Android App Documentation

## Overview

**HabitHatch** is an Android application designed to help users track their goals while incorporating personalized pets
for a more engaging experience. Built using **Kotlin**, **Jetpack Compose**, **Dagger-Hilt** for dependency injection,
and **Room** for local data storage, the app includes key features such as:

- **Goal Management**: Users can add, track, and filter goals.
- **Pet Selection**: Users choose a pet during signup for personalization.
- **Settings**: Users can manage account preferences.
- **Navigation**: A bottom navigation bar for quick access to different screens like Home, Goals, and Settings.

The app uses **MVVM architecture**, ensuring maintainability and scalability. The **Jetpack Compose** UI framework
allows for a more declarative UI, while **Room** provides local database persistence, and **Dagger-Hilt** simplifies
dependency injection.

---

## Code Breakdown

### 1. **Navigation**

- **`BottomNavigationBar`**: A composable that displays a bottom app bar with icons representing different screens like
  Home, Goals, and Settings.
    - It uses **IconButton** to allow users to select navigation items.
    - The icons change color based on whether the item is selected or enabled.
    - Navigation items are passed from the configuration class (`HabitHatchDevConfig`).

- **`AppNavigation`**: A navigation controller using **NavController**, with conditional navigation based on the user’s
  sign-up status.
    - **`NavHost`** manages the navigation graph.
    - `composable` blocks define each screen (Home, Settings).
    - If the user is not signed up, they are directed to the **InitialLoginScreen**.

---

### 2. **Home Screen**

- **`HomeScreen`**: Displays the user's goals, a floating action button to add goals, and the user’s selected pet.
    - **`FloatingActionButton`** allows adding a new goal.
    - **`PetAnimation`** shows an animated pet, personalized based on the user's choice during signup.
    - **`GoalListScreen`** displays all goals, with the ability to toggle the goal’s completion state.
    - **`BottomNavigationBar`** is used to navigate between screens.

- **ViewModel (`HomeViewModel`)**: Handles user data, filtered goals, and navigation items.
    - It combines the current search query, goal visibility settings, and other filters to manage the goals that are
      displayed.
    - It observes the user’s data and updates the UI accordingly.

---

### 3. **Goal Management**

- **`GoalFilterBar`**: Allows filtering goals by their done state and priority.
    - Includes checkboxes for each **GoalDoneState** (Done/Undone) and **GoalPriority** (Normal/High).
    - **`OutlinedTextField`** is used for filtering goals by search query.

- **`GoalItem`**: A single goal display with a checkbox to mark it as done.
    - Uses **Card** for visual representation, and the goal’s title is styled with a line-through effect if marked as
      done.

- **`GoalList`**: Displays all goals in a **LazyColumn**.
    - It observes the **filteredGoals** flow to show the correct list based on the user’s settings.

- **`AddGoalDialog`**: A dialog for adding new goals.
    - Includes a text field for the goal title and buttons to confirm or cancel the action.

---

### 4. **User & Pet Management**

- **`UserRepository`**: Manages user data (like user creation, fetching, and deletion) using the **UserDao**.
    - Throws custom exceptions if a user already exists or if the user ID format is invalid.

- **`SignupViewModel`**: Handles the user sign-up process and stores the user's pet.
    - Observes the user’s sign-up status and updates the UI.
    - Allows the user to select a pet, which is saved to the **User** entity in the database.

- **`PetCard`**: A composable to display a pet's image and name with a selectable checkbox.
    - Animated indicator shows if a pet is selected during the sign-up process.

---

### 5. **Settings**

- **`SettingsScreen`**: Displays settings options such as account deletion and navigation to the home screen.
    - A button is provided to delete the user's account using **UserRepository**.

---

### 6. **Database Layer**

- **`AppDatabase`**: The main Room database class that manages entities like **Goal** and **User**.
    - Provides DAOs for accessing and manipulating data.

- **`GoalDao` and `UserDao`**: Define queries to fetch and modify goals and user data in the database.
    - **GoalDao** includes queries for getting goals by ID, inserting, and updating goals.
    - **UserDao** includes queries for managing user data.

- **Converters**: Type converters for **GoalPriority** and **GoalDoneState** enums to store them as strings in the
  database.

---

### 7. **Dependency Injection (DI)**

- **Dagger-Hilt** is used for dependency injection across the app:
    - **`AppModule`** provides singleton instances of configuration, database, DAOs, and repositories.
    - **`HabitHatchApp`** is the entry point for the app, and **`MainActivity`** sets up the UI with **Jetpack Compose
      **.

---

## Conclusion

The **HabitHatch** app is structured to be modular, with clear separation between UI, business logic, and data
management. The use of **MVVM** ensures maintainability, while **Room** provides a simple yet effective solution for
local data storage. The integration of **Dagger-Hilt** for dependency injection simplifies component management and
improves testability. The app’s user experience is personalized through pet selection and goal management, making it
both functional and engaging.

