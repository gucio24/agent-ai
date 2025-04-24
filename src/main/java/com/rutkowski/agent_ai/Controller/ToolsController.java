package com.rutkowski.agent_ai.Controller;

import com.rutkowski.agent_ai.Model.ComplexOutput;
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
    ResponseEntity<Map<String, Object>> postTool1(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = personService.getPersonData(input.getParams());

        return ResponseEntity.ok(getMapResponse(txt, VALUE_TOOL_1));
    }

    @PostMapping("/tool2")
    ResponseEntity<Map<String, Object>> postTool2(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = institutionService.getInstitutionData(input.getParams());

        return ResponseEntity.ok(getMapResponse(txt, VALUE_TOOL_2));

    }

    @PostMapping("/tool3")
    ResponseEntity<Output> postTool3(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getOutputResponse(input.getInput()));
        }

        String txt = personService.getPersonData(input.getParams());

        return ResponseEntity.ok(getOutputResponse(txt));
    }

    @PostMapping("/tool4")
    ResponseEntity<Output> postTool4(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getOutputResponse(input.getInput()));
        }

        String txt = institutionService.getInstitutionData(input.getParams());

        return ResponseEntity.ok(getOutputResponse(txt));

    }

    @PostMapping("/tool5")
    ResponseEntity<Map<String, Object>> postTool5(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = personService.getPersonData(input.getParams());

        return ResponseEntity.ok(getMapResponseComplexOutput(txt, VALUE_TOOL_1));
    }

    @PostMapping("/tool6")
    ResponseEntity<Map<String, Object>> postTool6(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            return ResponseEntity.ok(getMapTestResponse(input.getInput()));
        }

        String txt = institutionService.getInstitutionData(input.getParams());

        return ResponseEntity.ok(getMapResponseComplexOutput(txt, VALUE_TOOL_2));

    }


    private Output getOutputResponse(String txt) {
        return new Output(txt);
    }

    private Map<String, Object> getMapTestResponse(String txt) {
        Map<String, Object> response = new HashMap<>();
        response.put(NAME_OUTPUT, txt);
        return response;
    }

    private Map<String, Object> getMapResponse(String txt, String toolValue) {
        Map<String, Object> response = new HashMap<>();
        response.put(NAME_ACTION, ACTION_USETOOL);
        response.put(NAME_VALUE, toolValue);
        response.put(NAME_PARAMS, txt);
        return response;
    }

    private Map<String, Object> getMapResponseComplexOutput(String txt, String toolValue) {
        Map<String, Object> response = new HashMap<>();
        ComplexOutput complexOutput = new ComplexOutput(ACTION_USETOOL, toolValue, txt);
        response.put(NAME_OUTPUT, complexOutput);
        return response;
    }

}