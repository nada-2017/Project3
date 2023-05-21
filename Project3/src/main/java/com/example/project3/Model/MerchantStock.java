package com.example.project3.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MerchantStock {

    @NotNull(message = "ID is required")
    @Digits(integer = 3, fraction = 0, message = "ID length must be 3")
    @Min(value = 100, message = "ID length must be 3")
    private int id;

    @NotNull(message = "Product ID is required")
    @Digits(integer = 3, fraction = 0, message = "Product ID length must be 3")
    @Min(value = 100, message = "Product ID length must be 3")
    private int productId;

    @NotNull(message = "Merchant ID is required")
    @Digits(integer = 3, fraction = 0, message = "Merchant ID length must be 3")
    @Min(value = 100, message = "Merchant ID length must be 3")
    private int merchantId;

    @NotNull(message = "Stock is required")
    @Min(value = 10, message = "Stock have to be more than 10")
    private int stock;

}
