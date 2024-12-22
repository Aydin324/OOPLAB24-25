package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<ClientHandler> clients;
    private ServerSocket serverSocket;

    public ChatServer() {
        clients = new ArrayList<ClientHandler>();
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started at port " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }

    public void broadcastMessage(String message, ClientHandler sender){
        for(ClientHandler client : clients){
            if(!client.equals(sender)){
                client.getOut().println(message);
            }
        }
    }

    //private inner class
    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String username;


        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run(){
            try {
                this.username = in.readLine();
                broadcastMessage(this.username + " joined the chat!", this);

                String message;
                while((message = in.readLine()) != null){
                    System.out.println("Message from " + username + ": " + message);
                    broadcastMessage(this.username + ": " + message, this);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                clients.remove(this);
                broadcastMessage(username + " has left the chat.", this);
                System.out.println(username + " disconnected.");
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }

        public PrintWriter getOut() {
            return out;
        }
        public BufferedReader getIn() {
            return in;
        }
    }


}
