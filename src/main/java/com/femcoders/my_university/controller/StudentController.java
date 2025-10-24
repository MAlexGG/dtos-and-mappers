package com.femcoders.my_university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femcoders.my_university.dto.request.UpdateStudentProfile;
import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.service.StudentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //GET STUDENT BY ID ---------------------------------------------
    //sin DTO
    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    //con DTO Response sin mapper
    @GetMapping("student/dto/{id}")
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDto(@PathVariable int id) {
        return studentService.getStudentByIdWithDto(id);
    }

    //con DTO Response con mapper manual
    @GetMapping("student/mapper/{id}")
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapper(@PathVariable int id) {
        return studentService.getStudentByIdWithDtoAndMapper(id);
    }

    //con DTO Response con mapper MapStruct
    @GetMapping("student/mapstruct/{id}")
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapStruct(@PathVariable int id){
        return studentService.getStudentByIdWithDtoAndMapStruct(id);
    }
    //---------------------------------------------------------------


    //GET STUDENTS --------------------------------------------------
    //sin DTO
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return studentService.getStudents();
    }

    //con DTO Response sin mapper
    @GetMapping("/dto")
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDto() {
        return studentService.getStudentsWithDto();
    }

    //con DTO Response con mapper manual
    @GetMapping("/mapper")
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapper(){
        return studentService.getStudentsWithDtoAndMapper();
    }

    //con DTO Response con mapper MapStruct
    @GetMapping("/mapstruct")
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapStruct() {
        return studentService.getStudentsWithDtoAndMapStruct();
    }
    //---------------------------------------------------------------


    //UPDATE STUDENT BY ID ------------------------------------------
    //con DTO Request sin mapper
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateProfileWithDto(@PathVariable int id, @Valid @RequestBody UpdateStudentProfile updatStudent){
        return studentService.updateStudentProfileWithDto(id, updatStudent);
    }

    //con DTO Resquest con mapper manual
    @PutMapping("/student/mapper/{id}")
    public ResponseEntity<Student> updateProfileWithDtoAndMapper(@PathVariable int id, @Valid @RequestBody UpdateStudentProfile updateStudent) {
        return studentService.updateStudentProfileWithDtoAndMapper(id, updateStudent);
    }

    //con DTO Resquest con mapper MapStruct
}
