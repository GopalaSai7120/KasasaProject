package com.example.sai.demo.contoller;


import com.example.sai.demo.exception.InvalidLoanTypeException;
import com.example.sai.demo.exception.ResourceNotFoundException;
import com.example.sai.demo.model.Loan;
import com.example.sai.demo.service.IService.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoanController {

    @Autowired
    ILoanService loanService;

    @PostMapping("/create")
    public Loan createLoan(@Valid @RequestBody Loan inputJSON) throws InvalidLoanTypeException {
        return loanService.saveLoaninDB(inputJSON);
    }

    @GetMapping("/loan/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable(value = "id") int loanId)
            throws ResourceNotFoundException {
        Loan loan = loanService.getLoanByid(loanId);
        return ResponseEntity.ok().body(loan);
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans()
    {
        return loanService.getAllSavedLoans();
    }

}
