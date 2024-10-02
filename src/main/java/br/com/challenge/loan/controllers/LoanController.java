package br.com.challenge.loan.controllers;

import br.com.challenge.loan.dto.CustomerDTO;
import br.com.challenge.loan.dto.LoansDTO;
import br.com.challenge.loan.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping(path = "/customer-loans")
    public ResponseEntity<LoansDTO> customerLoans(@RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.ok(loanService.loansAvailable(customerDTO));
    }
}
