# spring-grpc

This project is a demonstration of using gRPC (Google Remote Procedure Call) with Spring Boot, facilitating communication between a client and server using protocol buffers.

## Contents:

1. **`GrpcServerService.java`**:
    - This file defines the server-side implementation of the gRPC service. It contains a method `sayHello` which responds with a greeting message based on the received request.

2. **`hello.proto`**:
    - This file specifies the protocol buffer messages and service definitions used for communication between the client and server. It defines two messages, `HelloRequest` and `HelloResponse`, along with the `GreetService` service containing the `sayHello` RPC method.

3. **`GrpcServerServiceTest.java`**:
    - This file contains JUnit tests for verifying the functionality of the gRPC server. It includes a test case for the `sayHello` method, ensuring that it returns the expected response.

4. **`SpringGrpcApplication.java`**:
    - This is the main entry point of the Spring Boot application. It bootstraps the Spring context and starts the gRPC server.

## Running the Project:

To run the project, follow these steps:

1. Ensure you have Java and Maven installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory.
4. Run the following command to build the project:
     `mvn clean install`
5. Once the build is successful, you can start the server by running:`mvn spring-boot:run`
6. To run the tests, execute: `mvn test`


## Notes:

- The server listens on port `9090` by default. You can modify this configuration in `application.properties` if needed.
- The client-side implementation for invoking the gRPC service is not included in this project. You can implement it using the generated stubs from the protocol buffer definitions.
`