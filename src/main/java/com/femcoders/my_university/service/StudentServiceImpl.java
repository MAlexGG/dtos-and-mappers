package com.femcoders.my_university.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.femcoders.my_university.dto.request.UpdateStudentProfile;
import com.femcoders.my_university.dto.response.StudentProfileDto;
import com.femcoders.my_university.dto.response.StudentsListDto;
import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.mapper.StudentMapper;
import com.femcoders.my_university.mapper.StudentMapperMapStruct;
import com.femcoders.my_university.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private StudentMapperMapStruct studentMapperMapStruct;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, StudentMapperMapStruct studentMapperMapStruct){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.studentMapperMapStruct = studentMapperMapStruct;
    }

    //GET STUDENT BY ID ---------------------------------------------
    //sin DTO
    @Override
    public ResponseEntity<Student> getStudentById(int id) {
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //con DTO Response sin mapper
    @Override
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDto(int id){
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity<>(new StudentProfileDto(student.getName(), student.getLastname(), student.getDni_nie(), student.getPhone(), student.getEmail()), HttpStatus.OK);
    }

    //con DTO Response con mapper manual
    @Override
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapper(int id){
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity<>(studentMapper.toProfileDto(student), HttpStatus.OK);
    }

    //con DTO Response con mapper MapStruct
    @Override
    public ResponseEntity<StudentProfileDto> getStudentByIdWithDtoAndMapStruct(int id){
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity<>(studentMapperMapStruct.toProfileDto(student), HttpStatus.OK);
    }


    //GET STUDENTS --------------------------------------------------
    //sin DTO
    @Override
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //con DTO Response sin mapper
    @Override
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDto(){
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students.stream().map(
            student -> new StudentsListDto(
                student.getName(),
                student.getLastname()
            )
        ).collect(Collectors.toList()), HttpStatus.OK);
    }

    //con DTO Response con mapper manual
    @Override
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapper(){
        return new ResponseEntity<>(studentMapper.toListDtoList(studentRepository.findAll()), HttpStatus.OK);
    }

    //con DTO Response con mapper MapStruct
    @Override
    public ResponseEntity<List<StudentsListDto>> getStudentsWithDtoAndMapStruct(){
        return new ResponseEntity<>(studentMapperMapStruct.toListDtoList(studentRepository.findAll()), HttpStatus.OK);
    }


    //UPDATE STUDENT BY ID ------------------------------------------
    //sin DTO
    @Override
    public ResponseEntity<Student> updateStudentProfile(int id, Student student) {
        Student studentFounded = studentRepository.findById(id).get();
        studentFounded.setPhone(student.getPhone());
        studentFounded.setEmail(student.getEmail());
        return new ResponseEntity<>(studentRepository.save(studentFounded), HttpStatus.OK);
    } 

    //con Dto Request sin mapper
    @Override
    public ResponseEntity<Student> updateStudentProfileWithDto(int id, UpdateStudentProfile dto){
        Student student = studentRepository.findById(id).get();
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    //con Dto Request con mapper manual
    @Override
    public ResponseEntity<Student> updateStudentProfileWithDtoAndMapper(int id, UpdateStudentProfile dto) {
        Student student = studentRepository.findById(id).get();
        Student studentUpdated = studentMapper.updateStudentFromDto(dto, student);
        return new ResponseEntity<>(studentRepository.save(studentUpdated), HttpStatus.OK);
    }

    //con Dto Request con mapper MapStruct
    @Override
    public ResponseEntity<Student> updateStudentProfileWithDtoAndMapStruct(int id, UpdateStudentProfile dto) {
        Student student = studentRepository.findById(id).get();
        studentMapperMapStruct.updateStudentFromDto(dto, student);
        Student updatedStudent = studentRepository.save(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    } 
}