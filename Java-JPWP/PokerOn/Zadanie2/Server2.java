package Zadanie2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    protected ServerSocket serverSocket = null;
    protected Socket socket = null;
    protected ObjectOutputStream out = null;
    protected ObjectInputStream in = null;
    private int port = 5000;

    public void createServerSocket(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Starting server socket at port " + port);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void acceptClient(){
        try {
            System.out.println("Listening at port " + port);
            socket = serverSocket.accept();
            System.out.println("Client accepted");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void send(Message2 message){
        try {
            out.writeObject(message);
            out.flush();
            System.out.println("Message sent: " + message.getMessage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            Message2 message = (Message2) in.readObject();
            System.out.println("Message received: " + message.getMessage());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server2 server = new Server2();
        Message2 message = new Message2("Kielce pozdrawiaja");
        /*
            TUTAJ UZUPEŁNIĆ
        */
        server.createServerSocket();
        server.acceptClient();

        server.send(message);
        server.read();




    }
}