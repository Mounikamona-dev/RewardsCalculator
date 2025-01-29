package com.rewards.Model;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String id;
    private double amt;
    private LocalDate date;

    public Transaction(String id, double amt, LocalDate date) {
        this.id = id;
        this.amt = amt;
        this.date = date;
    }

    // Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
