package com.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.findByOwnerAddress", query = "select a from Account a where a.ownerAddress like :ownerAddress"),
        @NamedQuery(name = "Account.findByAmountBetween", query = "select a from Account a where a.amount between :amount and :amountEnd"),
        @NamedQuery(name = "Account.findByOwnerName", query = "select a from Account a where a.ownerName like :ownerName"),
        @NamedQuery(name = "Account.findByAmount", query = "select a from Account a where a.amount = :amount")
})

public class Account {
    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    @Column(name = "owner_name", columnDefinition = "VARCHAR(155)")
    private String ownerName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "owner_address")
    private String ownerAddress;
    @Column(name = "amount")
    private double amount;

    public Account() {
    }

    public Account(long accountNumber, String ownerName, String cardNumber, String ownerAddress, double amount) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.ownerAddress = ownerAddress;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", ownerName='" + ownerName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", amount=" + amount +
                '}';
    }
}
