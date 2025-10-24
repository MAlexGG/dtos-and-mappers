package com.femcoders.my_university.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.femcoders.my_university.dto.request.UpdateStudentProfile;
import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;


// NullValuePropertyMappingStrategy.IGNORE: se usa al actualizar un objeto existente con MapStruct (usando @MappingTarget). Si el valor del DTO es null, no sobrescribe el valor existente del objeto destino.
// ReportingPolicy.IGNORE: Ignora campos del DTO que no tienen mapeo en la entidad.

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapperMapStruct {

    StudentProfileDto toProfileDto(Student student);

    StudentsListDto toListDto(Student student);

    List<StudentsListDto> toListDtoList(List<Student> students);

    //Mapping Target modifica el objeto en vez de crearlo
    void updateStudentFromDto(UpdateStudentProfile dto, @MappingTarget Student student);

}