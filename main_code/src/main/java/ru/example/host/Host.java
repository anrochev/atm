package ru.example.host;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import ru.example.common.Currency;

import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
@Getter
@Setter

@AllArgsConstructor


public class Host {
    private final Random random = new Random();
    private static HashSet<UUID> uuidHashSet = new HashSet<>();
    // Инициализация логера
    private static final Logger log = Logger.getLogger(Host.class);

    public double getBalance(String cardNumber, Currency currency, UUID rqUid) {
        if (uuidHashSet.contains(rqUid)) {
            log.info("Дубликат запроса "+rqUid.toString());
            return -1;
        }
        uuidHashSet.add(rqUid);
        log.info("Запрос баланса по карте "+cardNumber+", валюта:"+currency.toString()+", rqUid="+rqUid.toString());
        return (random.nextDouble() + random.nextInt(1000000));
    }
}
