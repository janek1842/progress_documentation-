package Zadanie3;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Client3 {
    protected Socket socket = null;


    private String host = "localhost";
    private int port = 5000;

    public void createSocket(){
        try {
            System.out.println("Connecting to " + host + " at port " + port);
            socket = new Socket(host, port);

            System.out.println("Connected to server at port " + port);
            Client3OutputListener outputListener = new Client3OutputListener(socket);
            outputListener.start();
            System.out.println("Listening for incoming messages ");
            Client3InputListener inputListener = new Client3InputListener(socket);
            inputListener.start();
            System.out.println("You can type something now");
        } catch (ConnectException e){
            System.out.println("Failed to connect");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Client3 client = new Client3();
        client.createSocket();
    }
}
