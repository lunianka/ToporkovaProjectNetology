package ru.netology.toporkova.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomersGetResponse {
    private final List<CustomerDto> customers;
}
