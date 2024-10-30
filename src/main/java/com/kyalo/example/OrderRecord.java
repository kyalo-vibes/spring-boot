package com.kyalo.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {

}