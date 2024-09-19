package br.com.challenge.loan.controllers;

import br.com.challenge.loan.dto.ClientDTO;
import br.com.challenge.loan.entities.Client;
import br.com.challenge.loan.services.LoanService;
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
    public ResponseEntity<ClientDTO> customerLoans(@RequestBody Client client){
        return ResponseEntity.ok(loanService.loansAvailable(client));
    }
}