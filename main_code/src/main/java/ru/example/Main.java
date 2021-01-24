package ru.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ru.example.atm.Atm;
import ru.example.card.Card;
import ru.example.client.Client;
import ru.example.client.SavingAccount;
import ru.example.common.Currency;
import ru.example.controller.ATMRestController;
import ru.example.dto.BalanceDTO;
import ru.example.service.ATMService;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.UUID;

//@ComponentScan(basePackages = "ru.example.card")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(ru.example.Main.class, args);

        double balance;
        LocalDate cardExpiryDate = LocalDate.of(2022, Month.JANUARY, 1);
        int userAction;
        int userPin = 0;
        ATMService service = new ATMService();
        ATMRestController controller = new ATMRestController(service);
        BalanceDTO balanceDTO = new BalanceDTO(0);

        //ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        SavingAccount savingAccount1 = new SavingAccount("12345678900987654321",LocalDate.of(2022, Month.JANUARY, 1));

        UUID rqUid1 = UUID.randomUUID();

        Atm atm1 = new Atm(1);
        Scanner pin = new Scanner(System.in);
        //цикл работы банкомата
        do {
            System.out.println("Пожалуйста, вставьте карту");
            Card card1 = new Card("3476380078654534", cardExpiryDate, "Иванов Иван Иванович", 30, false,1,1);
            //Card card1 =  context.getBean("card", Card.class);

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

            do {
            System.out.print("Введите пин-код: ");
            try {
                userPin = pin.nextInt();
            } catch (Exception e) {
                System.out.println("Введено неверное число");
                System.exit(4);
            }


            client1.inputPinCode(userPin);

            if (!atm1.checkIsPinCorrect((CorrectPin, PinForCheck) -> (CorrectPin == PinForCheck), card1.getPinCode(), userPin)) {
                System.out.println("Некорректный пин-код");
                break;
                //pin.close();
                //System.exit(3);
            }

            System.out.print(atm1.getMainMenu());

                //  userAction = pin.nextInt();
                try {
                    userAction = pin.nextInt();
                } catch (Exception e) {
                    break;
                }
                client1.chooseAction(userAction);
                if (userAction == 1) {
                    System.out.println("Выберите валюту: RUR, USD, EUR");
                    balance = atm1.getBalance(card1.getCardNumber(), Currency.RUR, rqUid1);
                    //System.out.println("Баланс: " + String.format("%.2f", balance) + " " + "RUR");

                    balanceDTO = controller.getClientBalance(atm1.getAtmNumber(), card1.getClientId(), card1.getAccountId(), userPin);
                    System.out.println("Баланс: " + balanceDTO.getBalance() + " " + "RUR");

                    System.out.print(atm1.getMainMenu());
                }
            }
            while (userAction == 1);
            System.out.println(atm1.returnCard());
            //pin.close();
        }
        while (1!=0);//банкомат работает пока не выключат

    }
}


