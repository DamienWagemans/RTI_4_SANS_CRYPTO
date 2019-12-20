package com.example.myfirstapp;

import java.net.Socket;

public class Reseaux {
    private static Socket cli_Socket;

    public static Socket getCli_Socket() {
        return cli_Socket;
    }

    public static void setCli_Socket(Socket Sock){
        cli_Socket = Sock;
    }
}
