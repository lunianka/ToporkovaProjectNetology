package ru.netology.toporkova.domain;

import lombok.*;
import ru.netology.toporkova.domain.ConsolePrintable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class CashbackOperation extends Operation implements ConsolePrintable {
    public int cashbackAmount;

    public CashbackOperation(int sum, String currency, String merchant, int id, int cashbackAmount) {
        super(sum, currency, merchant, id);
        this.cashbackAmount = cashbackAmount;
    }

    @Override
    public void printToConsole() {
        System.out.println("Cashback Amount: " + cashbackAmount);
    }
}
