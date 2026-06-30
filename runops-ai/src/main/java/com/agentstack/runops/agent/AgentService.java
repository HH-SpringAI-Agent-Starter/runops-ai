package com.agentstack.runops.agent;

import com.agentstack.runops.dto.AgentRequest;
import com.agentstack.runops.dto.AgentResponse;
import com.agentstack.runops.tools.DomainTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AgentService {
    private final ChatClient chatClient;
    private final DomainTools domainTools;

    public AgentService(ChatClient chatClient, DomainTools domainTools) {
        this.chatClient = chatClient;
        this.domainTools = domainTools;
    }

    public AgentResponse ask(AgentRequest request) {
        String prompt = """
                场景：IT运维助手
                用户问题：%s

                请按以下格式回答：
                1. 结论
                2. 依据/引用
                3. 需要调用或已经调用的工具
                4. 风险提示
                5. 下一步建议
                """.formatted(request.question());

        String answer = chatClient.prompt()
                .user(prompt)
                .tools(domainTools)
                .call()
                .content();

        return new AgentResponse(
                answer,
                List.of("kb://demo/sample"),
                List.of("prometheus_query", "alertmanager_alerts", "loki_log_search", "kubernetes_workload_inspect", "runbook_search", "ticket_draft_create"),
                "medium",
                UUID.randomUUID().toString()
        );
    }
}
