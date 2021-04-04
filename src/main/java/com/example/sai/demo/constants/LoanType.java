package com.example.sai.demo.constants;

public enum LoanType {

    STUDENT(0),
    AUTO(500),
    PERSONAL(750),
    MORTGAGE(1500);


    public final int fees;

    public int getFees() {
        return fees;
    }

    private LoanType(int fees) {
        this.fees = fees;
    }
}
