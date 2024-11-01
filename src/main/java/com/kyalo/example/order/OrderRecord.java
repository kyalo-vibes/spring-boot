package com.kyalo.example.order;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {

}