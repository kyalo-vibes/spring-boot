School Management System
==========================

Overview
-----------

This project is a school management system built using Java and Spring Boot. It provides a simple API for managing schools, students, and student profiles.

Features
------------

* Create, read, update, and delete (CRUD) operations for schools
* CRUD operations for students
* CRUD operations for student profiles
* API endpoints for retrieving lists of schools, students, and student profiles

API Endpoints
----------------

### School Endpoints

* `POST /schools` - Create a new school
* `GET /schools` - Retrieve a list of all schools
* `GET /schools/{id}` - Retrieve a school by ID
* `PUT /schools/{id}` - Update a school
* `DELETE /schools/{id}` - Delete a school

### Student Endpoints

* `POST /students` - Create a new student
* `GET /students` - Retrieve a list of all students
* `GET /students/{id}` - Retrieve a student by ID
* `PUT /students/{id}` - Update a student
* `DELETE /students/{id}` - Delete a student

### Student Profile Endpoints

* `POST /student-profiles` - Create a new student profile
* `GET /student-profiles` - Retrieve a list of all student profiles
* `GET /student-profiles/{id}` - Retrieve a student profile by ID
* `PUT /student-profiles/{id}` - Update a student profile
* `DELETE /student-profiles/{id}` - Delete a student profile

Models
-------

### School

* [id](cci:4://file:///E:/Projects/example/src/test/java/com/kyalo/example/student/StudentServiceTest.java~:115:0-115:0) (Integer) - Unique identifier for the school
* [name](cci:4://file:///E:/Projects/example/src/test/java/com/kyalo/example/student/StudentServiceTest.java~:115:0-115:0) (String) - Name of the school

### Student

* [id](cci:4://file:///E:/Projects/example/src/test/java/com/kyalo/example/student/StudentServiceTest.java~:115:0-115:0) (Integer) - Unique identifier for the student
* `firstName` (String) - First name of the student
* `lastName` (String) - Last name of the student
* [email](cci:4://file:///E:/Projects/example/src/test/java/com/kyalo/example/student/StudentServiceTest.java~:80:0-92:0) (String) - Email address of the student
* [age](cci:4://file:///E:/Projects/example/src/main/java/com/kyalo/example/SchoolRepository.java~:0:0-4:0) (Integer) - Age of the student
* `createdAt` (LocalDateTime) - Date and time the student was created
* [school](cci:4://file:///E:/Projects/example/src/main/java/com/kyalo/example/school/SchoolService.java~:0:0-30:0) (School) - School the student attends

### Student Profile

* [id](cci:4://file:///E:/Projects/example/src/test/java/com/kyalo/example/student/StudentServiceTest.java~:115:0-115:0) (Integer) - Unique identifier for the student profile
* `bio` (String) - Biography of the student

Dependencies
------------

* Spring Boot
* Spring Data JPA
* Mockito
* JUnit Jupiter

Running the Application
-------------------------

1. Clone the repository
2. Build the project using Maven
3. Run the application using `java -jar target/school-management-system.jar`

Testing
---------

Unit tests and integration tests are included in the project. Run the tests using `mvn test`.

API Documentation
------------------

API documentation is generated using Swagger. Access the API documentation at `http://localhost:8080/swagger-ui.html`.