# spring-boot-kotlin-toolchain-playground

Demo project for Spring Boot on JetBrains Kotlin Toolchain.

## Stack

- Spring Boot 4.1.2
- Kotlin 2.4.21
- Kotlin Toolchain 0.14.0
- Java 25
- PostgreSQL 18.7 through Spring Boot Docker Compose support
- PostgreSQL JDBC 42.7.14 and other managed dependencies through the Spring Boot BOM

## Run

```bash
kotlin run
```

Spring Boot starts `compose.yaml`, creates a Docker Compose service connection for PostgreSQL, and exposes:

```text
POST /todos
GET  /todos
GET  /actuator/health
```

## Test

```bash
kotlin test
```

The context-load test enables Docker Compose support so JPA wiring is checked against PostgreSQL.
