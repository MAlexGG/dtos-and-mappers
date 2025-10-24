package com.femcoders.my_university.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapperMapStruct {

    StudentProfileDto toProfileDto(Student student);

    StudentsListDto toListDto(Student student);

    List<StudentsListDto> toListDtoList(List<Student> students);

}