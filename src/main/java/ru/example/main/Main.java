package ru.example.main;

import ru.example.atm.Atm;
import ru.example.atm.CheckPin;
import ru.example.card.Card;
import ru.example.client.Account;
import ru.example.client.Client;
import ru.example.client.SavingAccount;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        double balance;
        LocalDate cardExpiryDate = LocalDate.of(2022, 1, 1);
        int userAction;
        int userPin = 0;
        SavingAccount savingAccount1 = new SavingAccount("12345678900987654321",LocalDate.of(2022, 1, 1));

        UUID rqUid1 = UUID.randomUUID();
        System.out.println("Пожалуйста, вставьте карту");
        Atm atm1 = new Atm("atm 54747876896789");

        Card card1 = new Card("3476380078654534", cardExpiryDate, "Иванов Иван Иванович", 3333, false);
        Client<SavingAccount> client1 = new Client<>(card1, savingAccount1);
        client1.setClientCard(card1);
        client1.insertCard(card1);


        atm1.readCard();

        if (atm1.checkIsExpiry(card1)) {
            System.out.println("Истек срок действия карты");
            System.exit(1);
        }
        if (atm1.checkIsBlocked(card1)) {
            System.out.println("Карта заблокирована");
            System.exit(2);
        }

        Scanner pin = new Scanner(System.in);
        System.out.print("Введите пин-код: ");
        try {
            userPin = pin.nextInt();
        } catch (Exception e) {
            System.out.println("Введено неверное число");
            System.exit(4);
        }


        client1.inputPinCode(userPin);

        if (!atm1.checkIsPinCorrect((CorrectPin, PinForCheck) -> (CorrectPin == PinForCheck),card1.getPinCode(),userPin)) {
        System.out.println("Некорректный пин-код");
            pin.close();
            System.exit(3);
        }

        System.out.print(atm1.getMainMenu());
        do {
            //  userAction = pin.nextInt();
            try {
                userAction = pin.nextInt();
            } catch (Exception e) {
                break;
            }
            client1.chooseAction(userAction);
            if (userAction == 1) {
                System.out.println("Выберите валюту: RUR, USD, EUR");
                balance = atm1.getBalance(card1.getCardNumber(), "RUR", rqUid1);
                System.out.println("Баланс: " + String.format("%.2f", balance) + " " + "RUR");
                System.out.print(atm1.getMainMenu());
            }
        }
        while (userAction == 1);
        System.out.println(atm1.returnCard());
        pin.close();
    }
}


