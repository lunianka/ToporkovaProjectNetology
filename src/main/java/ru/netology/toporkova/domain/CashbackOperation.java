package ru.netology.toporkova.domain;

public class CashbackOperation extends Operation{
    private int cashbackAmount;

    public CashbackOperation(int id, int sum, String currency, String merchant, int cashbackAmount) {
        super(id, sum, currency, merchant);
        this.cashbackAmount = cashbackAmount;
    }

//    @Override
//    public void printToConsole() {
//        System.out.println("Cashback Operation");
//        System.out.println("ID: " + getId());
//        System.out.println("Sum: " + getSum());
//        System.out.println("Currency: " + getCurrency());
//        System.out.println("Merchant: " + getMerchant());
//        System.out.println("Cashback Amount: " + cashbackAmount);
//    }
}
