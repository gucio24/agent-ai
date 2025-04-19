package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Study {
    @Id
    private String nazwa;
    private String uczelnia;
    private String sponsor;
}
