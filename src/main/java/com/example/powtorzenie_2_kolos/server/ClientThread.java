package com.example.powtorzenie_2_kolos.server;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket clientSocket;
    private PrintWriter writer;
    private Server server;
    public ClientThread(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;
    }
    public void run(){
        try{
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(),true);
            String message;
            while((message = inputStream.readLine())!=null){
                server.broadcast(this,message);
                System.out.println("Received message from client: "+ message);
            }
            inputStream.close();
            writer.close();
            clientSocket.close();
            System.out.println("Closed\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void send(String message){
        writer.println(message);
    }
}
