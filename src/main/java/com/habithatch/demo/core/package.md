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


