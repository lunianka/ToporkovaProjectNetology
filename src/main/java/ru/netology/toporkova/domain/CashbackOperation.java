package ru.netology.toporkova.domain;

import java.util.Objects;

public class CashbackOperation extends Operation implements ConsolePrintable {
    private int cashbackAmount;

    public CashbackOperation(Integer id, Integer sum, Currency currency, String merchant, Integer customerId, int cashbackAmount) {
        super(id, customerId, sum, currency, merchant);
        this.cashbackAmount = cashbackAmount;
    }

    public int getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(int cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    @Override
    public String toString() {
        return "Operation{ id = " + getId() +
                ", sum: " + getSum() +
                ", currency: " + getCurrency() +
                ", merchant: " + getMerchant() +
                ", cashbackAmount " + cashbackAmount + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }


        CashbackOperation operation = (CashbackOperation) o;
        return Objects.equals(getId(), operation.getId())
                && (Objects.equals(getSum(), operation.getSum())
                && cashbackAmount == operation.cashbackAmount
                && (getCurrency() != null && getCurrency().equals(operation.getCurrency()))
                && (getMerchant() != null && getMerchant().equals(operation.getMerchant())));
    }

    @Override
    public void printToConsole() {
        System.out.println("Cashback Amount: " + cashbackAmount);
    }
}
