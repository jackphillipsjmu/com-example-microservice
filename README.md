# Example Microservice Written in Spring Boot
Current functionality includes:
- Automated POJO generation with Swagger and JPA related annotations.
- Logging of request/responses to controller endpoints using web filter.
- Example controller, service and repository classes.
- [Swagger UI](http:localhost:8080/swagger-ui.html) to run REST endpoints from your browser.


## Setup
- Clone project to your local environment `git clone git@github.com:jackphillipsjmu/com-example-microservice.git`
- Build the project using either your locally installed Gradle instance or the Gradle wrapper supplied in this repository `./gradlew build`
- Run the service either from your IDE or the command line `./gradlew bootRun`
- Go into your browser of choice and and navigate the [Swagger UI](http:localhost:8080/swagger-ui.html) to see and run established REST endpoints.