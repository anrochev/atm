package ru.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BalanceDTO {
    private final int balance;
}
