package ru.netology.toporkova.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private final int id;
    private final String name;

}