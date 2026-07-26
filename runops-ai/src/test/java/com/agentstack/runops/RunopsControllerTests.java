package com.agentstack.runops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RunopsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthCheck() throws Exception {
        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void agentChatEndpoint() throws Exception {
        String request = """
                {
                    "question": "检查生产环境数据库状态",
                    "tenantId": "demo-tenant"
                }
                """;
        mockMvc.perform(post("/api/agent/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").isString())
                .andExpect(jsonPath("$.riskLevel").isString());
    }

    @Test
    void knowledgeBaseSearch() throws Exception {
        mockMvc.perform(get("/api/knowledge/search")
                        .param("q", "数据库故障")
                        .header("X-Tenant-Id", "demo-tenant"))
                .andExpect(status().isOk());
    }
}