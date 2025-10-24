package com.femcoders.my_university.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileDto {

    private String name;
    private String lastname;
    private String dni_nie;
    private int phone;
    private String email;

}
