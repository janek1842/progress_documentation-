package Zadanie2;

import java.io.Serializable;

public class Message2 implements Serializable {
    private String message;

    public Message2(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
