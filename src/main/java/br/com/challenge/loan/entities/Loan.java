package br.com.challenge.loan.entities;

public class Loan {

    private Type type;
    private Double interestRate;

    public Loan(Type type, Double interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

}
