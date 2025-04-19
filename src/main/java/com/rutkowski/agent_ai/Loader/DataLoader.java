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
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataLoader implements CommandLineRunner {

    public static final String JSON_DIR = "json/";
    public static final String JSON_EXTENSION = ".json";

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

        List<College> collegeList = getList("uczelnie", new TypeReference<>() {
        });
        collegeRepository.saveAll(collegeList);
        System.out.println("Saved collegeList to database!");

        Map<String, College> collegeMap = collegeList.stream().collect(Collectors.toMap(College::getId, college -> college));

        List<Person> personList = getList("osoby", new TypeReference<>() {
        });
        personList.forEach(p -> p.setCollege(collegeMap.get(p.getUczelnia())));
        personRepository.saveAll(personList);
        System.out.println("Saved personList to database!");

        List<Study> studyList = getList("badania", new TypeReference<>() {
        });
        studyList.forEach(s -> s.setCollege(collegeMap.get(s.getUczelnia())));
        studyRepository.saveAll(studyList);
        System.out.println("Saved studyList to database!");

    }

    private static InputStream getInputStream(String fileName) throws IOException {
        return new ClassPathResource(JSON_DIR + fileName + JSON_EXTENSION).getInputStream();
    }

    private <T> T getList(String fileName, TypeReference<T> typeRef) throws IOException {
        InputStream inputStream = getInputStream(fileName);

        return objectMapper.readValue(
                inputStream,
                typeRef
        );
    }
}
