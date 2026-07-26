package com.agentstack.runops.tools;

import com.agentstack.runops.rag.KnowledgeBaseService;
import com.agentstack.runops.tenant.TenantContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DomainTools {
    private final KnowledgeBaseService knowledgeBaseService;

    public DomainTools(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @Tool(description = "Search tenant-scoped operations knowledge base (RAG) for runbooks and documentation")
    public String knowledge_search(@ToolParam(description = "Natural language search query") String query) {
        List<String> results = knowledgeBaseService.search(query);
        if (results.isEmpty()) {
            return "No results found in knowledge base for: " + query;
        }
        return String.join("\n---\n", results);
    }

    @Tool(description = "Query Prometheus metrics for real-time monitoring data (CPU, memory, latency, error rate)")
    public String prometheus_query(@ToolParam(description = "PromQL query string") String query) {
        return String.format(
            "[prometheus_query] tenant=%s | time=%s | query=%s | result=demo stub",
            TenantContext.getTenantId(), LocalDateTime.now(), query
        );
    }

    @Tool(description = "Fetch and aggregate alerts from Alertmanager with severity filtering")
    public String alertmanager_alerts(@ToolParam(description = "Severity filter: critical/warning/info") String severity) {
        return String.format(
            "[alertmanager_alerts] tenant=%s | time=%s | severity=%s | result=demo stub",
            TenantContext.getTenantId(), LocalDateTime.now(), severity
        );
    }

    @Tool(description = "Search and analyze application logs via Loki with time range support")
    public String loki_log_search(
            @ToolParam(description = "LogQL query or search term") String query,
            @ToolParam(description = "Time range in minutes (default: 60)") int timeRangeMinutes) {
        return String.format(
            "[loki_log_search] tenant=%s | time=%s | query=%s | range=%dmin | result=demo stub",
            TenantContext.getTenantId(), LocalDateTime.now(), query, timeRangeMinutes
        );
    }

    @Tool(description = "Inspect Kubernetes workloads: pods, deployments, and services status")
    public String kubernetes_workload_inspect(@ToolParam(description = "Resource type: pods/deployments/services") String resourceType) {
        return String.format(
            "[kubernetes_inspect] tenant=%s | time=%s | resource=%s | result=demo stub",
            TenantContext.getTenantId(), LocalDateTime.now(), resourceType
        );
    }

    @Tool(description = "Search operations runbooks by incident type or symptom")
    public String runbook_search(@ToolParam(description = "Symptom or incident type to search for") String symptom) {
        List<String> kbResults = knowledgeBaseService.search(symptom);
        String kb = kbResults.isEmpty() ? "No runbook found" : String.join("\n---\n", kbResults);
        return String.format("[runbook_search] tenant=%s | symptom=%s\nResults:\n%s", TenantContext.getTenantId(), symptom, kb);
    }

    @Tool(description = "Draft a new operations ticket for incident tracking")
    public String ticket_draft_create(
            @ToolParam(description = "Incident title") String title,
            @ToolParam(description = "Detailed description of the incident") String description,
            @ToolParam(description = "Severity level: P0/P1/P2/P3") String severity) {
        String ticketId = "TKT-" + java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return String.format(
            "[ticket_draft] tenant=%s | ticket=%s | severity=%s | title=%s | status=draft",
            TenantContext.getTenantId(), ticketId, severity, title
        );
    }

    @Tool(description = "Check system status and connected service health")
    public String system_status() {
        return String.format(
            "[system_status] tenant=%s | time=%s | mode=demo (Prometheus/Loki/K8s stubs)",
            TenantContext.getTenantId(), LocalDateTime.now()
        );
    }
}