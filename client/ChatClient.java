package client;

import java.io.*;
import java.net.*;

public class ChatClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to chat server");

            BufferedReader serverInput = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
            PrintWriter serverOutput = new PrintWriter(
                    socket.getOutputStream(), true);

            // Thread to receive messages
            new Thread(() -> {
                try {
                    String message;
                    while ((message = serverInput.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Main thread sends messages
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                serverOutput.println(userMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
