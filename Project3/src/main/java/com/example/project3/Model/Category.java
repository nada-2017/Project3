package com.example.project3.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {

    @NotNull(message = "ID is required")
    @Digits(integer = 3, fraction = 0, message = "ID length must be 3")
    @Min(value = 100, message = "ID length must be 3")
    private int id;

    @NotEmpty(message = "Name is required")
    @Size(min = 3, max = 3, message = "Name length should be 3 letters")
    private String name;

}
