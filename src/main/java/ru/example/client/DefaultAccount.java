package ru.example.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultAccount extends Account {
    private String accountNumber;
}
