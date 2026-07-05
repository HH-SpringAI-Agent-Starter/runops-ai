# Requirements — RunOps AI Community Edition

## 1. Product Overview
RunOps AI is a Spring AI Agent + RAG system for IT operations teams.
It enables natural-language interaction with monitoring, logging, Kubernetes, and
ticketing systems.

## 2. Functional Requirements

### 2.1 Agent Operations Chat
- FR-1.1: Natural language question → structured operation answer
- FR-1.2: Tool invocation for 7 operation domains
- FR-1.3: Risk-level annotation
- FR-1.4: Session-based conversation context

### 2.2 Monitoring Integration
- FR-2.1: Prometheus metric query
- FR-2.2: Alertmanager alert aggregation
- FR-2.3: Alert deduplication and root-cause analysis

### 2.3 Logging Integration
- FR-3.1: Loki log search
- FR-3.2: Log pattern extraction
- FR-3.3: Time-range constrained queries

### 2.4 Kubernetes Integration
- FR-4.1: Workload inspect
- FR-4.2: Pod status diagnosis
- FR-4.3: Resource utilization overview

### 2.5 Knowledge Base (RAG)
- FR-5.1: Document upload → chunking → embedding → PGVector
- FR-5.2: Semantic search with tenant isolation
- FR-5.3: Citation tracking

### 2.6 Runbook & Ticketing
- FR-6.1: Runbook search by incident type
- FR-6.2: Draft ticket creation

### 2.7 Multi-Tenancy
- FR-7.1: X-Tenant-Id header isolation
- FR-7.2: Tenant-scoped RAG

## 3. Tech Stack
| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot 4.0 + Spring AI 2.0.0 |
| LLM | Ollama (qwen2.5:7b) |
| Vector Store | PGVector |
| Cache | Redis 7 |
| Object Store | MinIO |
| Monitoring | Prometheus |
| Database | PostgreSQL 16 |
| CI | GitHub Actions |

## 4. Data Flow
User → REST API → AgentController → AgentService → ChatClient → Tools/External Systems + RAG → LLM → Structured Answer
