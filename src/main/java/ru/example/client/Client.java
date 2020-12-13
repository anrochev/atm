package ru.example.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.example.card.Card;

import java.util.ArrayList;
import java.util.HashMap;
@AllArgsConstructor
@Getter
@Setter
public class Client<TAccount extends  Account> {
    private Card clientCard;
    private TAccount account;

    public int inputPinCode(int pinCode) {
        return pinCode;
    }

    public int chooseAction(int actionType) {
        return actionType;
    }

    public boolean insertCard(Card card) {
        return card.getCardNumber() != null;
    }

}
