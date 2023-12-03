package ru.netology.toporkova.domain;

public class LoanOperation extends Operation {
    private int loanId;

    public LoanOperation(int id, int sum, String currency, String merchant, int loanId) {
        super(id, sum, currency, merchant);
        this.loanId = loanId;
    }

//    @Override
//    public void printToConsole() {
//        System.out.println("Loan Operation");
//        System.out.println("ID: " + getId());
//        System.out.println("Sum: " + getSum());
//        System.out.println("Currency: " + getCurrency());
//        System.out.println("Merchant: " + getMerchant());
//        System.out.println("Loan ID: " + getLoanId());
//    }
}