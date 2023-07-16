# Instagram_backend
Welcome to the Instagram Backend project! This project aims to provide the basic backend functionality of Instagram, 
including user authentication,
user management, and post management.

# Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL (or your preferred database)

 # Setup Instructions
- Clone the repository to your local machine.
- Install Java and set up the development environment.
- Configure the database connection in the application.properties file.
- Build and run the project using your preferred IDE or build tool.

##  API Documentation
# User Endpoints
- POST /api/users: Register a new user.
- GET /api/users/{userId}: Get user details by ID.
- PUT /api/users/{userId}: Update user details by ID.
# Post Endpoints
- POST /api/posts: Create a new post.
- GET /api/posts/{postId}: Get post details by ID.
- PUT /api/posts/{postId}: Update post details by ID.

Please note that these are just a subset of the available endpoints.
You can refer to the source code and API documentation for more details on all available endpoints and their usage.

## Project Structure
# The project follows a standard Spring Boot project structure:

- src/main/java/com/example/instagram: Contains the Java source code.
- config: Contains the configuration classes, such as SecurityConfig.
- controller: Contains the controllers that handle API endpoints.
- model: Contains the model classes representing the entities in the database.
- repository: Contains the repositories for database access.
- service: Contains the business logic and services.
- src/main/resources: Contains the application properties and static files.
- pom.xml: Contains the project dependencies and configuration.

## Database Configuration
The project is configured to use MySQL as the default database. 
- You can update the database connection details in the application.properties file:
  
spring.datasource.url=jdbc:mysql://localhost:3306/instagramdb

spring.datasource.username=root

spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
