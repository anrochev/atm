package ru.example.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;


@Getter
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
//@Component("card")
public class Card {
    @NotNull

    private String cardNumber = "3476380078654534";

    private LocalDate expiryDate = LocalDate.of(2022, Month.JANUARY, 1);
    @NotNull
    private String owner = "Иванов Иван Иванович";
    //@Size(min = 0, max = 9999)
    private int pinCode = 3333;
    private boolean isBlocked = false;
    private long ClientId = 1;
    private long AccountId = 1;
}
