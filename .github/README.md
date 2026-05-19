# eAkte EAI

The eAkte EAI provides a RESTful API to connect specialized applications (Fachanwendungen) to the eAkte electronic records management. 

## API Documentation

The current API specification and endpoints can be explored via Swagger UI:
* [Swagger API Documentation](TODO: Insert Swagger URL)

## Tech Stack

* Java
* Spring Boot
* Maven

## Roadmap

*This project is currently under active development.*

## Setup

### Running Locally

1. Build the application:

   `mvn install`
   
3. Run the resulting JAR file:

    `java -jar <path_to_the_jar_file>.jar`

### Running in podman
For a complete description of how to set up a Podman container, see:

[Documentation](../eakte-eai/eakte-eai/README.md)

1. Create a directory for external configuration:

    `mkdir eakte-external-config`
  
2. Place your application.yml with the correct environment data into the eakte-external-config directory.

3. Start the container using Podman Compose from the project root:

    `podman compose up`
  
4. Verify the deployment by accessing the Swagger UI in your browser:

    http://localhost:8080/swagger-ui/index.html

### Contributing
Contributions are welcome. If you have a suggestion for an enhancement, please open an issue with the tag enhancement, fork the repository, and create a pull request.

Please review our CODE_OF_CONDUCT before contributing.

### License
Distributed under the MIT License. See the LICENSE file for more information.

### Contact
it@M - opensource@muenchen.de
