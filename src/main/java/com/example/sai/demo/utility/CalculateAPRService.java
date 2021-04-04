package com.example.sai.demo.utility;

import com.example.sai.demo.constants.LoanType;
import com.example.sai.demo.exception.InvalidLoanTypeException;
import com.example.sai.demo.model.Loan;

public class CalculateAPRService{


    private double resultAPR(int fees, int rateofInterest, int principal, int term){
        double totalInterest= (principal*rateofInterest*term)/100;
        return ((((fees+totalInterest)/principal)/term)*365)*100;
    }

    private int enumTest(String loanType) throws InvalidLoanTypeException {

        switch (loanType.toLowerCase()){
            case "student":
                return LoanType.STUDENT.getFees();
            case "auto":
                return LoanType.AUTO.getFees();
            case "personal":
                return LoanType.PERSONAL.getFees();
            case "mortgage":
                return LoanType.MORTGAGE.getFees();
            default:
                throw new InvalidLoanTypeException("Loan type invalid, Please enter Loan type student,auto,personal or mortgage");
        }

    }

    public double calResultAPR(Loan loan) throws InvalidLoanTypeException {
        int loanType=enumTest(loan.getLoantype());
        double finalResult= resultAPR(loanType,loan.getRateOfInterest(),loan.getPrincipalAmt(),loan.getTerm());
        return finalResult;
    }
}
