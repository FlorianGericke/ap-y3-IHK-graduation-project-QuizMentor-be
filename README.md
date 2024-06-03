# QuizMentor

## Description

QuizMentor is a quiz management system developed using Java and Spring Boot. It provides a platform
for users to create, manage, and participate in quizzes.

## Key Features

- Quiz Creation & Management: Users can create quizzes with a variety of questions. The system
  allows for updating and deleting quizzes as needed.

- User Management: The system supports multiple user roles, including trainee, trainer, and mentor,
  each with different access levels.

- Scoring & Solution Evaluation: Each quiz submission is evaluated automatically, and scores are
  assigned based on the correctness of the answers.

- Security: The application is secure with authentication and authorization mechanisms in place.

## Technologies Used

- Java:  The backend of the application is written in Java.

- Spring Boot: This project uses Spring Boot, which simplifies the setup of Spring applications.

- Gradle: Gradle is used as the build tool for this project. It helps in managing dependencies,
  compiling the source code, running tests, and packaging the application.

- JUnit: The project uses JUnit for unit testing to ensure the correctness of the code.

- Mockito: Mockito is used for creating mock objects in unit tests.

- Docker: Docker is used for setting up and managing the database for the application.

## Requirements

- Java 21
- Docker or Rancher Desktop
- Gradle

## Usage

To start the application, use the following command:

```bash
    make startEnv
```

To run the tests, use the following command:

```bash
    make test 
```

To lint all the files, use the following command:

```bash
    make lint-all 
```

To lint the changed files, use the following command:

```bash
    make lint
```
