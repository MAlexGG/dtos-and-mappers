package com.femcoders.my_university.seeder;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.femcoders.my_university.entity.Student;
import com.femcoders.my_university.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        if(studentRepository.count() == 0){
            Student student_one = Student.builder()
            .name("Eli")
            .lastname("Gallardo")
            .dni_nie("70813942Y")
            .phone(675359811)
            .email("eli@mail.com")
            .build();

            Student student_two = Student.builder()
            .name("Gaby")
            .lastname("Galarza")
            .dni_nie("80311931E")
            .phone(625269925)
            .email("gabi@mail.com")
            .build();

            studentRepository.saveAll(List.of(student_one, student_two));
        }
    }

}
