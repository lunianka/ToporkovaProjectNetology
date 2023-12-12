package ru.netology.toporkova.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.toporkova.domain.Currency;

import java.util.Objects;

@Data
@AllArgsConstructor
public class OperationDto {
    private final int id;
    private final int customerId;
    private int sum;
    private Currency currency;
    private String merchant;

}