package ru.example.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.GregorianCalendar;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private String cardNumber;
    private GregorianCalendar expiryDate;
    private String owner;
    private int pinCode;
    private boolean isBlocked;

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
