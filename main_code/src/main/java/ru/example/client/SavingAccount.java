package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class SavingAccount extends Account {
    private String accountNumber;
    private LocalDate dateTo;
 }
