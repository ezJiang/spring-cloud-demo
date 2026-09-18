# GitHub 上的 Spring Cloud 框架项目清单（梳理）

> 整理时间：2026-09-18。星标数为近似快照，实际以 GitHub 实时为准。
> 分类：① 官方子项目（spring-cloud 组织）② Spring Cloud Alibaba 生态 ③ 国内主流微服务脚手架 ④ 学习/精简实现。

## 一、官方子项目（github.com/spring-cloud）

Spring Cloud 官方把每个能力拆成独立仓库，统一由 `spring-cloud-release`（版本列车）做依赖管理。常用的「核心组件」仓库：

| 仓库 | 用途 | 状态 |
| --- | --- | --- |
| [spring-cloud-netflix](https://github.com/spring-cloud/spring-cloud-netflix) | Eureka 注册中心、Netflix OSS 集成（⭐~5k） | Eureka 在 2023.0.x/2024.0.x 仍维护；Ribbon/Hystrix/Zuul 已移除 |
| [spring-cloud-gateway](https://github.com/spring-cloud/spring-cloud-gateway) | 响应式 API 网关（⭐~4.9k） | 主流网关，替代 Zuul |
| [spring-cloud-config](https://github.com/spring-cloud/spring-cloud-config) | 集中配置中心（⭐~2k） | 活跃 |
| [spring-cloud-openfeign](https://github.com/spring-cloud/spring-cloud-openfeign) | 声明式 HTTP 客户端（⭐~1.3k） | 活跃，默认集成负载均衡 |
| [spring-cloud-loadbalancer](https://github.com/spring-cloud/spring-cloud-commons) | 客户端负载均衡（属 spring-cloud-commons） | 替代 Ribbon |
| [spring-cloud-circuitbreaker](https://github.com/spring-cloud/spring-cloud-circuitbreaker) | 熔断抽象，默认 Resilience4j | 活跃 |
| [spring-cloud-sleuth](https://github.com/spring-cloud/spring-cloud-sleuth) | 分布式链路追踪（⭐~1.8k） | **已废弃**，迁移到 Micrometer Tracing + Zipkin |
| [spring-cloud-stream](https://github.com/spring-cloud/spring-cloud-stream) | 消息驱动的event-driven 微服务（⭐~1.1k） | 活跃 |
| [spring-cloud-consul](https://github.com/spring-cloud/spring-cloud-consul) | 基于 Consul 的注册/配置（⭐~824） | 活跃 |
| [spring-cloud-zookeeper](https://github.com/spring-cloud/spring-cloud-zookeeper) | 基于 Zookeeper 的注册/配置（⭐~571） | 活跃 |
| [spring-cloud-kubernetes](https://github.com/spring-cloud/spring-cloud-kubernetes) | K8s 服务发现/配置（⭐~3.5k） | 云原生场景 |
| [spring-cloud-vault](https://github.com/spring-cloud/spring-cloud-vault) | 配置加密（HashiCorp Vault） | 活跃 |
| [spring-cloud-contract](https://github.com/spring-cloud/spring-cloud-contract) | 消费者驱动契约测试 | 活跃 |
| [spring-cloud-task](https://github.com/spring-cloud/spring-cloud-task) | 短生命周期微服务/批处理 | 活跃 |
| [spring-cloud-function](https://github.com/spring-cloud/spring-cloud-function) | Serverless/FaaS 函数式 | 活跃 |
| [spring-cloud-bus](https://github.com/spring-cloud/spring-cloud-bus) | 消息总线（配合 Config 动态刷新） | 活跃 |
| [spring-cloud-release](https://github.com/spring-cloud/spring-cloud-release) | 版本列车/依赖管理（BOM） | 必看，决定各组件兼容版本 |

> 版本列车参考：2023.0.x（Leyton）→ Boot 3.2/3.3；2024.0.x（Coruscant）→ Boot 3.4；2025.0.x（Northfields）→ Boot 3.5（**已移除 Eureka**，建议新项目用 Nacos/Consul）。

## 二、Spring Cloud Alibaba 生态（github.com/alibaba/spring-cloud-alibaba）

| 仓库 | 用途 | 星标 |
| --- | --- | --- |
| [spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba) | 一站式分布式解决方案（⭐~29k） | 含 Nacos/Sentinel/Seata/RocketMQ/Dubbo |
| └ Nacos | 注册中心 + 配置中心（动态配置、服务发现） | 国内最常用注册/配置中心 |
| └ Sentinel | 流量控制、熔断降级、系统保护 | 替代 Hystrix |
| └ Seata | 分布式事务（AT/TCC/SAGA） | 主流方案 |
| └ RocketMQ | 消息队列 | 事件/解耦 |
| └ Dubbo | RPC 框架 | 可替代 Feign 做内部调用 |

## 三、国内主流微服务脚手架（开箱即用的中后台/权限系统）

这些是基于 Spring Cloud（多为 Alibaba 体系）+ Vue 的「全家桶」框架，适合直接二次开发：

| 项目 | 地址 | 星标 | 特点 |
| --- | --- | --- | --- |
| JeecgBoot | [jeecgboot/JeecgBoot](https://github.com/jeecgboot/JeecgBoot) | ⭐~46k | AI 低代码平台，支持低代码+零代码、微服务版本 |
| RuoYi-Cloud（若依） | [yangzongzhuan/RuoYi-Cloud](https://github.com/yangzongzhuan/RuoYi-Cloud) | ⭐~18.8k | Spring Cloud Alibaba + Vue，RBAC、多租户、工作流 |
| pig | [pig-mesh/pig](https://github.com/pig-mesh/pig) | ⭐~6.6k | RBAC 权限系统，Spring Cloud + OAuth2 |
| lamp-cloud（灯灯） | [dromara/lamp-cloud](https://github.com/dromara/lamp-cloud) | 多租户 SaaS | 支持 JDK21/17/8，多种租户隔离方案 |
| RuoYi-Vue-Plus | [dromara/RuoYi-Vue-Plus](https://github.com/dromara/RuoYi-Vue-Plus) | ⭐~2.1k+ | 若依增强版（Mybatis-Plus、Undertow、Knife4j 等） |
| SpringBlade | [chillzhu/SpringBlade](https://github.com/chillzhu/SpringBlade) | 前后端分离微服务 | 多租户、前后端分离 |
| jbone | [417511458/jbone](https://github.com/417511458/jbone) | ⭐~1k | 中小企业微服务基础骨架（注册、监控、调用链等） |

## 四、学习 / 精简实现（理解原理用）

| 项目 | 地址 | 用途 |
| --- | --- | --- |
| sample-spring-microservices-new | [piomin/sample-spring-microservices-new](https://github.com/piomin/sample-spring-microservices-new) | ⭐~1.4k 完整微服务示例（Config+Eureka+Gateway+Sleuth） |
| mini-spring-cloud / tiny-spring-cloud | 社区多个手写精简版 | 从零实现一个迷你 Spring Cloud，理解注册/发现/路由原理 |

## 五、选型速查（新项目怎么选）

- **注册/配置中心**：国内首选 Nacos（spring-cloud-alibaba）；纯官方栈用 Eureka（仅 2024.0.x 及以下）或 Consul。
- **网关**：Spring Cloud Gateway（响应式，主流）。
- **服务调用**：OpenFeign + spring-cloud-loadbalancer（负载均衡）。
- **熔断限流**：Resilience4j（官方 circuitbreaker）或 Sentinel（Alibaba）。
- **分布式事务**：Seata（Alibaba）。
- **链路追踪**：Micrometer Tracing + Zipkin（Sleuth 已废弃）。

> 注意 EOL：Netflix Ribbon/Hystrix/Zuul、Spring Cloud Sleuth 均已不再推荐；新项目请避开这些。

## 六、典型应用场景（组件 → 业务）

Spring Cloud 不是单一框架，而是一组「分布式系统常见模式」的实现。按场景对号入座：

| 场景 | 用到的组件 | 说明 |
| --- | --- | --- |
| 中台/后台管理系统（RBAC、多租户） | 注册中心 + Gateway + 各业务微服务 + 配置中心 | 若依/RuoYi-Cloud、pig、JeecgBoot 的典型形态 |
| 高并发读场景的横向扩容 | Eureka/Consul/Nacos + 负载均衡 | 同一服务多实例，网关与 Feign 自动负载均衡 |
| 多端接入（Web/小程序/App 统一入口） | Spring Cloud Gateway | 统一鉴权、限流、路由、灰度 |
| 服务间同步调用、聚合编排 | OpenFeign + LoadBalancer | 订单服务调用户服务、库存服务等 |
| 熔断降级、保护核心链路 | Resilience4j / Sentinel | 下游超时/异常时不拖垮调用方 |
| 配置集中管理与动态刷新 | Config / Nacos | 改配置不重启，结合 Bus 批量推送 |
| 链路追踪 / 排障 | Micrometer Tracing + Zipkin | 跨服务一次请求全貌，定位慢调用 |
| 事件驱动 / 异步解耦 | Spring Cloud Stream + MQ（Kafka/RocketMQ） | 下单后发事件，库存、积分、通知异步消费 |
| 分布式事务 | Seata（Alibaba） | 下单+扣库存+扣余额的一致性 |
| 短任务 / 批处理 | Spring Cloud Task + Batch | 报表、对账等一次性作业 |
| 云原生（K8s）部署 | spring-cloud-kubernetes | 直接用 K8s Service 做服务发现、ConfigMap 做配置 |
| 多语言/异构系统接入 | Sidecar / Consul Connect | 非 JVM 服务纳入治理体系 |
| 契约测试（前后端/服务间联调） | Spring Cloud Contract | 提供方按契约驱动，消费方 stub 自测 |

### 本仓库 demo 与场景的对应关系

`spring-cloud-demo` 演示了前 4 类最基础也最常用的场景：
- **服务注册发现**（Eureka）→ 所有服务启动后自动上报、互相可见
- **API 网关统一入口**（Gateway `lb://`）→ 对外只暴露 8080，内部服务走服务名
- **声明式服务调用**（OpenFeign）→ order-service 像调本地方法一样调 user-service
- **客户端负载均衡**（LoadBalancer）→ 多实例时自动分发

进阶场景（熔断、配置中心、链路追踪、事务、Stream）见上文「扩展建议」与官方仓库。

## 七、怎么开始（给不同人群的路线）

- **想直接跑通看懂**：用本仓库 `spring-cloud-demo`（见 README），先理解注册中心→服务→网关的调用链。
- **想做企业后台系统**：基于 RuoYi-Cloud / pig / JeecgBoot 二次开发，省去权限、代码生成等重复工作。
- **想深入原理**：读 `spring-cloud-*` 官方仓库源码，或手写 mini-spring-cloud / tiny-spring-cloud。
- **生产选型**：注册/配置用 Nacos；网关用 Gateway；调用用 OpenFeign；限流用 Sentinel；事务用 Seata；追踪用 Micrometer+Zipkin。
