package com.rutkowski.agent_ai.Loader;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rutkowski.agent_ai.Entity.College;
import com.rutkowski.agent_ai.Entity.Person;
import com.rutkowski.agent_ai.Entity.Study;
import com.rutkowski.agent_ai.Repository.CollegeRepository;
import com.rutkowski.agent_ai.Repository.PersonRepository;
import com.rutkowski.agent_ai.Repository.StudyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CollegeRepository collegeRepository;
    private final PersonRepository personRepository;
    private final StudyRepository studyRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(CollegeRepository collegeRepository, PersonRepository personRepository, StudyRepository studyRepository, ObjectMapper objectMapper) {
        this.collegeRepository = collegeRepository;
        this.personRepository = personRepository;
        this.studyRepository = studyRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        InputStream inputStreamC = new ClassPathResource("json/uczelnie.json").getInputStream();
        List<College> listCollege = objectMapper.readValue(inputStreamC, new TypeReference<>() {
        });
        collegeRepository.saveAll(listCollege);
        System.out.println("Saved collegeList to database!");


        InputStream inputStreamP = new ClassPathResource("json/osoby.json").getInputStream();
        List<Person> personList = objectMapper.readValue(inputStreamP, new TypeReference<>() {
        });
        personRepository.saveAll(personList);
        System.out.println("Saved personList to database!");


        InputStream inputStreamS = new ClassPathResource("json/badania.json").getInputStream();
        List<Study> studyList = objectMapper.readValue(inputStreamS, new TypeReference<>() {
        });
        studyRepository.saveAll(studyList);
        System.out.println("Saved studyList to database!");

//        List<College> collegeList = getList("uczelnie");
//        collegeRepository.saveAll(collegeList);
//        System.out.println("Saved collegeList to database!");
//
//        List<Person> personList = getList("osoby");
//        personRepository.saveAll(personList);
//        System.out.println("Saved personList to database!");
//
//        List<Study> studyList = getList("badania");
//        studyRepository.saveAll(studyList);
//        System.out.println("Saved studyList to database!");
    }

    private <T> List<T> getList(String fileName) throws IOException {
        InputStream inputStream = new ClassPathResource("json/" + fileName + ".json").getInputStream();

        return objectMapper.readValue(
                inputStream,
                new TypeReference<>() {
                }
        );
    }
}
