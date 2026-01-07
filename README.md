# Registration App (Spring Boot + Thymeleaf + MySQL)

Simple registration app (name + email) using Spring Boot, Thymeleaf, Spring Data JPA (Hibernate) and MySQL.

## Requirements
- JDK 17
- Maven
- Docker & Docker Compose (optional, recommended to run MySQL)

## Setup & Run
1. Start MySQL via Docker Compose:

   docker-compose up -d

2. Build & run the app:

   mvn clean package
   mvn spring-boot:run

3. Open http://localhost:8080/register and submit name + email.

## Notes
- DB connection is configured in `src/main/resources/application.properties` (default credentials root/password).
- Hibernate will create/update schema automatically (`spring.jpa.hibernate.ddl-auto=update`).
- To change DB credentials or URL, edit `application.properties`.
# spring-boot-project
