package it.unibo.exceptions.impl;

import java.io.IOException;

public class NetworkException extends IOException {

    /*  The 0-ary constructor must create an Exception 
        whose message is "Network error: no response". */
    public NetworkException() {
        super("Network error: no response");
    }

    /*  The 1-ary constructor must take a String as input, and
        create a message "Network error while sending message: <message>" */
    public NetworkException(String message) {
        super("Network errorwhile sending message:" + message);
    }
}