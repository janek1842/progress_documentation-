package Zadanie3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client3InputListener extends Thread{
    protected ObjectInputStream inStream = null;

    public Client3InputListener(Socket socket){
        try {
            this.inStream =  new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        startReading();
    }
    public void startReading(){
        while (true) {
            try{
                Message3 message = (Message3) inStream.readObject();
                if(message != null){
                    System.out.println("Message received: " + message.getMessage());
                }
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
