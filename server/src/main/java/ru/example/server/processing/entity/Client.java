package ru.example.server.processing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clients")
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private int PIN;

    @OneToMany(mappedBy = "client_id")
    private Set<Account> accounts;
}
