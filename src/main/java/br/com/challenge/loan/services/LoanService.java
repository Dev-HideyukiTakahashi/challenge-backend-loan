package br.com.challenge.loan.services;

import br.com.challenge.loan.dto.CustomerDTO;
import br.com.challenge.loan.dto.LoansDTO;
import br.com.challenge.loan.entities.Loan;
import br.com.challenge.loan.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public LoansDTO loansAvailable(CustomerDTO customerDTO) {
        LoansDTO dto = new LoansDTO(customerDTO.getName());
        checkLoanModalities(customerDTO, dto.getLoans());
        return dto;
    }

    private void checkLoanModalities(CustomerDTO customerDTO, List<Loan> list) {
        if (personalLoan(customerDTO)) {
            list.add(new Loan(Type.PERSONAL, 4.0));
        }
        if (consignmentLoan(customerDTO)) {
            list.add(new Loan(Type.CONSIGNMENT, 2.0));
        }
        if (guaranteedLoan(customerDTO)) {
            list.add(new Loan(Type.GUARANTEED, 3.0));
        }
    }

    private boolean personalLoan(CustomerDTO customerDTO) {
        double minValue = 3000.0;
        double maxValue = 5000.0;
        int age = 30;
        String location = "SP";

        if (customerDTO.getIncome() <= minValue) {
            return true;
        } else if (customerDTO.getIncome() >= minValue && customerDTO.getIncome() <= maxValue
                && customerDTO.getAge() < age && customerDTO.getLocation().equals(location)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean consignmentLoan(CustomerDTO customerDTO) {
        double value = 5000.0;
        return customerDTO.getIncome() >= value;
    }

    private boolean guaranteedLoan(CustomerDTO customerDTO) {
        double minValue = 3000.0;
        double maxValue = 5000.0;
        int age = 30;
        String location = "SP";

        if (customerDTO.getIncome() <= minValue) {
            return true;
        } else if (customerDTO.getIncome() >= minValue && customerDTO.getIncome() <= maxValue
                && customerDTO.getAge() < age && customerDTO.getLocation().equals(location)) {
            return true;
        }
        return false;
    }
}
