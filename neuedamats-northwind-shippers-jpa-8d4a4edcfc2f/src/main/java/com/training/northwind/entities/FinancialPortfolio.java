package com.training.northwind.entities;

import javax.persistence.*;

@Entity(name = "FinancialPortfolio")
public class FinancialPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "portfolio")
    private String portfolio;
    @Column(name = "bankAccount")
    private String bankAccount;

    public FinancialPortfolio() {
    }

    public FinancialPortfolio(Long id, String username, String portfolio, String bankAccount) {
        this.id = id;
        this.username = username;
        this.portfolio = portfolio;
        this.bankAccount = bankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "FinancialPortfolio{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", porfolio='" + portfolio + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
