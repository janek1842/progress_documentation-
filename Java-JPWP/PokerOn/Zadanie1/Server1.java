package Zadanie1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    protected ServerSocket serverSocket = null;
    protected Socket socket = null;
    protected DataOutputStream out = null;
    protected DataInputStream in = null;
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
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void send(String message){
        try {
            out.writeUTF(message);
            out.flush();
            System.out.println("Message sent: " + message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            String message = in.readUTF();
            System.out.println("Message received: " + message);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server1 server1 = new Server1();
        String message = "Kielce pozdrawiaja";
        server1.createServerSocket();
        server1.acceptClient();
        server1.send(message);
        server1.read();
    }
}