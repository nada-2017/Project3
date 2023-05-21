package com.example.project3.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    @NotNull(message = "ID is required")
    @Digits(integer = 3, fraction = 0, message = "ID length must be 3")
    @Min(value = 100, message = "ID length must be 3")
    private int id;

    @NotEmpty(message = "Name is required")
    @Size(min = 3, max = 3, message = "Name length should be 3 letters")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price should be positive number")
    private double price;

    @NotNull(message = "Category ID is required")
    @Digits(integer = 3, fraction = 0, message = "Category ID length should be 3 letters")
    @Min(value = 100, message = "Category ID length must be 3")
    private int categoryID;
}
