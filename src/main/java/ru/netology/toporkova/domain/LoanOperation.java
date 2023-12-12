package ru.netology.toporkova.domain;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoanOperation extends Operation{
    private int loanId;

    public LoanOperation(Integer id, Integer sum, Currency currency, String merchant, Integer customerId, int loanId) {
        super(id, customerId, sum, currency, merchant);
        this.loanId = loanId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public void printToConsole() {
        System.out.println("id: " + getId() +
                ", loanId: " + loanId +
                ", sum: " + getSum() +
                ", currency: " + getCurrency() +
                ", merchant: " + getMerchant());
    }
}
