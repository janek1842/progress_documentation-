package Zadanie1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client1 {
    protected Socket socket = null;
    protected DataOutputStream out = null;
    protected DataInputStream in = null;
    private String host = "localhost";
    private int port = 5000;

    public void createSocket(){
        try {
            System.out.println("Connecting to " + host + " at port " + port);
            socket = new Socket("localhost", port);

            System.out.println("Connected to server at port " + port);
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
        Client1 client1 = new Client1();
        String message = "Wieliczka pozdrawia";
        client1.createSocket();
        client1.send(message);
        client1.read();
    }
}
