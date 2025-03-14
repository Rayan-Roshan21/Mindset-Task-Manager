# Mindset - Task Management Application

## Overview
Mindset is a Java-based task management application that allows users to organize their personal and work-related tasks efficiently. Users can categorize tasks, assign priorities, mark them as completed, and remove them as needed.

## Features
- Add personal and work-related tasks.
- Remove tasks from the list.
- View all added tasks.
- Categorize personal tasks into:
  - Mental health
  - House chores
  - Studying
  - Other
- Categorize work tasks into:
  - Work on project
  - Working meetings
  - Work sessions
  - Other
- Set priorities for work tasks.
- Mark tasks as completed.

## Project Structure
This project consists of the following classes:

### 1. `Task.java`
- Parent class for all tasks.
- Attributes: `type`, `description`, `isCompleted`.
- Methods:
  - Getters and setters for attributes.
  - Overridden `toString()` and `equals()` methods.

### 2. `PersonalTasks.java`
- Subclass of `Task` for managing personal tasks.
- Attributes: `typeChoice`, `isCompleted`.
- Methods:
  - `completeTask()`: Marks the task as completed.
  - Overridden `toString()` for task details.
  - Overridden `equals()` for accurate comparisons.

### 3. `workTasks.java`
- Subclass of `Task`, implements `Comparable<workTasks>`.
- Attributes: `typeChoice`, `priorityChoice`, `isCompleted`.
- Methods:
  - `completeTask()`: Marks the task as completed.
  - Overridden `toString()` for task details.
  - Overridden `compareTo()` for sorting tasks by priority.
  - Overridden `equals()` for accurate comparisons.

### 4. `TaskManager.java`
- Manages all tasks in `ArrayList` collections.
- Methods:
  - `addPersonalTask()`, `addWorkTask()` to add tasks.
  - `removePersonalTask()`, `removeWorkTask()` to remove tasks.
  - `completePersonalTask()`, `completeWorkTask()` to mark tasks as done.
  - `displayPersonalTasks()`, `displayWorkTasks()` to view tasks.

### 5. `ProjectOneTester.java`
- Main class for running the program.
- Implements user interaction through a menu-driven console interface.
- Uses `Scanner` for user input to add, remove, and display tasks.

## How to Run
1. Ensure you have Java installed on your system.
2. Compile all Java files using:
   ```sh
   javac *.java
   ```
3. Run the main program:
   ```sh
   java ProjectOneTester
   ```
4. Follow the on-screen prompts to interact with the application.

## Future Enhancements
- Implement a GUI for better user experience.
- Save tasks persistently using a database or file system.
- Add task deadlines and reminders.

## Author
**Rayan Roshan**  
- CPS209 Project - Toronto Metropolitan University

## License
This project is for educational purposes only. Unauthorized distribution or plagiarism is strictly prohibited as per university policies.
