package ru.example.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    @NotNull
    private String cardNumber;

    private LocalDate expiryDate;
    @NotNull
    private String owner;
    @Size(min = 0, max = 9999)
    private int pinCode;
    private boolean isBlocked;
}
