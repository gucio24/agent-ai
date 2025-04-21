package com.rutkowski.agent_ai.Service;

import com.rutkowski.agent_ai.Entity.Study;
import com.rutkowski.agent_ai.Repository.CollegeRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.rutkowski.agent_ai.Tools.StaticTools.*;

@Service
public class InstitutionService {

    private final CollegeRepository collegeRepository;

    public InstitutionService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public String getInstitutionData(String params) {

        return collegeRepository.findAll()
                .stream()
                .filter(c -> c.getMiasto().equals(CITY))
                .map(c ->
                        c.getNazwa()
                                + SPACE
                                + String.join(DELIMITER_SPACE, c.getStudies()
                                .stream()
                                .map(Study::getSponsor)
                                .collect(Collectors.joining(DELIMITER_SPACE))))
                .collect(Collectors.joining(DELIMITER_SPACE));

//        collegeRepository.findAll()
//                .stream()
//                .filter(c -> c.getMiasto().equals(StaticTools.CITY))
//                .forEach(System.out::println);
//        return params;
    }

}
