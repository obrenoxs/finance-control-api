# Finance Control API

## 🚧 Project Status

In development – new features and improvements are continuously being added.

## 📌 About the Project

Finance Control API is a RESTful API built with Java and Spring Boot for personal finance management.

The application allows users to manage categories and financial transactions, track incomes and expenses, calculate the current balance, and enforce business rules to ensure data integrity.

This project was developed as a learning experience to improve backend development skills, software architecture knowledge, and best practices using Spring Boot.

---

## 🚀 Technologies

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

---

## 📂 Project Structure

The project follows a feature-based package organization:

### Category Module

* Controller
* Service
* Repository
* DTOs
* Entity

### Transaction Module

* Controller
* Service
* Repository
* DTOs
* Entity
* Enum

### Exception Handling

* Custom Exceptions
* Global Exception Handler

---

## ✨ Features

### Categories

* Create category
* Get all categories
* Get category by ID
* Update category
* Delete category
* Prevent duplicate categories
* Prevent deletion of categories associated with transactions

### Transactions

* Create transaction
* Get all transactions
* Get transaction by ID
* Update transaction
* Delete transaction
* Validate existing category
* Validate positive transaction amount
* Validate required transaction date
* Prevent future dates
* Validate required transaction type

### Financial Dashboard

* Total income
* Total expenses
* Current balance

---

## 📊 API Endpoints

### Categories

| Method | Endpoint         |
| ------ | ---------------- |
| POST   | /categories      |
| GET    | /categories      |
| GET    | /categories/{id} |
| PUT    | /categories/{id} |
| DELETE | /categories/{id} |

### Transactions

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | /transactions         |
| GET    | /transactions         |
| GET    | /transactions/{id}    |
| PUT    | /transactions/{id}    |
| DELETE | /transactions/{id}    |
| GET    | /transactions/balance |

---

## 🛡️ Exception Handling

The API provides global exception handling for:

* Resource Not Found (404)
* Business Rules Violations (400)

Example response:

```json
{
  "timestamp": "2026-06-20T15:30:00Z",
  "status": 400,
  "error": "Business error",
  "message": "Category already exists",
  "path": "/categories"
}
```

---

## 🔄 DTO Architecture

The application uses DTOs to separate input and output data from domain entities.

### Request DTOs

* CategoryRequestDTO
* TransactionRequestDTO

### Response DTOs

* CategoryResponseDTO
* TransactionResponseDTO
* BalanceDTO

---

## 🎯 Learning Goals

This project was created to practice:

* Spring Boot development
* Layered architecture
* DTO pattern
* Business rule validation
* Spring Data JPA
* REST API best practices
* Backend software development concepts

---

## 👨‍💻 Author

Developed by Breno Souza as a personal learning project focused on backend development with Java and Spring Boot.
