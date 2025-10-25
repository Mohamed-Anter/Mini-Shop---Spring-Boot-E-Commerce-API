# 🛒 Mini Shop - Spring Boot E-Commerce API

A simple **Spring Boot**-based e-commerce backend that allows users to browse products, add them to a cart, and place orders.
This project demonstrates clean architecture, proper JPA relationships, and RESTful API design — perfect for learning and interview preparation.

---

## 🚀 Features

* 🧍‍♂️ **User Management** – Create and manage users.
* 🛍 **Product Management** – Add, update, list, and delete products.
* 🛒 **Cart System** – Add, remove, or clear products from a user’s cart.
* 📦 **Order Management** – Convert a user’s cart into an order and calculate totals.
* 💾 **MySQL Integration** – Persistent storage using JPA and Hibernate.
* ⚙️ **Lombok** – Reduces boilerplate code for models and services.

---

## 🧱 Project Structure

```
src/
 ├─ main/java/com/example/minishop/
 │   ├─ controller/   → REST controllers (Cart, Product, Order, User)
 │   ├─ entity/       → JPA entities (User, Product, Cart, CartItem, Order, OrderItem)
 │   ├─ repository/   → Spring Data JPA interfaces
 │   └─ service/      → Business logic for each module
 └─ resources/
     ├─ application.properties → DB configuration
     ├─ data.sql               → Initial demo data
     └─ schema.sql             → Optional database structure
```

---

## 🧩 Entity Relationships

| Entity                  | Relationship | Details                                  |
| ----------------------- | ------------ | ---------------------------------------- |
| **User ↔ Cart**         | `@OneToOne`  | Each user has exactly one cart           |
| **Cart ↔ CartItem**     | `@OneToMany` | A cart contains multiple items           |
| **CartItem ↔ Product**  | `@ManyToOne` | Each item is linked to one product       |
| **Order ↔ OrderItem**   | `@OneToMany` | Each order contains multiple order items |
| **OrderItem ↔ Product** | `@ManyToOne` | Each order item references one product   |

---

## 🧰 Technologies Used

* **Spring Boot 3.1**
* **Spring Web**
* **Spring Data JPA**
* **MySQL Database**
* **Lombok**
* **Maven**
* **Postman (for API testing)**

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Mohamed-Anter/Student-Management.git
cd mini-shop
```

### 2️⃣ Configure the database

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minishop_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run the application

From IntelliJ terminal or command line:

```bash
mvn spring-boot:run
```

Server will start at:
👉 `http://localhost:8080`

---

## 📬 API Endpoints

### 🧍 User

| Method | Endpoint     | Description       |
| ------ | ------------ | ----------------- |
| GET    | `/api/users` | Get all users     |
| POST   | `/api/users` | Create a new user |

### 🛒 Cart

| Method | Endpoint                                | Description              |
| ------ | --------------------------------------- | ------------------------ |
| GET    | `/api/cart/{userId}`                    | Get user’s cart          |
| POST   | `/api/cart/{userId}/add/{productId}`    | Add product to cart      |
| DELETE | `/api/cart/{userId}/remove/{productId}` | Remove product from cart |
| DELETE | `/api/cart/{userId}/clear`              | Clear cart               |

### 🛍 Product

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| GET    | `/api/products` | Get all products  |
| POST   | `/api/products` | Add a new product |

### 📦 Order

| Method | Endpoint                      | Description            |
| ------ | ----------------------------- | ---------------------- |
| POST   | `/api/orders/create/{cartId}` | Create order from cart |

---

## 📘 Example JSON Output (Cart)

```json
{
  "id": 1,
  "user": { "id": 1, "username": "mohamed" },
  "items": [
    {
      "id": 2,
      "product": { "id": 2, "name": "Book", "price": 200.0 },
      "quantity": 1
    }
  ]
}
```

---

## 🧑‍💻 Author

**Mohamed Anter**
📧 [mohamedanter20190469@gmail.com](mailto:mohamedanter20190469@gmail.com)
💼 [LinkedIn](https://www.linkedin.com/in/mohamed-anter-55177821b)
📂 [GitHub Profile](https://github.com/Mohamed-Anter)

---

## 🏁 Notes

* Use **Postman** to test API endpoints.
* Ensure MySQL service is running before starting the app.
* Lombok plugin must be enabled in IntelliJ IDEA.
* If you encounter `Unknown column` errors, delete the existing tables and restart the app.
