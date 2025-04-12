# AutoSaveAPI - Online Test Platform Auto-Save System

## Project Overview

AutoSaveAPI is a RESTful service designed to automatically save student responses during online tests. The system captures and persists test responses every 30 seconds, ensuring that student progress is continuously saved throughout an exam session.

## Features

- **Automatic Saving**: Captures student responses at regular intervals (30 seconds)
- **Response Management**: Handles new responses and updates existing ones
- **Answer Status Tracking**: Supports marking questions as attempted, skipped, or flagged for review
- **Response Timestamps**: Records when each response was saved

## Tech Stack

- **Backend Framework**: Spring Boot (Java)
- **Database**: PostgreSQL
- **Build Tool**: Maven
  
## Architecture

The project follows a layered architecture pattern:

```
Controller Layer → Service Layer → Repository Layer → Database
```

![Architecture Diagram](https://github.com/luckygarg1810/AutoSaveAPI/blob/master/AutoSaveAPI_Architecture.png)

## Project Structure

```
AutoSaveAPI/
├── src/main/java/
│   └── com.Intellivort.AutoSaveAPI/
│       ├── AutoSaveApiApplication.java
│       ├── Controllers/
│       │   ├── AutoSaveController.java
│       │   ├── QuestionController.java
│       │   ├── StudentController.java
│       │   └── TestController.java
│       ├── DTO/
│       │   ├── AutoSaveRequest.java
│       │   ├── CreateQuestionRequest.java
│       │   ├── StudentDTO.java
│       │   ├── StudentResponseDTO.java
│       │   └── TestDTO.java
│       ├── Entities/
│       │   ├── AnswerStatus.java
│       │   ├── Question.java
│       │   ├── Student.java
│       │   ├── StudentAnswer.java
│       │   └── Test.java
│       ├── Repository/
│       │   ├── QuestionRepository.java
│       │   ├── StudentAnswerRepository.java
│       │   ├── StudentRepository.java
│       │   └── TestRepository.java
│       └── Service/
│           ├── AutoSaveService.java
│           ├── StudentService.java
│           └── TestService.java
```

## API Endpoints

### Main Auto-Save Endpoint

```
POST /autosave
```

#### Request Body Example:

```json
{
  "student_id": 123,
  "test_id": 456,
  "responses": [
    {
      "question_id": 1,
      "answer_text": "This is my answer to question 1",
      "status": "ATTEMPTED"
    },
    {
      "question_id": 2,
      "answer_text": "",
      "status": "SKIPPED"
    },
    {
      "question_id": 3,
      "answer_text": "Need to check this answer again",
      "status": "MARKED_FOR_REVIEW"
    }
  ]
}
```

### Other Endpoints

- `POST /students` - Create a new student
- `POST /tests` - Create a new test
- `POST /questions` - Create a new question

## Database Schema

The database contains the following main tables:

1. `students` - Stores student information
2. `tests` - Contains test details
3. `questions` - Stores the questions for each test
4. `student_answers` - Maintains the mapping between students, tests, questions, and their answers

## Setup and Installation

### Prerequisites

- JDK 11 or higher
- PostgreSQL 12 or higher
- Maven/Gradle

### Database Setup

1. Create a PostgreSQL database:
   ```sql
   CREATE DATABASE autosave_api;
   ```

2. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/autosave_api
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

### Building and Running

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/AutoSaveAPI.git
   cd AutoSaveAPI
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`

## Testing with Postman

### 1. Create a Student

**Endpoint:** `POST /students`

**Request Body:**
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### 2. Create a Test

**Endpoint:** `POST /tests`

**Request Body:**
```json
{
  "title": "Mathematics Final Exam",
  "startTime": "2025-04-15T09:00:00",
  "endTime": "2025-04-15T12:00:00"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "title": "Mathematics Final Exam",
  "startTime": "2025-04-15T09:00:00",
  "endTime": "2025-04-15T12:00:00"
}
```

### 3. Create a Question

**Endpoint:** `POST /questions`

**Request Body:**
```json
[
  {
    "testId": 1,
    "questionText": "What is polymorphism in OOP?"
  },
  {
    "testId": 1,
    "questionText": "Explain the concept of Spring Boot."
  },
  {
    "testId": 1,
    "questionText": "What is dependency injection?"
  }
]

```

**Response (201 Created):**
```json
[
  {
    "id": 1,
    "test": {
      "id": 1,
      "name": "Java Test",
      "startTime": "2025-04-12T10:00:00",
      "endTime": "2025-04-12T11:00:00"
    },
    "questionText": "What is polymorphism in OOP?"
  },
  {
    "id": 2,
    "test": {
      "id": 1,
      "name": "Java Test",
      "startTime": "2025-04-12T10:00:00",
      "endTime": "2025-04-12T11:00:00"
    },
    "questionText": "Explain the concept of Spring Boot."
  }
]

```

### 4. Auto-Save Student Responses

**Endpoint:** `POST /autosave`

**Request Body:**
```json
{
  "studentId": 1,
  "testId": 1,
  "responses": [
    {
      "questionId": 1,
      "answer": "Sample Answer",
      "status": "ATTEMPTED"
    },
    {
      "questionId": 2,
      "answer": "Another Answer",
      "status": "SKIPPED"
    }
  ]
}
```

**Response (200 OK):**
```json
{
 Responses saved successfully.
}
```


## Future Enhancements

- Add authentication and authorization
- Consider concurrency (same student submitting answers simultaneously)
- Implement rate limiting
- Add analytics for student performance
- Extend API to support different question types (MCQ, coding challenges, etc.)


## 🤝 Contributors

#### Lucky Garg - Developer 

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/lucky-garg/)

## 🚀 About Me

#### Aspiring Full Stack Developer | B.Tech CSE '26

##### I’m passionate about building impactful Projects using Java, Spring Boot, React.js, and has a strong foundation in Data Structures & Algorithms. Currently diving deeper into Spring Boot, I’m also focused on learning AWS Deployment, AI integration, Docker, and cloud Technologies. Always eager to learn and grow, I strive to bring value through innovation and continuous improvement.
