package ru.example.main;

import ru.example.atm.Atm;
import ru.example.card.Card;
import ru.example.client.Client;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double balance;
        GregorianCalendar cardExpiryDate = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        int userAction;
        int userPin;
        System.out.println("Пожалуйста, вставьте карту");
        Atm atm1 = new Atm("atm 54747876896789");
        Client client1 = new Client();
        Card card1 = new Card("3476380078654534", cardExpiryDate, "Иванов Иван Иванович", 3333, false);
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
        userPin = pin.nextInt();
        client1.inputPinCode(userPin);

        if (!atm1.checkIsPinCorrect(card1, userPin)) {
            System.out.println("Некорректный пин-код");
            pin.close();
            System.exit(3);
        }

        atm1.getMainMenu();
        do {
            userAction = pin.nextInt();
            client1.chooseAction(userAction);
            if (userAction == 1) {
                balance = atm1.getBalance(card1.getCardNumber(), "RUR");
                System.out.println("Баланс: " + String.format("%.2f", balance) + " " + "RUR");
                atm1.getMainMenu();
            }
        }
        while (userAction == 1);
        atm1.returnCard();
        System.out.println("Заберите карту. Сеанс обслуживания завершен.");
        pin.close();
    }
}


