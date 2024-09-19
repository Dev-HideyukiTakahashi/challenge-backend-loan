package br.com.challenge.loan.services;

import br.com.challenge.loan.dto.ClientDTO;
import br.com.challenge.loan.entities.Client;
import br.com.challenge.loan.entities.Loan;
import br.com.challenge.loan.entities.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public ClientDTO loansAvailable(Client client) {
        ClientDTO dto = new ClientDTO(client.getName());
        checkLoanModalities(client, dto.getLoans());
        return dto;
    }

    private void checkLoanModalities(Client client, List<Loan> list) {
        if (personalLoan(client)) {
            list.add(new Loan(Type.PERSONAL, 4.0));
        }
        if (consignmentLoan(client)) {
            list.add(new Loan(Type.CONSIGNMENT, 2.0));
        }
        if (guaranteedLoan(client)) {
            list.add(new Loan(Type.GUARANTEED, 3.0));
        }
    }

    private boolean personalLoan(Client client) {
        if (client.getIncome() <= 3000.0) {
            return true;
        } else if (client.getIncome() >= 3000.0 && client.getIncome() <= 5000.0
                && client.getAge() < 30 && client.getLocation().equals("SP")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean guaranteedLoan(Client client) {
        return client.getIncome() >= 5000.0;
    }

    private boolean consignmentLoan(Client client) {
        if (client.getIncome() <= 3000.0) {
            return true;
        } else if (client.getIncome() >= 3000.0 && client.getIncome() <= 5000.0
                && client.getAge() < 30 && client.getLocation().equals("SP")) {
            return true;
        }
        return false;
    }
}
