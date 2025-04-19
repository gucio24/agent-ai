package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
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

    @ManyToOne
    private College college;
}
