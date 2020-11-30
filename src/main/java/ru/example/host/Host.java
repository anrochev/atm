package ru.example.host;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Random;
import org.apache.log4j.Logger;
@Getter
@Setter
@AllArgsConstructor

public class Host {
    private final Random random = new Random();
    // Инициализация логера
    private static final Logger log = Logger.getLogger(Host.class);

    public double getBalance(String cardNumber, String currency) {
        log.info("Запрос баланса по карте "+cardNumber+", валюта:"+currency);
        return (random.nextDouble() + random.nextInt(1000000));
    }
}
