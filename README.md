# Interview Assesment Truck Robot.

### Requirements review.

The application needs to be a Spring Boot application it is assumed that the latest version of Spring Boot will be used

Integration tests are required, it would be sensible to use Spring Testing frameworks.

There are no requirements around which libraries to use for tests, mocking and assertions so Junit5, Mockito and Assert4j will be used

There is a requirement for a REST-Api but no mention of security. For this exercise it will be assumed that the application will be accessed over HTTP. Adding in security is supported by Spring Boot directly or a reverse proxy such as NGINX could be used with the Spring application serving HTTP and NGINX performing the HTTPS unwrapping.

There are no requirements for which build tool to use so Gradle will be used.

There are no requirements for logging, so the default logging framework will be used with console logging only.

There is no indication that multiple Robot Trucks are required, however it would most likely be the case that multiple Trucks would be in use so where appropriate it should be considered that API's support this feature although the initial implementation would not support multiple trucks. There is added complexity to support Trucks on the same Table area.


## Solution Analysis

The main concept here is to manage the relationship between a RobotTruck and that of its underlying table. 

Given the lack of requirements around the table and if the table could ever change, the initial code would not need to support a generic set of tables of simple or complex shapes

The API will focus on the truck with operations for placement, movement and reporting.

Two options exist for the turning, either a /left and /right call or /turn with a parameter that supports a direction.

It is generally better to have fewer but more functional API calls so this design will implement the single method of /turn with a direction. This gives the flexibility to have not just 'left' or 'right' turns, but also easily support cardinal directions of 'north', 'south', 'east' and 'west' or even 'u-turn' which can greatly reduce the number of calls to the api.

Extending this there only needs to be a single /move api that supports the direction as a request parameter and returns the report of the truck.

To support multiple API calls and detach the API implementation from the internal implementation a RobotTruckService class will be created to provide the business domain as a separate model from the API. Doing so will allow for easier changes inside the system without being tied to the API layer.

The requirements indicate separate calls so that will be used.

This leads to the following API calls:

/robottruck/place?x=1&y=2&direction=NORTH
    
/robottruck/move

/robottruck/left

/robottruck/right

/robottruck/report

## Errors

When there is an API error then the requirements are to ignore and keep the existing state. The error will be logged
 
Normally it would be sensible to return a HTTP code of 400 with a message, but in this case the aim is to ignore the case and always return the existing state, or no state in the case of a truck that could not be placed.

So the report command on an unplaced truck would be 'ROBOT MISSING', this would also be the response for a truck that was placed out of bounds, ie PLACE -1,-1,NORTH REPORT would also return ROBOT MISSING.

There is no current support for removing the truck, an existing valid truck with an invalid place command will NOT remove or reset the truck state.

Ie, PLACE 1,1,NORTH PLACE -1,-1,SOUTH REPORT would return 1,1,NORTH 
