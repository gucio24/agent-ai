package com.rutkowski.agent_ai.Service;

import com.rutkowski.agent_ai.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.rutkowski.agent_ai.Tools.StaticTools.DELIMITER_SPACE;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String getPersonData(String params) {
        return personRepository.findAll()
                .stream()
                .map(p -> p.getImie() + " " + p.getNazwisko())
                .collect(Collectors.joining(DELIMITER_SPACE));

//        personRepository.findAll()
//                .stream()
//                .filter(p -> p.getCollege().getMiasto().equals(StaticTools.CITY))
//                .forEach(System.out::println);
//        return params;
    }

}
