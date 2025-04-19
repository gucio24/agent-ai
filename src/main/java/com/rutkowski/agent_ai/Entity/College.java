package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class College {
    @Id
    private String id;
    private String nazwa;
    private String miasto;
}
