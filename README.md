🍽️ Restaurant Management System - Backend

A microservices-based Restaurant Management System built using Spring Boot. The application manages restaurant operations such as user authentication, menu management, cart handling, and order processing.

🚀 Architecture

The system is divided into the following microservices:

🔐 Auth Service

Handles user authentication and authorization.

Features

User Registration
User Login
JWT Authentication
Role-based Access Control
📋 Menu Service

Manages restaurant menu items.

Features

Add Menu Items
Update Menu Items
Delete Menu Items
View Available Menu
🛒 Cart Service

Handles customer cart operations.

Features

Add Items to Cart
Update Quantity
Remove Items from Cart
View Cart Details
📦 Order Service

Processes customer orders.

Features

Place Orders
View Order History
Track Order Status
Order Management
🛠️ Tech Stack
Java 17+
Spring Boot
Spring Data JPA
Spring Security
JWT Authentication
Hibernate
MySQL
Maven
REST APIs
📂 Project Structure
Restaurant-Management-System-Backend
│
├── auth-service
├── menu-service
├── cart-service
├── order-service
│
└── README.md
🔄 Service Communication
Client
   │
   ▼
Auth Service
   │
   ├── Menu Service
   ├── Cart Service
   └── Order Service
🔑 Authentication Flow
User registers or logs in.
Auth Service generates JWT Token.
Token is sent with API requests.
Protected endpoints validate the token before processing requests.
📌 Main APIs
Auth Service
POST /auth/register
POST /auth/login
Menu Service
GET /menu
POST /menu
PUT /menu/{id}
DELETE /menu/{id}
Cart Service
POST /cart/add
PUT /cart/update
DELETE /cart/remove
GET /cart
Order Service
POST /orders
GET /orders
GET /orders/{id}
⚙️ Setup & Run
Clone Repository
git clone https://github.com/divyanshi207/Restaurant-Management-System-Backend-.git
Navigate to Project
cd Restaurant-Management-System-Backend-
Build Project
mvn clean install
Run Services
mvn spring-boot:run
🎯 Key Features

✅ Microservices Architecture
✅ JWT Authentication
✅ RESTful APIs
✅ Menu Management
✅ Cart Management
✅ Order Processing
✅ Secure User Access
✅ Scalable Design

👩‍💻 Author

Divyanshi Agrawal

Java Backend Developer | Spring Boot | Microservices | REST APIs | MySQL

⭐ If you found this project useful, consider giving it a star.
