# 🧵 Multithreaded Chat Application (Java)

A simple **client–server chat application** built using **Java Sockets** and **Multithreading**, allowing multiple users to communicate with each other in real time.

---

## 🚀 Features

- Multiple clients can connect simultaneously
- Real-time message broadcasting
- Dedicated thread for each client
- Clean client–server architecture
- Console-based interaction

---

## 🛠️ Tech Stack

- Java
- TCP Sockets
- Multithreading
- I/O Streams

---

## 📁 Project Structure
```
ChatApplication/
│
├── server/
│ ├── ChatServer.java # Server entry point
│ └── ClientHandler.java # Handles individual clients
│
├── client/
│ └── ChatClient.java # Client application
│
└── README.md
```


---

## ⚙️ How It Works

### Server
- Listens for incoming client connections
- Creates a new thread for each connected client
- Broadcasts messages received from one client to all others

### Client
- Connects to the server using a socket
- Sends messages to the server
- Receives messages asynchronously using a separate thread

This design enables **real-time, non-blocking communication** between multiple users.

---

## 🧵 Multithreading Model

| Component | Description |
|--------|------------|
| Server | Accepts connections continuously |
| ClientHandler | One thread per connected client |
| Client | Separate thread for receiving messages |

---

## ▶️ Getting Started

### Prerequisites
- Java JDK 8 or higher
- Terminal / PowerShell

---

### 🔹 Compile the Project

From the project root directory:

```bash
javac server/*.java client/*.java

🔹 Run the Server
java server.ChatServer


Expected output:

Chat Server started...

🔹 Run the Client(s)

Open a new terminal for each client:

java client.ChatClient


Expected output:

Connected to chat server
Welcome to the chat!

💬 Usage

Start the server

Launch one or more clients

Type messages in any client terminal

Messages are broadcast to all connected clients in real time
