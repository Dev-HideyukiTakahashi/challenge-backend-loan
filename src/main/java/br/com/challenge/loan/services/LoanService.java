package br.com.challenge.loan.services;

import br.com.challenge.loan.dto.ClientDTO;
import br.com.challenge.loan.dto.LoansDTO;
import br.com.challenge.loan.entities.Loan;
import br.com.challenge.loan.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public LoansDTO loansAvailable(ClientDTO clientDTO) {
        LoansDTO dto = new LoansDTO(clientDTO.getName());
        checkLoanModalities(clientDTO, dto.getLoans());
        return dto;
    }

    private void checkLoanModalities(ClientDTO clientDTO, List<Loan> list) {
        if (personalLoan(clientDTO)) {
            list.add(new Loan(Type.PERSONAL, 4.0));
        }
        if (consignmentLoan(clientDTO)) {
            list.add(new Loan(Type.CONSIGNMENT, 2.0));
        }
        if (guaranteedLoan(clientDTO)) {
            list.add(new Loan(Type.GUARANTEED, 3.0));
        }
    }

    private boolean personalLoan(ClientDTO clientDTO) {
        double minValue = 3000.0;
        double maxValue = 5000.0;
        int age = 30;
        String location = "SP";

        if (clientDTO.getIncome() <= minValue) {
            return true;
        } else if (clientDTO.getIncome() >= minValue && clientDTO.getIncome() <= maxValue
                && clientDTO.getAge() < age && clientDTO.getLocation().equals(location)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean consignmentLoan(ClientDTO clientDTO) {
        double value = 5000.0;
        return clientDTO.getIncome() >= value;
    }

    private boolean guaranteedLoan(ClientDTO clientDTO) {
        double minValue = 3000.0;
        double maxValue = 5000.0;
        int age = 30;
        String location = "SP";

        if (clientDTO.getIncome() <= minValue) {
            return true;
        } else if (clientDTO.getIncome() >= minValue && clientDTO.getIncome() <= maxValue
                && clientDTO.getAge() < age && clientDTO.getLocation().equals(location)) {
            return true;
        }
        return false;
    }
}
