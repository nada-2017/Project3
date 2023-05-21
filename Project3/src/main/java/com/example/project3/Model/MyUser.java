package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyUser {

    @NotNull(message = "ID is required")
    @Digits(integer = 3, fraction = 0, message = "ID length must be 3")
    @Min(value = 100, message = "ID length must be 3")
    private int id;

    @NotEmpty(message = "Username is required")
    @Size(min = 5, max = 5, message = "Username length should be 5 letters")
    private String username;


    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6}$",
            message = "Password must contain at least ([0-9], [a-z], [A-Z]) and length 6")
    private String password;


    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "\\b(?:Admin|Customer)\\b",message = "Role Not Valid")
    private String role;

    @NotNull(message = "Balance is required")
    @Positive(message = "Balance should be positive number")
    private double balance;

}
