# 📚 LearnTrack - Student & Course Management System

## Overview

LearnTrack is a application developed using **Core Java** that helps manage students, courses, and course enrollments within a simple academic environment.

The primary objective of this project is to strengthen the understanding of Core Java by implementing real-world programming concepts such as object-oriented programming, collections, exception handling, package organization, and modular application design.

The application stores data in memory using Java Collections and provides an interactive menu-driven interface for administrators to perform common management operations.

---

## Features

### Student Management

- Register new students
- View all registered students
- Search students using their ID
- Update student details
- Deactivate students without removing records

### Course Management

- Create new courses
- Display available courses
- Modify course information
- Activate or deactivate courses

### Enrollment Management

- Enroll students into courses
- Display enrollments for a specific student
- Update enrollment status
- Cancel existing enrollments

---

## Project Structure

```
learntrack
│
├── entity
│   ├── Person.java
│   ├── Student.java
│   ├── Course.java
│   └── Enrollment.java
│
├── service
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── exception
│   ├── EntityNotFoundException.java
│   └── InvalidInputException.java
│
├── util
│   ├── IdGenerator.java
│   └── InputValidator.java
│
├── ui
│   └── Main.java
│
├── docs
│   ├── Setup_Instructions.md
│   ├── JVM_Basics.md
│   └── Design_Notes.md
│
└── README.md
```

---

## Technologies Used

- Java (JDK)
- Core Java
- Java Collections Framework
- Object-Oriented Programming
- Command Line Interface (CLI)

---

## Concepts Demonstrated

### Java Fundamentals

- Variables and Data Types
- Operators
- Conditional Statements
- Loops
- Methods
- Packages
- Classes and Objects

### Object-Oriented Programming

- Encapsulation
- Inheritance
- Polymorphism
- Constructor Overloading
- Method Overriding

### Collections

- Managing dynamic data using `ArrayList`
- Performing CRUD operations on objects

### Exception Handling

- Handling invalid user input
- Creating and using custom exceptions
- Preventing unexpected application crashes

### Static Members

- Static variables
- Static methods
- Utility classes for shared functionality

---

## Application Modules

### Student Module

Responsible for managing student records, including registration, updates, searching, and deactivation.

### Course Module

Handles creation, modification, and maintenance of course information.

### Enrollment Module

Maintains the relationship between students and courses by recording enrollments and their status.

---

## Utility Components

### ID Generator

Automatically generates unique identifiers for students, courses, and enrollments using static counters.

### Input Validator

Performs basic validation on user input before processing requests.

---

## Exception Handling

The project includes custom exception classes to improve error handling.

Examples include:

- EntityNotFoundException
- InvalidInputException

These exceptions provide meaningful messages instead of allowing the application to terminate unexpectedly.

---

## How to Run the Project

### Clone the Repository

```bash
git clone https://github.com/your-username/learntrack.git
```

### Open the Project

Import the project into any Java IDE such as:

- IntelliJ IDEA
- Eclipse
- VS Code

### Compile

```bash
javac Main.java
```

### Execute

```bash
java Main
```

Alternatively, run the `Main` class directly from your IDE.

---

## Documentation

The `docs` folder contains supporting documentation for the project:

- **Setup_Instructions.md** – Java installation and project setup
- **JVM_Basics.md** – Introduction to JDK, JRE, JVM, and bytecode
- **Design_Notes.md** – Design decisions and implementation details

---

## Skills Gained

By completing this project, learners will gain practical experience in:

- Core Java Programming
- Object-Oriented Design
- Collection Framework
- Exception Handling
- Console Application Development
- Code Organization
- Modular Programming
- Clean Coding Practices

---

## Possible Future Improvements

This project can be extended with additional features such as:

- Database Integration (MySQL)
- File Persistence
- Spring Boot REST APIs
- Authentication and Authorization
- Logging Frameworks
- Unit Testing
- Maven Build Support
- Docker Containerization
- Java Streams
- Multithreading
- Graphical or Web-Based User Interface

---

## Purpose

LearnTrack is intended as a learning project for developers who are beginning their journey with Core Java. Rather than focusing on advanced frameworks, it emphasizes writing clean, modular, and maintainable Java code while building a practical console application.
