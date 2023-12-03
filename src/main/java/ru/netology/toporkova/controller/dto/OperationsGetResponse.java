package ru.netology.toporkova.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class OperationsGetResponse {
    private final List<OperationsDTO> operations;
}