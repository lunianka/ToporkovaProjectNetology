package ru.netology.toporkova.domain;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class Operation implements ConsolePrintable {
    private Integer id;
    private Integer sum;
    private Currency currency;
    private String merchant;
    private Integer customerId;

    @Override
    public void printToConsole() {
        System.out.println("id=" + id +
                ", sum=" + sum +
                ", currency='" + currency + '\'' +
                ", merchant='" + merchant + '\'' + ".");
    }
}
