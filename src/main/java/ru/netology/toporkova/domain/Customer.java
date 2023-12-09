package ru.netology.toporkova.domain;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    private Integer id;
    private String name;
    private String password;
}