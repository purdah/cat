# Interview Assesment Truck Robot.

### Requirements review.

The application needs to be a Spring Boot application it is assumed that the latest version of Spring Boot will be used

Integration tests are required, it would be sensible to use Spring Testing frameworks.

There are no requirements around which libraries to use for tests, mocking and assertions so Junit5, Mockito and Assert4j will be used

There is a requirement for a REST-Api but no mention of security. For this exercise it will be assumed that the application will be accessed over HTTP. Adding in security is supported by Spring Boot directly or a reverse proxy such as NGINX could be used with the Spring application serving HTTP and NGINX performing the HTTPS unwrapping.

There are no requirements for which build tool to use so Gradle will be used.

There are no requirements for logging, so the default logging framework will be used with console logging only.

