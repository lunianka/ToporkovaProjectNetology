package ru.netology.toporkova.domain;

import lombok.Data;
@Data
public class Operation {
    int id;
    int sum;
    String currency;
    String merchant;


    public Operation(int  id, int sum, String currency, String merchant) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }

    public void printToConsole() {
        System.out.println("Operation");
        System.out.println("ID: " + id);
        System.out.println("Sum: " + sum);
        System.out.println("Currency: " + currency);
        System.out.println("Merchant: " + merchant);
    }

    @Override
    public String toString() {
        return "Operation {"+
                "id= " + id +
                ", sum= " + sum +
                ", currency= " + currency +
                ", merchant= " + merchant + "};";
    }
}
