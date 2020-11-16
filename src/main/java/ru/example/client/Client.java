package ru.example.client;

import ru.example.card.Card;

public class Client {
    Card clientCard;

    public int inputPinCode(int pinCode) {
        return pinCode;
    }

    public int chooseAction(int actionType) {
        return actionType;
    }

    public boolean insertCard(Card card) {
        return card.getCardNumber() != null;
    }

    public Card getClientCard() {
        return clientCard;
    }

    public void setClientCard(Card clientCard) {
        this.clientCard = clientCard;
    }
}
