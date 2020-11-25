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
}
