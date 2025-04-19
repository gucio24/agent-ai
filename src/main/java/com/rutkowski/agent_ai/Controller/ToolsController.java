package com.rutkowski.agent_ai.Controller;

import com.rutkowski.agent_ai.Model.Input;
import com.rutkowski.agent_ai.Model.Output;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    public static final String TEST = "test";

    @GetMapping
    ResponseEntity<String> getString() {
        return ResponseEntity.ok("Agent AI");
    }

    @PostMapping("/tool1")
    ResponseEntity<Output> postTool1(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            Output output = new Output(input.getInput());
            return ResponseEntity.ok(output);
        }

        return ResponseEntity.ok().build();

    }

    @PostMapping("/tool2")
    ResponseEntity<Output> postTool2(@RequestBody Input input) {

        if (input.getInput().startsWith(TEST)) {
            Output output = new Output(input.getInput());
            return ResponseEntity.ok(output);
        }

        return ResponseEntity.ok().build();

    }
}