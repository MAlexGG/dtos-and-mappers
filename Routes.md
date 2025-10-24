# ROUTES

## GET STUDENT BY ID
### sin Dto
localhost:8080/api/v1/students/student/{id}
### con DTO Response sin mapper
localhost:8080/api/v1/students/student/dto/{id}
### con DTO Response con mapper manual
localhost:8080/api/v1/students/student/mapper/{id}
### con DTO Response con mapper MapStruct
localhost:8080/api/v1/students/student/mapstruct/{id}

## GET STUDENTS
### sin Dto
localhost:8080/api/v1/students
### con DTO Response sin mapper
localhost:8080/api/v1/students/dto
### con DTO Response con mapper manual
localhost:8080/api/v1/students/mapper
### con DTO Response con mapper MapStruct
localhost:8080/api/v1/students/mapstruct

## UPDATE STUDENT BY ID
### con DTO Request sin mapper 
localhost:8080/api/v1/students/student/{id}