package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static final int PORT = 1234;
    static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);

                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients
    static synchronized void broadcast(String message, ClientHandler excludeUser) {
        for (ClientHandler client : clientHandlers) {
            if (client != excludeUser) {
                client.sendMessage(message);
            }
        }
    }

    static synchronized void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }
}
