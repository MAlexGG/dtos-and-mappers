package com.femcoders.my_university.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.femcoders.my_university.dto.request.UpdateStudentProfile;
import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;

@Component
public class StudentMapper {

    //getStudent
    public StudentProfileDto toProfileDto(Student student){
        if(student == null) return null;

        return new StudentProfileDto(
            student.getName(),
            student.getLastname(),
            student.getDni_nie(),
            student.getPhone(),
            student.getEmail()
        );
    }

    //getStudents
    public StudentsListDto toListDto(Student student){
        if(student == null) return null;

        return new StudentsListDto(
            student.getName(),
            student.getLastname()
        );
    }

    public List<StudentsListDto> toListDtoList(List<Student> students){
        return students.stream()
        .map(this::toListDto)
        .collect(Collectors.toList());
    }

    //updateStudent
    public Student updateStudentFromDto(UpdateStudentProfile dto, Student student){
        if(dto.getPhone() != null && dto.getEmail() != null){
            student.setPhone(dto.getPhone());
            student.setEmail(dto.getEmail());
        }
        return student;
    }


}
