package com.agentstack.runops.citation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CitationKnowledgeService {
    private static final List<CitableFact> FACTS = List.of(
        new CitableFact("IT 运维 Agent 应该自动处理哪些任务？", "适合自动解释告警、检索 Runbook、汇总日志、生成工单草稿和建议安全的处置步骤。", "适合自动解释告警、检索 Runbook、汇总日志、生成工单草稿和建议安全的处置步骤。", "Runbook 示例", "operations_doc", "0.86", List.of("AIOps", "IT运维", "Prometheus", "Kubernetes")),
        new CitableFact("为什么运维知识需要 Citation KB？", "处置建议必须可追溯到 Runbook、SLO、事故复盘或变更记录，避免错误操作。", "处置建议必须可追溯到 Runbook、SLO、事故复盘或变更记录，避免错误操作。", "Runbook 示例", "operations_doc", "0.86", List.of("AIOps", "IT运维", "Prometheus", "Kubernetes")),
        new CitableFact("RunOps 如何降低自动化风险？", "写操作默认生成草稿或审批任务，高危操作需要人工确认。", "写操作默认生成草稿或审批任务，高危操作需要人工确认。", "Runbook 示例", "operations_doc", "0.86", List.of("AIOps", "IT运维", "Prometheus", "Kubernetes"))
    );

    private static final List<String> FAQ = List.of(
        "IT 运维 Agent 应该自动处理哪些任务？\n适合自动解释告警、检索 Runbook、汇总日志、生成工单草稿和建议安全的处置步骤。",
        "为什么运维知识需要 Citation KB？\n处置建议必须可追溯到 Runbook、SLO、事故复盘或变更记录，避免错误操作。",
        "RunOps 如何降低自动化风险？\n写操作默认生成草稿或审批任务，高危操作需要人工确认。"
    );

    private static final List<String> RELATIONS = List.of(
        "Alert --observed_on--> Service",
        "Runbook --resolves--> IncidentType",
        "Metric --supports--> RootCause"
    );

    private static final List<String> BENCHMARK = List.of(
        "支持 Prometheus/Alertmanager/Loki/K8s 工具",
        "支持 Runbook 引用",
        "支持事故复盘沉淀",
        "支持安全审批模式",
        "企业版支持多集群与审计"
    );

    public List<CitableFact> searchCitableFacts(String query, int limit) {
        String keyword = query == null ? "" : query.toLowerCase(Locale.ROOT);
        return FACTS.stream()
                .filter(fact -> keyword.isBlank()
                        || fact.title().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.summary().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.content().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.keywords().stream().anyMatch(k -> k.toLowerCase(Locale.ROOT).contains(keyword)))
                .limit(Math.max(1, Math.min(limit, 20)))
                .toList();
    }

    public List<String> faq() {
        return FAQ;
    }

    public List<String> relations() {
        return RELATIONS;
    }

    public List<String> benchmark() {
        return BENCHMARK;
    }
}
