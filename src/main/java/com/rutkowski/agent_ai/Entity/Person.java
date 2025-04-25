package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
