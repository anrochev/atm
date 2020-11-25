package ru.example.atm;

import lombok.Getter;
import lombok.Setter;
import ru.example.card.Card;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class Atm {
    private final Random random = new Random();
    private String atmNumber;


    public Atm(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public double getBalance(String cardNumber, String currency) {
        return (random.nextDouble() + random.nextInt(1000000));
    }

    public boolean checkIsExpiry(Card card1) {
        return card1.getExpiryDate().isBefore(LocalDate.now());
    }

    public boolean checkIsPinCorrect(Card card1, int userPin) {
        return card1.getPinCode() == userPin;
    }

    public boolean checkIsBlocked(Card card1) {
        return card1.isBlocked();
    }

    public String returnCard() {
        return "Заберите карту. Сеанс обслуживания завершен.";
    }

    public int readCard() {
        return 1;
    }

    public String getMainMenu() {
        return "Выберите действие: 1 - получить баланс, любое другое число - забрать карту: ";
    }

}
