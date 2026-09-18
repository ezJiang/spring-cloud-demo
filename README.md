# Spring Cloud 微服务框架骨架（本地可运行）

一个零外部依赖、开箱即跑的 Spring Cloud 微服务 Demo，包含「服务注册中心 + 服务提供者 + 服务消费者 + API 网关」四大基础组件，覆盖服务发现、声明式服务调用、网关路由三大核心模式。

> 技术栈：Spring Boot 3.3.4 + Spring Cloud 2023.0.3（Leyton）+ Java 17
> 组件：Eureka（注册中心）、Spring Cloud Gateway（网关）、OpenFeign（声明式调用）、spring-cloud-loadbalancer（负载均衡）

## 模块结构

```
spring-cloud-demo
├── pom.xml                 # 父工程，统一依赖管理与 Spring Cloud BOM
├── eureka-server           # 服务注册中心（端口 8761）
├── user-service            # 服务提供者：用户服务（端口 8081）
├── order-service           # 服务消费者：订单服务（端口 8082，通过 Feign 调 user-service）
└── gateway-service         # API 网关（端口 8080，统一入口）
```

## 环境要求

- JDK 17+
- Maven 3.8+（或本项目自带的 `mvnw` 包装器）

## 启动顺序

建议先启动注册中心，再启动其他服务（否则服务启动时会报连接 Eureka 失败，但重试后仍可注册）：

```bash
# 1. 注册中心
mvn -pl eureka-server spring-boot:run

# 2. 服务提供者
mvn -pl user-service spring-boot:run

# 3. 服务消费者
mvn -pl order-service spring-boot:run

# 4. 网关
mvn -pl gateway-service spring-boot:run
```

或者一次性打包后分别 `java -jar`：

```bash
mvn clean package -DskipTests
java -jar eureka-server/target/eureka-server-1.0.0.jar
java -jar user-service/target/user-service-1.0.0.jar
java -jar order-service/target/order-service-1.0.0.jar
java -jar gateway-service/target/gateway-service-1.0.0.jar
```

## 验证接口

| 说明 | 地址 |
| --- | --- |
| Eureka 控制台 | http://localhost:8761 |
| 用户列表（直连） | http://localhost:8081/users |
| 下单（直连） | `POST http://localhost:8082/orders?userId=1&product=book` |
| 通过网关访问用户 | http://localhost:8080/api/users |
| 通过网关访问订单 | http://localhost:8080/api/orders |
| 服务聚合调用（Feign） | http://localhost:8080/api/orders/1/with-user |

启动完成后，打开 Eureka 控制台应能看到 `USER-SERVICE`、`ORDER-SERVICE`、`GATEWAY-SERVICE` 三个实例已注册。

## 扩展建议

- 配置中心：引入 `spring-cloud-config` 或 Spring Cloud Alibaba Nacos。
- 熔断限流：引入 `spring-cloud-circuitbreaker-resilience4j`。
- 链路追踪：引入 Micrometer Tracing + Zipkin。
- 多实例验证负载均衡：把 `user-service` 以不同端口再起一个实例（`-Dserver.port=8083`）。

## 运行

- ![image-20260918130952531](C:\Users\jiangenzheng\AppData\Roaming\Typora\typora-user-images\image-20260918130952531.png)
