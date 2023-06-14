package com.example.powtorzenie_2_kolos.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class Server {
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new ArrayList<>();
    public Server(int port, String dbUrl){
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void run(){
        while(true){
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: clientSocket");
                ClientThread clientThread = new ClientThread(clientSocket,this);
                clients.add(clientThread);
                clientThread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void broadcast(ClientThread sender, String message){
        for(var currentClient : clients){
            currentClient.send("BR"+message);
        }

    }
}
