# HabitHatch


## Features:
1. **Selection at Start:**
    - Choose an animal at the beginning.
    - Four animals are displayed, but only one can be selected.

2. **Activity Transition:**
    - Transition from the start screen to the home screen.

3. **Goals Table/List:**
    - Display a table or list of goals.
    - Allow sorting by:
        - Completed status
        - Deadline
        - Priority

4. **Add Goals:**
    - Users can add new goals.

5. **Mark Goals as Completed:**
    - Users can mark goals as done.

6. **Voice Control for Adding Goals:**
    - Add goals using voice commands.

7. **Animal Animation:**
    - Show an animated video of the selected animal.
    - Animation consists of 4 alternating frames.

8. **Animal Mood Based on Goals:**
    - **Happy Animal:**
        - When all goals are completed, the animal is happy.
        - The animation video has a bright color filter.
    - **Unhappy Animal:**
        - When not all goals are completed, the animal is unhappy.
        - The animation video has a darker color filter.

9. **User Settings:**
    - Provide a section to display user settings.


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

