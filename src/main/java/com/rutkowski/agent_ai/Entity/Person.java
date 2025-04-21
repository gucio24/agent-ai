package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private College college;

    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", plec='" + plec + '\'' +
                ", uczelnia='" + uczelnia + '\'' +
                '}';
    }
}
