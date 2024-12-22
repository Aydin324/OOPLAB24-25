package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server-ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 1234; // Same port as the server

        try (Socket socket = new Socket(serverIp, port);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            serverOutput.println(username);

            Thread listenerThread = new Thread(() -> {
                try {
                    String messageFromServer;
                    while ((messageFromServer = serverInput.readLine()) != null) {
                        System.out.println(messageFromServer);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            listenerThread.start();

            // Main thread
            String userInput;
            System.out.println("Start chatting! Type your messages below:");
            while ((userInput = consoleInput.readLine()) != null) {
                serverOutput.println(userInput);
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
