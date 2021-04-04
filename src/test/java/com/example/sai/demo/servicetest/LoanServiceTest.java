package com.example.sai.demo.servicetest;

import com.example.sai.demo.dal.LoanRepository;
import com.example.sai.demo.exception.InvalidLoanTypeException;
import com.example.sai.demo.exception.ResourceNotFoundException;
import com.example.sai.demo.model.Loan;
import com.example.sai.demo.service.LoanService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoanServiceTest {


    @MockBean
    private LoanRepository loanRepository;

    @Autowired
    LoanService loanService;

    @Test
    public void testSaveLoaninDB() throws InvalidLoanTypeException {
        Loan loan=new Loan();
        loan.setCustomerName("Dummy_name");
        loan.setSocialSN(123456789);
        loan.setDateOfBirth("1111-12-12");
        loan.setPrincipalAmt(10);
        loan.setRateOfInterest(10);
        loan.setLoantype("student");
        loan.setTerm(10);

        Mockito.when(loanRepository.save(loan)).thenReturn(loan);
        assertThat(loanService.saveLoaninDB(loan)).isEqualTo(loan);
        System.out.println(loan.getResultAPR());
    }

    @Test
    public void testgetLoanbyId() throws ResourceNotFoundException {
        Loan loan=new Loan();
        loan.setCustomerName("Dummy_name");
        loan.setSocialSN(123456789);
        loan.setDateOfBirth("1111-12-12");
        loan.setPrincipalAmt(10);
        loan.setRateOfInterest(10);
        loan.setLoantype("student");
        loan.setTerm(10);

        Mockito.when(loanRepository.findById(1)).thenReturn(java.util.Optional.of(loan));
        assertThat(loanService.getLoanByid(1)).isEqualTo(loan);
    }

    @Test
    public void testforResultApr() throws InvalidLoanTypeException {
        Loan loan=new Loan();
        loan.setCustomerName("Dummy_name");
        loan.setSocialSN(123456789);
        loan.setDateOfBirth("1111-12-12");
        loan.setPrincipalAmt(10);
        loan.setRateOfInterest(10);
        loan.setLoantype("student");
        loan.setTerm(10);

        Mockito.when(loanRepository.save(loan)).thenReturn(loan);
        loanService.saveLoaninDB(loan);
        assertThat(loan.getResultAPR()).isEqualTo(3650.0);
    }

    @Test
    public void testGetAllLoans(){
        Loan loan=new Loan();
        loan.setCustomerName("Dummy_name");
        loan.setSocialSN(123456789);
        loan.setDateOfBirth("1111-12-12");
        loan.setPrincipalAmt(10);
        loan.setRateOfInterest(10);
        loan.setLoantype("student");
        loan.setTerm(10);

        Loan loan2=new Loan();
        loan2.setCustomerName("Dummy_name");
        loan2.setSocialSN(123456789);
        loan2.setDateOfBirth("1111-12-12");
        loan2.setPrincipalAmt(10);
        loan2.setRateOfInterest(10);
        loan2.setLoantype("student");
        loan2.setTerm(10);

        List<Loan> loanList = new ArrayList<>();
        loanList.add(loan);
        loanList.add(loan2);

        Mockito.when(loanRepository.findAll()).thenReturn(loanList);

        assertThat(loanService.getAllSavedLoans()).isEqualTo(loanList);
    }

}
