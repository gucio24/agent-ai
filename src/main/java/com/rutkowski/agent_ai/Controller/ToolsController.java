package com.rutkowski.agent_ai.Controller;

import com.rutkowski.agent_ai.Model.Input;
import com.rutkowski.agent_ai.Model.Output;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    @GetMapping
    ResponseEntity<String> getString() {
        return ResponseEntity.ok("Agent AI");
    }

    @PostMapping("/tool1")
    ResponseEntity<Output> postTool1(@RequestBody Input input) {
        Output output = new Output(input.getInput());
        return ResponseEntity.ok(output);
    }

    @PostMapping("/tool2")
    ResponseEntity<Output> postTool2(@RequestBody Input input) {
        Output output = new Output(input.getInput());
        return ResponseEntity.ok(output);
    }

}