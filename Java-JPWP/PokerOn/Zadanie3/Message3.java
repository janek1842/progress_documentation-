package Zadanie3;

import java.io.Serializable;

public class Message3 implements Serializable {
    private String message;

    public Message3(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
