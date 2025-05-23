package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Study {
    @Id
    private String nazwa;
    private String uczelnia;
    private String sponsor;

    @ManyToOne(fetch = FetchType.LAZY)
    private College college;

    @Override
    public String toString() {
        return "Study{" +
                "nazwa='" + nazwa + '\'' +
                ", uczelnia='" + uczelnia + '\'' +
                ", sponsor='" + sponsor + '\'' +
                '}';
    }
}
