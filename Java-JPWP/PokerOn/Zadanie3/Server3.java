package Zadanie3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server3 {
    protected ServerSocket serverSocket = null;
    protected Socket socket = null;
    private int port = 5000;
    private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    public void createServerSocket(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Starting server socket at port " + port);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void acceptClients(){
        try {
            while(true) {
                System.out.println("Listening at port " + port);

                socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, clientHandlers);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
                System.out.println("Client accepted");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server3 server = new Server3();
        server.createServerSocket();
        server.acceptClients();

    }
}