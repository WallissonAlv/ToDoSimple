# API Documentation - To Do
This is my first repository working alone, I'm very exciting...

## Technologies Used:
- Java 8
- Spring Boot 3.2.17
- Hibernate
- H2 Database
- Swagger

## API Endpoints:
### Users:
- `GET /users`: Retrieves all registered users.
- `GET /users/{id}`: Retrieves a specific user by ID.
- `POST /users`: Creates a new user.
- `PUT /users/{id}`: Updates an existing user by ID.
- `DELETE /users/{id}`: Deletes a user by ID.

### To Do Tasks:
- `GET /todos`: Retrieves all tasks.
- `GET /todos/{id}`: Retrieves a specific task by ID.
- `POST /todos`: Creates a new task.
- `PUT /todos/{id}`: Updates an existing task by ID.
- `DELETE /todos/{id}`: Deletes a task by ID.

## Data Models:
### User:
- Attributes: id (Long), name (String), sector (String).

### Todo:
- Attributes: id (Long), title (String), description (String), user (User).

## Tests:
### `testFindAllUsers`:
- Description: Verifies the functionality of retrieving all users.
- Method: `GET`
- Endpoint: `/users`
- Expected Result: Returns a list of all users.

### `testFindById`:
- Description: Verifies the functionality of retrieving a specific user by ID.
- Method: `GET`
- Endpoint: `/users/{id}`
- Expected Result: Returns the user corresponding to the provided ID.

## Usage Instructions:
- To access the interactive API documentation, visit: [Link to Swagger](url_to_swagger). //I'm fix this link :D
