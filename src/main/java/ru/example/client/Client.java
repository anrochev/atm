package ru.example.client;

import lombok.Getter;
import lombok.Setter;
import ru.example.card.Card;
@Getter
@Setter
public class Client {
    private Card clientCard;

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
