package ru.example.common.messages;

import lombok.Value;

@Value
public class Request {
    private final int id;
    private final String data;
    private final ru.example.common.messages.RequestTypes type;
}
