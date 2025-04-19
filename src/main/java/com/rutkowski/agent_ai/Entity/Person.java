package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    private String imie;
    private String nazwisko;
    private int wiek;
    private String plec;
    private String uczelnia;
}
