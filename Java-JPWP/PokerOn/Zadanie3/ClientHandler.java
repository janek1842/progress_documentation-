package Zadanie3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    protected ObjectOutputStream outStream = null;
    protected ObjectInputStream inStream = null;
    protected Socket socket = null;
    private ArrayList<ClientHandler> clientHandlers;

    public ClientHandler(Socket socket, ArrayList<ClientHandler> clientHandlers){
        try {
            this.socket = socket;
            this.clientHandlers = clientHandlers;
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        startReading();
    }
    public void stop(){
        try {
            clientHandlers.remove(this);
            inStream.close();
            outStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startReading(){
        while (!socket.isClosed()) {
            Message3 message = read();
            if(message != null){
                sendToAll(message);
            }
        }
    }

    public Message3 read(){
        Message3 message;
        try {
            message = (Message3) inStream.readObject();
            if (message != null) {
                return message;
            }
        } catch (SocketException e){
            stop();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void send(Message3 message){
        try {
            outStream.writeObject(message);
            outStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendToAll(Message3 message){
        /*
            TUTAJ UZUPEŁNIĆ
         */
        for(ClientHandler i: clientHandlers){
            if(!i.equals(this)) {
                i.send(message);
            }
        }



    }
}
