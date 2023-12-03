package ru.netology.toporkova.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class OperationsDTO {
    private final int customerId;
    private final int sum;
    private final String currency;
    private final String merchant;
}