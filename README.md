# Document Manager

## Description
A Spring Boot backend for a document management and keyword-based Q&A system.

## Features
- JWT Authentication (Admin, Editor, Viewer roles)
- Document ingestion (Text, PDF, DOCX)
- PostgreSQL full-text search
- Keyword-based Q&A
- Swagger documentation
- Dockerized deployment

## Requirements
- Java 17+
- Maven
- Docker
- PostgreSQL

## Running the App

```bash
docker-compose up --build
```

## API Documentation
Visit: `http://localhost:8080/swagger-ui/index.html`

## Running Tests

```bash
./mvnw test
```
