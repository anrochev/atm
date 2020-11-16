package ru.example.card;

import java.util.Date;
import java.util.GregorianCalendar;

public class Card {
    private String cardNumber;
    private GregorianCalendar expiryDate;
    private String owner;
    private int pinCode;
    private boolean isBlocked;

    public Card(String cardNumber, GregorianCalendar expiryDate, String owner, int pinCode, boolean isBlocked) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.owner = owner;
        this.pinCode = pinCode;
        this.isBlocked = isBlocked;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    public String getOwner() {
        return owner;
    }

    public int getPinCode() {
        return pinCode;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
