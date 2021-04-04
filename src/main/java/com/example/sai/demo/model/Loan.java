package com.example.sai.demo.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "customerName")
    @Size(min=3,message = "Name cannot be empty and should be larger than 2 letters")
    private String customerName;

    @Column(name = "socialSN")
    @Range(min=111111111, max=999999999,message = "Please Enter 9 digits for SSN")
    private int socialSN;

    @Column(name = "dateOfBirth")
    @Size(min=4,message = "Please enter Valid DOB")
    private String dateOfBirth;

    @Column(name = "principalAmt")
    @Min(value = 1,message = "Enter principal amount more that 0")
    private int principalAmt;

    @Column(name = "rateOfInterest")
    @Min(value = 1,message = "Enter rate more than 0")
    private int rateOfInterest;

    @Column(name = "loantype")
    @Size(min=4,message = "Please enter Loan type student,auto,personal or mortgage")
    private String loantype;

    @Column(name = "term")
    @Min(value = 1,message = "Enter term greater than 0")
    private int term;

    @Column(name = "resultAPR")
    private double resultAPR;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSocialSN() {
        return socialSN;
    }

    public void setSocialSN(int socialSN) {
        this.socialSN = socialSN;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPrincipalAmt() {
        return principalAmt;
    }

    public void setPrincipalAmt(int principalAmt) {
        this.principalAmt = principalAmt;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getResultAPR() {
        return resultAPR;
    }

    public void setResultAPR(double resultAPR) {
        this.resultAPR = resultAPR;
    }
}
