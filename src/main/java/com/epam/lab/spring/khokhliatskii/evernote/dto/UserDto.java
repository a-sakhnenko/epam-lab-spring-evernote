package com.epam.lab.spring.khokhliatskii.evernote.dto;

import lombok.Data;
import javax.validation.constraints.*;


@Data
public class UserDto {

    private int id;

    //    @Pattern(regexp = ValidationExpressions.EMAIL_REGEX,
    //            message = "email is not correct")
    @NotNull(message = "email can't be undefined")
    @Email
    private String email;

    @NotNull(message = "password can't be undefined")
    @Size(min = 1)
    private String password;

    @NotNull(message = "role can't be undefined")
    private String role;


}




