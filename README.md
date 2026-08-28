# spring-boot-kotlin-toolchain-playground

Demo project for Spring Boot on JetBrains Kotlin Toolchain.

## Stack

- Spring Boot 4.0.7
- Kotlin 2.4.10
- Kotlin Toolchain 0.12.0
- Java 25
- PostgreSQL 18.6 through Spring Boot Docker Compose support

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
