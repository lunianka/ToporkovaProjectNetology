package ru.netology.toporkova.domain;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {
    int id;
    String name;
}