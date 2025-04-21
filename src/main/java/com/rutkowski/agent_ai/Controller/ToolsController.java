package com.rutkowski.agent_ai.Controller;

import com.rutkowski.agent_ai.Model.Input;
import com.rutkowski.agent_ai.Model.Output;
import com.rutkowski.agent_ai.Service.InstitutionService;
import com.rutkowski.agent_ai.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.rutkowski.agent_ai.Tools.StaticTools.*;

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
    ResponseEntity<Map<String, String>> postTool1(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = personService.getPersonData(input.getParams());

        return ResponseEntity.ok(getMapResponse(txt, VALUE_TOOL_1));
    }

    @PostMapping("/tool2")
    ResponseEntity<Map<String, String>> postTool2(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = institutionService.getInstitutionData(input.getParams());

        return ResponseEntity.ok(getMapResponse(txt, VALUE_TOOL_2));

    }


    private Output getOutputResponse(String txt) {
        return new Output(txt);
    }

    private Map<String, String> getMapTestResponse(String txt) {
        Map<String, String> response = new HashMap<>();
        response.put(NAME_OUTPUT, txt);
        return response;
    }

    private Map<String, String> getMapResponse(String txt, String toolValue) {
        Map<String, String> response = new HashMap<>();
        response.put(NAME_ACTION, ACTION_USETOOL);
        response.put(NAME_VALUE, toolValue);
        response.put(NAME_PARAMS, txt);
        return response;
    }

}