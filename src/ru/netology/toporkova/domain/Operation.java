package ru.netology.toporkova.domain;

public class Operation {
    int id;
    int sum;
    String currency;
    String merchant;


    public Operation(int  id, int sum, String currency, String merchant) {
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }
}
