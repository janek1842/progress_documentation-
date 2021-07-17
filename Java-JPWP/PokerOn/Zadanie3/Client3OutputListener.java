package Zadanie3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3OutputListener extends Thread{
    private Scanner scanner = new Scanner(System.in);
    protected ObjectOutputStream outStream = null;

    public Client3OutputListener(Socket socket){
        try {
            this.outStream =  new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            try {
                Message3 message = new Message3(scanner.nextLine());
                outStream.writeObject(message);
                outStream.flush();
                System.out.println("Message sent: " + message.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
