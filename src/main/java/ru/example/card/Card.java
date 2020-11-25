package ru.example.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private String cardNumber;
    private LocalDate expiryDate;
    private String owner;
    private int pinCode;
    private boolean isBlocked;
}
