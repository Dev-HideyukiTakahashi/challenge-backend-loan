package br.com.challenge.loan.dto;

import br.com.challenge.loan.entities.Loan;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {

    private String customer;
    private final List<Loan> loans = new ArrayList<>();

    public ClientDTO(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
