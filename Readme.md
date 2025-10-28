# :scissors: DTOs & MAPPERS, part I

## Context
This is a simple API Rest developed with a MVC with 3-tier architecture.
A student can register on the university website, where they can find their profile and the courses they are enrolled in. The university's rules are that students cannot change their first name, last name, or ID number through the website, because the university wants to ensure that it has a real person registered. When the student views their profile, they will be able to access all of their data, except for the ID that has been assigned.
The university needs the list of students, so only the first and last names can be displayed.

### Objective
- Learn the differences between creating a method using only entities, using DTOs, using DTOs and manual mappers and using DTOs and MapStruct.
- Learn about the types of validations performed in entities and DTOs.

### Technologies
- Java 21
- Spring Boot 
- h2 console

### Resources
[Part II](https://github.com/MAlexGG/dtos-and-mappers-II)
