package ru.netology.toporkova.domain;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoanOperation extends Operation{
    private int loanId;

    @Builder
    public LoanOperation(int sum, String currency, String merchant, int id, int loanId) {
        super(sum, currency, merchant, id);
    }


    @Override
    public void printToConsole() {
        System.out.println("Loan ID: " + loanId);
    }
}
