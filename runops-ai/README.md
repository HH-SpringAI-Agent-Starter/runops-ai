# RunOps AI Community

        SRE / DevOps 告警处理 Agent：基于 **Spring AI 2.0 + Agent Tool Calling + PGVector RAG + Ollama** 的IT运维助手项目模板。

        > 风险提示：生产处置动作默认生成 Runbook 建议或工单草稿，不自动执行破坏性命令。

        ## 场景定位

        赋予 Agent 调用监控、日志、Kubernetes、工单系统的能力，实现告警解释、Runbook 检索、自动建单和安全处置建议。

        ## 版本定位：开源版


- 单租户或轻量租户 Header 演示
- 本地 Ollama 模型，适合开发和 Demo
- 基础 RAG 知识库、基础工具调用、REST API
- Apache-2.0 友好的开源项目结构
- 可作为 Open Core 的免费获客漏斗

        ## 核心能力

        - Spring AI `ChatClient` Agent 编排
        - `@Tool` 工具调用
        - PGVector 私有知识库 RAG
        - Ollama 本地模型默认配置
        - Docker Compose 一键启动基础设施
        - Flyway 数据库初始化
        - Prometheus / Actuator 可观测性

        ## 工具清单

        - `prometheus_query`
- `alertmanager_alerts`
- `loki_log_search`
- `kubernetes_workload_inspect`
- `runbook_search`
- `ticket_draft_create`

        ## 连接器方向

        - Prometheus
- Alertmanager
- Grafana Loki
- Kubernetes API
- Jira/禅道/飞书工单

        ## API

        | Method | Path | Description |
        |---|---|---|
        | POST | `/api/agent/ask` | 运维问答与处置建议 |
| POST | `/api/alerts/analyze` | 分析告警根因与影响范围 |
| POST | `/api/tickets/create` | 创建工单草稿 |
        | POST | `/api/kb/sync` | 同步知识库 |
        | GET | `/api/kb/search?q=` | 检索知识库 |

        ## 本地运行

        ```bash
        cp .env.example .env
        docker compose up -d
        ollama pull qwen2.5:7b
        ollama pull mxbai-embed-large
        mvn spring-boot:run
        ```

        ## 示例调用

        ```bash
        curl -s -X POST http://localhost:8080/api/agent/ask \
          -H 'Content-Type: application/json' \
          -H 'X-Tenant-Id: demo' \
          -d '{
            "question": "支付服务 P99 延迟突然升高，帮我判断可能原因并生成处置步骤。",
            "userId": "u_1001",
            "sessionId": "s_demo"
          }' | jq
        ```

        ## 目录结构

        ```text
        src/main/java/.../agent        Agent 编排
        src/main/java/.../tools        工具调用
        src/main/java/.../rag          RAG 服务
        src/main/java/.../tenant       多租户上下文
        src/main/resources/kb          示例知识库
        src/main/resources/db          Flyway 初始化 SQL
        docs/                          架构、API、部署、定价、演示脚本
        ```

        ## GitHub 上传

        ```bash
        git init
        git add .
        git commit -m "Initial commit: RunOps AI Community"
        gh repo create runops-ai --public --source=. --remote=origin --push
        ```
