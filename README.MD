🧵 Multithreaded Chat Application (Java)
📌 Project Overview

This project is a multithreaded client–server chat application built using Java Sockets and Multithreading.
It allows multiple clients to connect to a single server and communicate with each other in real time.

Each connected client is handled using a separate thread, enabling concurrent message exchange without blocking.

🎯 Objectives
Implement client–server communication using TCP sockets

Handle multiple users simultaneously using multithreading

Enable real-time message broadcasting between clients

Demonstrate core networking and concurrency concepts in Java

🧠 Core Concepts Used

ServerSocket and Socket

Multithreading (Thread, Runnable)

Input/Output Streams

Synchronization

Client handler pattern

Real-time message broadcasting

📁 Project Structure
ChatApplication/
│
├── server/
│   ├── ChatServer.java        // Main server class
│   └── ClientHandler.java    // Handles each client in a separate thread
│
├── client/
│   └── ChatClient.java       // Client program
│
└── README.md

⚙️ How the Application Works
🔹 Server Side

The server starts and listens on a fixed port (1234)

When a client connects:

A new ClientHandler object is created

A new thread is started for that client

The server maintains a list of all active clients

When a message is received from a client:

The server broadcasts it to all other connected clients

👉 This ensures multiple clients can chat simultaneously.

🔹 Client Side

Each client:

Connects to the server using a socket

Uses two parallel flows:

One for sending messages

One for receiving messages (background thread)

This allows the client to:

Send messages

Receive messages at the same time
➡️ Achieving real-time communication

🧵 Multithreading Explanation
Component	Thread Usage
Server	Main thread accepts connections
ClientHandler	One thread per connected client
Client	One thread for receiving messages

Each client is independent and does not block others.

▶️ How to Compile and Run
✅ Prerequisites

Java JDK 8 or higher

Command line / PowerShell

Basic knowledge of terminal usage

🔹 Step 1: Open Terminal

Navigate to the project root folder:

cd Desktop\ChatApplication

🔹 Step 2: Compile the Code
javac server/*.java client/*.java


✔️ No output means compilation succeeded

🔹 Step 3: Run the Server

Open a terminal and run:

java server.ChatServer


Expected output:

Chat Server started...

🔹 Step 4: Run Clients

Open new terminals (one per client):

java client.ChatClient


Expected output:

Connected to chat server
Welcome to the chat!

🔹 Step 5: Start Chatting 🎉

Type a message in any client terminal and press Enter.
The message will appear in all other connected clients in real time.

🔁 Example Interaction

Client 1:

Hello everyone!


Client 2:

Hello everyone!
Hi there!


Client 1:

Hi there!

🚫 Common Errors & Solutions
❌ Could not find or load main class

Ensure package name matches folder name

Run commands from project root

❌ Connection refused

Make sure the server is running before clients

❌ wrong class file

Delete .class files and recompile

del server\*.class
del client\*.class

🔥 Possible Enhancements

Add usernames

Private messaging

GUI using Swing / JavaFX

Message timestamps

Client join/leave notifications

📚 Learning Outcomes

Understanding of socket-based networking

Hands-on experience with Java multithreading

Client–server architecture

Real-time communication systems
