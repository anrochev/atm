package ru.example.atm;

import ru.example.card.Card;
import ru.example.common.Currency;
import ru.example.host.Host;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class Atm {
    private final Random random = new Random();
    private String atmNumber;


    public Atm(String atmNumber) {
        this.atmNumber = atmNumber;
    }

    public double getBalance(String cardNumber, Currency currency, UUID rqUID) {
        Host host1 = new Host();
           return (host1.getBalance(cardNumber, currency, rqUID));
    }

    public boolean checkIsExpiry(Card card1) {
        return card1.getExpiryDate().isBefore(LocalDate.now());
    }

   /* public boolean checkIsPinCorrect(Card card1, int userPin) {
        return card1.getPinCode() == userPin;
    } */
    public boolean checkIsPinCorrect(CheckPin checkPin1, int CorrectPin, int PinForCheck) {
        return checkPin1.checkIsPinCorrect(CorrectPin,PinForCheck);
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
