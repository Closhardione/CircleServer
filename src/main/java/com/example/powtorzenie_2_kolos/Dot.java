package com.example.powtorzenie_2_kolos;

import javafx.scene.paint.Color;

public record Dot(double x, double y, Color color,double radius) {
    public static String toMessage(Dot dot){
        return String.format("%.2f,%.2f,%s,%.2f",dot.x,dot.y,dot.color,dot.radius);
    }
    public static Dot fromMessage(String message){
     String[] parts = message.split(",");
     if(parts.length != 4){
         throw new IllegalArgumentException("Invalid message format");
     }
     double x= Double.parseDouble(parts[0]);
     double y= Double.parseDouble(parts[1]);
     Color color = Color.valueOf(parts[2]);
     double radius = Double.parseDouble(parts[3]);
     return new Dot(x,y,color,radius);
    }
}
