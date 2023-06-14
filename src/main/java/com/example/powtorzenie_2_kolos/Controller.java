package com.example.powtorzenie_2_kolos;

import com.example.powtorzenie_2_kolos.client.ServerThread;
import com.example.powtorzenie_2_kolos.server.Server;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class Controller {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider radiusSlider;
    private GraphicsContext graphicsContext;
    private Server server;
    private ServerThread serverThread;
    private Consumer<Dot> dotConsumer;
    @FXML
    public void initialize(){
        graphicsContext= canvas.getGraphicsContext2D();
    }
    public Controller(){
    dotConsumer=this::drawCircle;
    server = new Server(5000);
    serverThread = new ServerThread("localhost",5000);
    }
    private void drawCircle(Dot dot){
        graphicsContext.setFill(dot.color());
        graphicsContext.fillOval(dot.x() - dot.radius(),dot.y()- dot.radius(),2* dot.radius(),2*dot.radius());
    }
    @FXML
    void onMouseClicked(MouseEvent event){
        double x = event.getX();
        double y = event.getY();
        double radius = radiusSlider.getValue();
        Color fillColor = colorPicker.getValue();

//        graphicsContext.setFill(colorPicker.getValue());
//        graphicsContext.fillOval(x-radius,y-radius,2*radius,2*radius);
        Dot dot = new Dot(x,y,fillColor,radius);
    }
    private void setDotConsumer(Consumer<Dot> dotConsumer){
        this.dotConsumer=dotConsumer;
    }
    @FXML
    void onStartServerClicked() {
        // Implementacja logiki dla przycisku "Start Server & Connect"
        // Ta metoda zostanie wywołana po kliknięciu na ten przycisk
    }

    @FXML
    void onConnectClicked() {
        // Implementacja logiki dla przycisku "Connect"
        // Ta metoda zostanie wywołana po kliknięciu na ten przycisk
    }
}