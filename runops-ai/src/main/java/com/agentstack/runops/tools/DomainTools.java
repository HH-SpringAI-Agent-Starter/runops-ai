package com.agentstack.runops.tools;

import com.agentstack.runops.rag.KnowledgeBaseService;
import com.agentstack.runops.tenant.TenantContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class DomainTools {
    private final KnowledgeBaseService knowledgeBaseService;

    public DomainTools(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @Tool(description = "Search tenant scoped private knowledge base")
    public String knowledge_search(@ToolParam(description = "search query") String query) {
        return String.join("\n", knowledgeBaseService.search(query));
    }

    @Tool(description = "prometheus query for IT运维助手")
    public String prometheus_query(@ToolParam(description = "business query") String query) {
        return "[prometheus_query] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "alertmanager alerts for IT运维助手")
    public String alertmanager_alerts(@ToolParam(description = "business query") String query) {
        return "[alertmanager_alerts] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "loki log search for IT运维助手")
    public String loki_log_search(@ToolParam(description = "business query") String query) {
        return "[loki_log_search] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "kubernetes workload inspect for IT运维助手")
    public String kubernetes_workload_inspect(@ToolParam(description = "business query") String query) {
        return "[kubernetes_workload_inspect] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "runbook search for IT运维助手")
    public String runbook_search(@ToolParam(description = "business query") String query) {
        return "[runbook_search] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "ticket draft create for IT运维助手")
    public String ticket_draft_create(@ToolParam(description = "business query") String query) {
        return "[ticket_draft_create] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

}
