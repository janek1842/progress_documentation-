package Zadanie2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client2 {
    protected Socket socket = null;
    protected ObjectOutputStream out = null;
    protected ObjectInputStream in = null;
    private String host = "localhost";
    private int port = 5000;

    public void createSocket(){
        try {
            System.out.println("Connecting to " + host + " at port " + port);
            socket = new Socket(host, port);

            System.out.println("Connected to server at port " + port);
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
        Client2 client = new Client2();
        Message2 message = new Message2("Wieliczka pozdrawia");
        /*
            TUTAJ UZUPEŁNIĆ
        */

        client.createSocket();

        client.send(message);

        client.read();

    }
}
