package com.rutkowski.agent_ai.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class College {
    @Id
    private String id;
    private String nazwa;
    private String miasto;

    @OneToMany(mappedBy = "college", fetch = FetchType.LAZY)
    private List<Person> persons = new ArrayList<>();

    @OneToMany(mappedBy = "college", fetch = FetchType.LAZY)
    private List<Study> studies = new ArrayList<>();

}
