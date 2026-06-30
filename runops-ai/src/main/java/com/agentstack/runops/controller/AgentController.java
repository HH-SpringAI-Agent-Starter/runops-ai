package com.agentstack.runops.controller;

import com.agentstack.runops.agent.AgentService;
import com.agentstack.runops.dto.AgentRequest;
import com.agentstack.runops.dto.AgentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/ask")
    public AgentResponse ask(@RequestBody AgentRequest request) {
        return agentService.ask(request);
    }
}
