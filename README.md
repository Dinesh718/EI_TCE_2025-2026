# EI Coding Exercise 2025-26

## 🚀 Completed Exercises

### Exercise 1: Design Patterns
Implemented 6 design patterns demonstrating different categories:

#### Behavioural Patterns
1. **Observer Pattern** - Task notification system with multiple observers
2. **Strategy Pattern** - Different sorting strategies for products

#### Creational Patterns  
3. **Factory Method Pattern** - Flexible notification object creation
4. **Singleton Pattern** - Single configuration manager instance

#### Structural Patterns
5. **Adapter Pattern** - Legacy printer compatibility layer
6. **Decorator Pattern** - Dynamic coffee customization system

### Exercise 2: Astronaut Daily Schedule Organizer
A console-based application for managing astronaut tasks with:
- Add, view, and remove tasks
- Time overlap validation
- Priority-based task management
- Factory pattern for task creation
- Singleton pattern for schedule management

## 🏃 How to Run

### Prerequisites
- Java 11 or higher

### Compile and Run
```bash
# Compile all code
javac -d build/classes src/main/java/astronautscheduler/*.java src/main/java/designpatterns/**/*.java

# Run Astronaut Scheduler
java -cp build/classes astronautscheduler.Main

# Run individual pattern demos
java -cp build/classes designpatterns.behavioural.ObserverDemo
java -cp build/classes designpatterns.behavioural.StrategyDemo
java -cp build/classes designpatterns.creational.FactoryDemo
java -cp build/classes designpatterns.creational.SingletonDemo
java -cp build/classes designpatterns.structural.AdapterDemo
java -cp build/classes designpatterns.structural.DecoratorDemo
