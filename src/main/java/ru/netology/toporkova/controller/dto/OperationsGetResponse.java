package ru.netology.toporkova.controller.dto;

import lombok.Data;

import java.util.List;
@Data
public class OperationsGetResponse {
    private final List<OperationDto> operationDTOS;
}