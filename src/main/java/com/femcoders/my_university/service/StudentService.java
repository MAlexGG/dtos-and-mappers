package com.femcoders.my_university.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.femcoders.my_university.dto.request.UpdateStudentProfile;
import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;

public interface StudentService {
    //GET STUDENT BY ID
    ResponseEntity<Student> getStudentById(int id);
    ResponseEntity<StudentProfileDto> getStudentByIdWithDto(int id);
    ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapper(int id);
    ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapStruct(int id);

    //GET STUDENTS
    ResponseEntity<List<Student>> getStudents();
    ResponseEntity<List<StudentsListDto>> getStudentsWithDto();
    ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapper();
    ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapStruct();

    //UPDATE STUDENT BY ID
    ResponseEntity<Student> updateStudentProfileWithDto(int id, UpdateStudentProfile updatedStudent);
    ResponseEntity<Student> updateStudentProfileWithDtoAndMapper(int id, UpdateStudentProfile updatedStudent);
    ResponseEntity<Student> updateStudentProfileWithDtoAndMapStruct(int id, UpdateStudentProfile dto);
}
