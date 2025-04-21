package com.rutkowski.agent_ai.Controller;

import com.rutkowski.agent_ai.Model.Input;
import com.rutkowski.agent_ai.Model.Output;
import com.rutkowski.agent_ai.Service.InstitutionService;
import com.rutkowski.agent_ai.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    public static final String TEST = "test";

    private final PersonService personService;
    private final InstitutionService institutionService;

    public ToolsController(PersonService personService, InstitutionService institutionService) {
        this.personService = personService;
        this.institutionService = institutionService;
    }


    @GetMapping
    ResponseEntity<String> getString() {
        return ResponseEntity.ok("Agent AI");
    }

    @PostMapping("/tool1")
    ResponseEntity<Output> postTool1(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getOutputResponse(input.getInput()));
        }

        String txt = personService.getPersonData(input.getParams());

        return ResponseEntity.ok(getOutputResponse(txt));
    }

    private Output getOutputResponse(String txt) {
        return new Output(txt);
    }


    @PostMapping("/tool2")
    ResponseEntity<Output> postTool2(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getOutputResponse(input.getInput()));
        }

        String txt = institutionService.getInstitutionData(input.getParams());

        return ResponseEntity.ok(getOutputResponse(txt));

    }
}