package com.rutkowski.agent_ai.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComplexOutput {
    private String action;
    private String value;
    private String params;
}
