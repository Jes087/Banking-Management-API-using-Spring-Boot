# 💸 Banking Management System - Spring Boot REST API

A simple backend banking application built with **Spring Boot**, showcasing **RESTful API** development for account management operations like create, deposit, withdraw, view, and delete.

## 🔧 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- REST API
- Postman
- Maven
- Lombok

---

## 📁 Features

- Create a new bank account
- Fetch account details by ID
- Deposit money to an account
- Withdraw money from an account (with balance check)
- View all existing accounts
- Delete an account

---

## 📦 Project Structure

```
com.springbootproject.bankingapp
├── controller        // REST Controllers
├── service           // Interface + Implementation
├── entity            // JPA Entity classes
├── repository        // JpaRepository
├── AccountDto        // DTO for safe data transfer
├── AccountMapping    // Mapper for Entity <-> DTO
```

---

## 📬 API Endpoints

| Method | Endpoint                   | Description               |
|--------|----------------------------|---------------------------|
| POST   | `/api/accounts`            | Create a new account      |
| GET    | `/api/accounts/{id}`       | Get account by ID         |
| GET    | `/api/accounts`            | List all accounts         |
| PUT    | `/api/accounts/{id}/deposit` | Deposit to account        |
| PUT    | `/api/accounts/{id}/withdraw` | Withdraw from account    |
| DELETE | `/api/accounts/{id}`       | Delete an account         |

📌 All endpoints use `application/json` format for request and response.

---

## 🚀 How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/springboot-banking-app.git
   ```

2. **Import into IntelliJ / VS Code**

3. **Set up MySQL Database**
   - Create a database called `banking_app`
   - Update `application.properties` with your DB credentials

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Test the endpoints using Postman or any REST client**

---

## 📄 License
This project is for learning purposes.