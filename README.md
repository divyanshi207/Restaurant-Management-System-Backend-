# 🍽️ Restaurant Management System - Backend

## 📖 Overview

Restaurant Management System is a backend application developed using Spring Boot and Microservices Architecture. The system provides functionality for user authentication, menu management, cart operations, and order processing. It is designed to simulate the core workflow of an online food ordering platform.

The application is divided into independent services, making it scalable, maintainable, and easy to extend.

---

## 🏗️ Microservices

### 🔐 Auth Service
Responsible for user authentication and authorization.

**Features**
- User Registration
- User Login
- JWT Token Generation
- Secure Access to APIs
- Role-Based Authentication

### 📋 Menu Service
Responsible for managing restaurant menu items.

**Features**
- Add New Menu Items
- Update Existing Menu Items
- Delete Menu Items
- View Available Menu

### 🛒 Cart Service
Responsible for managing customer cart operations.

**Features**
- Add Items to Cart
- Update Item Quantity
- Remove Items from Cart
- View Cart Details

### 📦 Order Service
Responsible for order management.

**Features**
- Place Orders
- View Order Details
- Track Order Status
- Manage Order History

---

## 🛠️ Technology Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate

### Database
- MySQL

### Authentication
- JWT (JSON Web Token)

### Build Tool
- Maven

### API Testing
- Postman

### Version Control
- Git
- GitHub

---

## 📂 Project Structure

```text
Restaurant-Management-System-Backend
│
├── auth-service
│
├── menu-service
│
├── cart-service
│
├── order-service
│
└── README.md
```

---

## 🔄 System Workflow

1. User registers and logs in through Auth Service.
2. Auth Service generates a JWT token.
3. User accesses protected APIs using the JWT token.
4. User browses menu items through Menu Service.
5. User adds items to Cart Service.
6. User places an order through Order Service.
7. Order details are stored and managed by Order Service.

---

## 🔑 Authentication Flow

```text
User
  │
  ▼
Login/Register
  │
  ▼
Auth Service
  │
  ▼
JWT Token Generated
  │
  ▼
Request with JWT Token
  │
  ▼
Protected APIs Access
```

---

## 📌 API Endpoints

### Auth Service

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /auth/register | Register User |
| POST | /auth/login | Login User |

### Menu Service

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | /menu | Get All Menu Items |
| GET | /menu/{id} | Get Menu Item By ID |
| POST | /menu | Add Menu Item |
| PUT | /menu/{id} | Update Menu Item |
| DELETE | /menu/{id} | Delete Menu Item |

### Cart Service

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /cart/add | Add Item To Cart |
| GET | /cart | View Cart |
| PUT | /cart/update | Update Cart Item |
| DELETE | /cart/remove | Remove Item From Cart |

### Order Service

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /orders | Place Order |
| GET | /orders | Get All Orders |
| GET | /orders/{id} | Get Order Details |
| PUT | /orders/{id} | Update Order Status |

---

## ⚙️ Prerequisites

Before running the application, make sure the following are installed:

- Java 17 or above
- Maven
- MySQL
- Git
- Postman (Optional)

---

## 🚀 Getting Started

### Clone Repository

```bash
git clone https://github.com/divyanshi207/Restaurant-Management-System-Backend-.git
```

### Navigate To Project

```bash
cd Restaurant-Management-System-Backend-
```

### Configure Database

Update the following properties in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=root
spring.datasource.password=password
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

---

## 🧪 Testing APIs

You can test all endpoints using:

- Postman

Example Authorization Header:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

## 🎯 Key Features

- Microservices Architecture
- JWT Authentication & Authorization
- RESTful API Design
- Secure User Access
- Menu Management
- Cart Management
- Order Processing
- Scalable and Maintainable Design
- Spring Security Integration
- Database Persistence using JPA & Hibernate

## 👩‍💻 Author

### Divyanshi Agrawal

Java Backend Developer

**Skills**
- Java
- Spring Boot
- Microservices
- REST APIs
- Spring Security
- MySQL
- Hibernate
- Maven
- Jwt Tokens
  

GitHub: https://github.com/divyanshi207

---

## 📜 License

This project is developed for learning and demonstration purposes.

---

⭐ If you found this project useful, don't forget to give it a Star!
