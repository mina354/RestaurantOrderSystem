# Restaurant Order System

A JavaFX-based client-server restaurant management application that allows users to connect to a restaurant server, browse menu items, select tables, and place food orders through a graphical user interface.

The project demonstrates networking, multithreading, JavaFX GUI development, file handling, and GitHub collaboration workflows.

---

# Features

## User Features
- User login system
- User registration system
- Table selection
- Restaurant menu viewing
- Multi-item order placement
- Order history display

## Networking Features
- TCP socket communication
- Client-server architecture
- Multi-threaded server handling
- Multiple client support
- Real-time request/response communication

## GUI Features
- JavaFX graphical interface
- Multiple scenes
- Scene switching
- Responsive layouts
- CSS styling
- User feedback messages

## System Features
- File handling for registered users
- Error handling
- Background networking threads
- Input validation

---

# Technologies Used

- Java
- JavaFX
- FXML
- CSS
- TCP Sockets
- Multithreading
- Git & GitHub

---

# Project Structure

```plaintext
src/main/java/com/example/restaurantordersystem
│
├── controllers
│   ├── LoginController.java
│   ├── RegisterController.java
│   ├── MenuController.java
│   └── TableSelectionController.java
│
├── networking
│   ├── NetworkClient.java
│   ├── ClientHandler.java
│   ├── Protocol.java
│   └── RestaurantServer.java
│
├── models
│   ├── Order.java
│   └── RestaurantService.java
│
└── application
    └── RestaurantClientApp.java

src/main/resources/com/example/restaurantordersystem
│
├── fxml
│   ├── login.fxml
│   ├── register.fxml
│   ├── main.fxml
│   └── table-selection.fxml
│
└── css
    └── style.css
```

---

# How To Run

## 1. Start the Server

Run:

```plaintext
RestaurantServer.java
```

The server starts listening for client connections on port `12345`.

---

## 2. Start the Client

Run:

```plaintext
RestaurantClientApp.java
```

Multiple clients can be opened simultaneously.

---

# Application Workflow

1. User logs in or registers
2. User selects a restaurant table
3. Client requests menu items from the server
4. User selects menu items
5. Order is sent to the server
6. Server receives the order and sends a confirmation response

---

# Networking Design

The application uses TCP socket communication between:
- `RestaurantServer`
- `NetworkClient`

Each connected client is handled using a separate thread through the `ClientHandler` class, allowing multiple users to interact with the server simultaneously.

---
