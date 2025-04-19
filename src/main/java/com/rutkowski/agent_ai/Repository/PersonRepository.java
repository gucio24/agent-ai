package com.rutkowski.agent_ai.Repository;

import com.rutkowski.agent_ai.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
