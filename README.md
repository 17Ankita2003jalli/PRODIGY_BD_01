# User Management API

A simple RESTful API built with Spring Boot that performs CRUD operations on user data stored in an in-memory hashmap.

---

## 🟠 Features

- Create, read, update, and delete users
- Input validation (name, email, age)
- Custom error handling
- UUID-based unique user identification
- Well-structured code with layered architecture (Controller → Service → Repository)

---

## 📦 Technologies Used

- Java 17 (or the version you used)
- Spring Boot
- Maven
- Postman (for API testing)
- Git & GitHub

---

## 🚀 Getting Started

### Prerequisites
- Java installed (version 17 or higher)
- Maven installed
- Postman (optional for API testing)

### Running the project
1. Clone the repository:
   ```bash
   git clone <repository-url>

---

## 📂 API Endpoints

### Create User
`POST /users`
- Request body: `name`, `email`, `age`
- Response: Created user details

### Get All Users
`GET /users`
- Response: List of all users

### Get User by ID
`GET /users/{id}`
- Path variable: `id` (UUID)
- Response: User details

### Update User
`PUT /users/{id}`
- Path variable: `id` (UUID)
- Request body: Updated user fields
- Response: Updated user details

### Delete User
`DELETE /users/{id}`
- Path variable: `id` (UUID)
- Response: No content

---

## ⚠ Error Handling

The API returns appropriate error responses:
- `400 Bad Request`: Invalid or missing input
- `404 Not Found`: User not found
- `409 Conflict`: Email already exists

---

## 📢 Notes

This project is created for learning and demonstration purposes. Feel free to explore, test, and use it as a reference for your own projects.

Contributions, feedback, and suggestions are always welcome. If you find any issues or have ideas for improvement, feel free to open an issue or submit a pull request!

Happy coding! 🚀✨
