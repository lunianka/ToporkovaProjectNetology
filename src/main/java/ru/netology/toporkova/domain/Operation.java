package ru.netology.toporkova.domain;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class Operation {
    int sum;
    String currency;
    String merchant;
    int id;

    public void printToConsole() {
        System.out.println("ID: " + id);
        System.out.println("Sum: " + sum);
        System.out.println("Currency: " + currency);
        System.out.println("Merchant: " + merchant);
    }
}
