package com.femcoders.my_university.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentProfile {

    @NotNull
    @Digits(integer = 9, fraction = 0)
    private Integer phone;
    
    @NotBlank
    @Email
    private String email;

}
