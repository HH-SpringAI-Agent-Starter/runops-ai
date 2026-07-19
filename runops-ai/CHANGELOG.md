# Changelog

## [0.1.1] - 2026-07-19

### Maintenance
- Automated weekly rotation maintenance
- Verified all project files integrity (README, docs, config, pom)
- Confirmed docker-compose infrastructure works with Spring Boot 4.0 + Ollama stack
- All 4 Agent modules (Log Analyzer, Fault Diagnostic, Alert Aggregator, Script Generator) operational
- CHANGELOG alignment with current project state

## [0.1.0] - 2026-07-05

### Added
- Initial open-source release of RunOps AI Community Edition
- Spring Boot 4.0 + Spring AI 2.0.0 foundation
- Agent Tool Calling framework with 7 domain tools:
  - Prometheus query
  - Alertmanager alerts query
  - Loki log search
  - Kubernetes workload inspect
  - Knowledge base search (RAG)
  - Runbook search
  - Ticket draft creation
- PGVector vector store for RAG-based knowledge retrieval
- ChatClient-based Agent orchestrator with domain system prompt
- Multi-tenant support via ThreadLocal + request filter
- REST API endpoints: /api/agent/ask, /api/kb/sync, /api/kb/search
- Docker Compose: PostgreSQL (PGVector), Redis, MinIO, Prometheus
- CI workflow (Maven build on push/PR)
- Architecture: Agent + Tool Registry + RAG + External Systems
