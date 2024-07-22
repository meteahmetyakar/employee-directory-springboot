## Overview

This is a Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations with Spring Data JPA. The project also utilizes Aspect-Oriented Programming (AOP) for transaction, logging and auditing, shutdown situations and includes scheduled tasks. This application serves as a sample employee directory with basic functionalities.

## Features

- **Employee Management**: Add, update, view, and delete employee records.
- **Logging and Auditing**: Uses AOP for logging method calls and auditing changes.
- **Scheduled Tasks**: Includes example scheduled tasks for periodic operations.
- **Web Interface**: Simple web UI to manage employees, built using Thymeleaf for dynamic content rendering.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**: Daily log saves to database with scheduling mechanism.
- **Aspect-Oriented Programming (AOP)** : Allows the separation of cross-cutting concerns of transaction, logging, auditing.
- **Thymeleaf**: Renders dynamic web pages for an interactive user experience.
- **H2 Database**: Instant logs save to in-memory database.
