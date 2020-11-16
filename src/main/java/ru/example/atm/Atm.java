package ru.example.atm;

import ru.example.card.Card;
import ru.example.client.Client;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.GregorianCalendar;
import java.util.Random;


public class Atm {
    final Random random = new Random();
    private String atmNumber;

    public Atm(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public double getBalance(String cardNumber, String currency) {
        return (random.nextDouble() + random.nextInt(1000000));
    }

    public boolean checkIsExpiry(Card card1) {
        return card1.getExpiryDate().before(new GregorianCalendar());
    }

    public boolean checkIsPinCorrect(Card card1, int userPin) {
        return card1.getPinCode() == userPin;
    }

    public boolean checkIsBlocked(Card card1) {
        return card1.isBlocked();
    }

    public int returnCard() {
        return 1;
    }

    public int readCard() {
        return 1;
    }

    public void getMainMenu() {
        System.out.print("Выберите действие: 1 - получить баланс, любое другое число - забрать карту: ");
    }

}
