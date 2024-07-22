## Overview

This spring boot project is a sample employee directory with CRUD functionalities. In this project, Spring Data JPA is used for CRUD functionalities and Spring AOP is used keep track of transaction, auditing, scheduled logging, and shutdown situations.  

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
