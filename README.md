## Tourist Application Backend

A sophisticated backend system for museum database and tourist group management, featuring real-time event notifications between museums and tour guides. Built with Java using enterprise design patterns.

### 📑 Table of Contents 

- [Core Features](#-core-features)
- [Getting Started](#-getting-started)
- [Architecture & Implementation](#%EF%B8%8F-architecture--implementation)
- [Contributing](#-contributing)

### ✨ Core Features

#### Museum Management

- Dynamic museum entity creation and management
- Location-based museum organisation
- Real-time event notifications system
- Comprehensive museum data handling

#### Tourist Group Management

- Dynamic group creation and modification
- Professional guide assignment
- Member management with capacity controls
- Visit scheduling and coordination

### 🚀 Getting Started

#### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Gradle build tool

#### Installation

1. Clone the repository
2. Install Gradle if not already installed:
   - Download from [Gradle's official website](https://gradle.org/install/)
3. Build the project:
   ```bash
   gradle build
   ```

#### Testing

Our testing suite covers key functionality:

- Museum operations validation
- Group management scenarios
- Event notification testing  
- Exception handling verification

To run tests:

```bash
gradle test
```
> [!IMPORTANT]
> Run tests through IntelliJ's sidebar instead of terminal for better visibility

> [!TIP]
> IDE Integration
> IntelliJ IDEA users can leverage the included Gradle Wrapper (`gradle/wrapper`) for seamless integration:
- Automatic project recognition
- Direct access to Gradle tasks via sidebar
- No additional plugin requirements

### 🏗️ Architecture & Implementation

#### Design Patterns

###### 1. Singleton Pattern
Used for the `Database` class to ensure a single source of truth:
- Prevents data inconsistency
- Provides centralized data access

###### 2. Builder Pattern
Implemented for the `Group` class:
- Enables flexible object construction
- Supports optional parameters
- Implements method chaining
- Improves code readability

###### 3. Factory Pattern
Handles `Person` object creation:
- Creates `Student` and `Professor` instances dynamically
- Centralizes object creation logic
- Supports extensibility for new person types

###### 4. Command Pattern
Manages operations through dedicated command classes:
- Separates command invocation from execution
- Supports operation queuing
- Enables easy addition of new commands

###### 5. Observer Pattern
Implements event notification system:
- Museums (`Subject`) notify groups guide (`Observer`)
- Real-time updates for schedule changes
- Decoupled communication between entities

#### OOP Principles

###### Core Principles Implementation
- **Encapsulation**: Private fields with public accessors
- **Inheritance**: Base `Person` class with specialized extensions
- **Polymorphism**: Dynamic object behavior through Factory Pattern
- **Abstraction**: Abstract classes and interfaces for clear separation

#### Error Handling

**Custom exceptions** for robust operation:
```java
GroupNotExistsException
GroupThresholdException
GuideExistsException
GuideTypeException
PersonNotExistsException
```

#### Data Processing

- CSV-like file processing ('|' delimiter)
- Multiple input format support
- Command-based operation
- Standardized output formatting

### 🤝 Contributing

If you find any **bugs** or have **suggestions**:

1. Fork the repo and create a separate branch
2. Ensure your contribution follows the OOP principles outlined
3. Document any design pattern modifications
4. Follow the existing code style and naming conventions
5. Submit changes that maintain test compatibility
6. Push the changes and create a pull request

### 📜 Licence
This project is licensed under the MIT Licence. See the [LICENCE](./LICENSE) file for further details.
