package com.example.sai.demo.repositorytest;

import com.example.sai.demo.dal.LoanRepository;
import com.example.sai.demo.exception.ResourceNotFoundException;
import com.example.sai.demo.model.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

    Loan temploan1;
    Loan temploan2;
    @BeforeEach
    void initializeValues(){
        temploan1=new Loan();
        temploan1.setCustomerName("DUMMY_NAME_1");
        temploan1.setSocialSN(123456789);
        temploan1.setDateOfBirth("1111-12-12");
        temploan1.setPrincipalAmt(10);
        temploan1.setRateOfInterest(10);
        temploan1.setLoantype("student");
        temploan1.setResultAPR(10);
        temploan1.setTerm(10);
        temploan2=new Loan();
        temploan2.setCustomerName("DUMMY_NAME_2");
        temploan2.setSocialSN(123456787);
        temploan2.setDateOfBirth("1111-12-11");
        temploan2.setPrincipalAmt(20);
        temploan2.setRateOfInterest(20);
        temploan2.setLoantype("auto");
        temploan2.setResultAPR(20);
        temploan2.setTerm(20);
    }

    @AfterEach
    void teardownValues(){
        temploan1=null;
        temploan2=null;
    }

    @Test
    public void testSaveNewLoan() throws ResourceNotFoundException {
        Loan loan1= loanRepository.save(temploan1);
        Loan loan2= loanRepository.save(temploan2);
        assertNotNull(loan1);
        assertNotNull(loan2);
        assertEquals(loan1.getCustomerName(),"DUMMY_NAME_1");
        assertEquals(loan1.getPrincipalAmt(),10);
        assertEquals(loan2.getCustomerName(),"DUMMY_NAME_2");
        assertEquals(loan2.getPrincipalAmt(),20);
    }

    @Test
    public void testFindbyId() throws ResourceNotFoundException {
        loanRepository.save(temploan1);
        Optional<Loan> testLoan = loanRepository.findById(1);
        assertNotNull(testLoan);
    }

    @Test
    public void testFindtotalLoans() throws ResourceNotFoundException {
        loanRepository.save(temploan1);
        loanRepository.save(temploan2);
        assertEquals(loanRepository.findAll().size(),2);
    }
}
