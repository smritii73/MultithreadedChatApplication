package server;
import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to the chat!");
            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                ChatServer.broadcast(message, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.removeClient(this);
        }
    }

    void sendMessage(String message) {
        out.println(message);
    }
}
