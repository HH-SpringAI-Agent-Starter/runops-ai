# Contributing to RunOps AI

感谢参与 **RunOps AI**（智能运维 AI Agent）开源社区。以下是贡献指南，请先阅读再提交 PR。

## 开发环境

- JDK 21+ · Maven 3.9+ · Docker · Ollama（qwen2.5:7b）
- 本地启动：`docker compose up -d postgres redis minio` + `ollama pull qwen2.5:7b` + `mvn spring-boot:run`

## 代码规范

- 所有外部系统写操作必须先创建草稿或进入审批流程（例如工单创建、脚本执行）。
- RAG 检索必须返回引用来源（citation），禁止无来源回答。
- 新增工具必须补充：工具描述、单元测试、安全说明（权限/敏感数据）。
- 禁止提交 API Key、客户数据或敏感日志到仓库。
- Java 代码遵循 Spring Boot 官方风格，类与方法必须有 Javadoc 说明。

## 分支与 PR 流程

1. Fork 仓库，从 `master` 创建功能分支：`feature/<描述>` 或 `fix/<描述>`。
2. 提交前运行 `mvn test` 确保测试通过。
3. 提交信息遵循 Conventional Commits（`feat:` / `fix:` / `docs:` / `chore:`）。
4. 发起 PR 到 `master`，描述：改动内容、测试结果、是否涉及企业版能力。
5. 维护者 review 后合并，重要变更同步更新 CHANGELOG.md。

## 新增 Tool 清单（欢迎贡献）

- Grafana 面板查询工具
- 云厂商（AWS/GCP/阿里云）资源诊断工具
- 日志模式自动聚类工具
- 故障时间线自动生成工具

## Issue 模板建议

- 场景描述
- 输入示例
- 期望输出
- 涉及连接器（Prometheus/Loki/K8s/工单系统）
- 是否需要企业版能力
