package com.example.powtorzenie_2_kolos.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket serverSocket;
    private PrintWriter writer;
    public ServerThread(String address, int port){
        try {
            serverSocket = new Socket(address,port);
            writer = new PrintWriter((serverSocket.getOutputStream()),true);
            System.out.println("Connected to server: "+serverSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void send(double x, double y, double radius){
        String message = x + "," + y + "," + radius;
        writer.println(message);
        System.out.println("Sent message to server: "+message);
    }
}
