package com.example.sai.demo.service;

import com.example.sai.demo.dal.LoanRepository;
import com.example.sai.demo.exception.InvalidLoanTypeException;
import com.example.sai.demo.exception.ResourceNotFoundException;
import com.example.sai.demo.model.Loan;
import com.example.sai.demo.service.IService.ILoanService;
import com.example.sai.demo.utility.CalculateAPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService implements ILoanService {

    @Autowired
    LoanRepository loanrepo;

    @Override
    public Loan saveLoaninDB(Loan loan) throws InvalidLoanTypeException {
        CalculateAPRService calculateAPRService=new CalculateAPRService();
        loan.setResultAPR(calculateAPRService.calResultAPR(loan));
        loanrepo.save(loan);
        return loan;
    }


    @Override
    public Loan getLoanByid(int id) throws ResourceNotFoundException {
        Loan employee = loanrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id : " + id));
        return employee;
    }

    @Override
    public List<Loan> getAllSavedLoans() {
        return loanrepo.findAll();
    }
}
