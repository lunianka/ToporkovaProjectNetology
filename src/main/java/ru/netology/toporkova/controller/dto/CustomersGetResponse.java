package ru.netology.toporkova.controller.dto;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CustomersGetResponse {
    private final List<CustomerDTO> Customers;

}
