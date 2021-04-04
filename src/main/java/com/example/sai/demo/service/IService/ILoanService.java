package com.example.sai.demo.service.IService;

import com.example.sai.demo.exception.InvalidLoanTypeException;
import com.example.sai.demo.exception.ResourceNotFoundException;
import com.example.sai.demo.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILoanService {
    Loan saveLoaninDB(Loan loan) throws InvalidLoanTypeException;

    Loan getLoanByid(int id) throws ResourceNotFoundException;

    List<Loan> getAllSavedLoans();
}
