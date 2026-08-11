# Changelog

## [0.1.1] - 2026-08-11

### Maintenance
- Automated weekly rotation maintenance
- Added root-level LICENSE (Apache-2.0), CONTRIBUTING.md, requirements.md
- README architecture diagram / tech stack verified complete

## [0.1.0] - 2026-07-05

### Added
- Initial open-source release of RunOps AI Community Edition
- Spring Boot 4.0 + Spring AI 2.0.0 foundation
- Agent Tool Calling framework with 7 domain tools
- PGVector vector store for RAG-based knowledge retrieval
- Multi-tenant support via ThreadLocal + request filter
- REST API endpoints: /api/agent/ask, /api/kb/sync, /api/kb/search
- Docker Compose: PostgreSQL (PGVector), Redis, MinIO, Prometheus
