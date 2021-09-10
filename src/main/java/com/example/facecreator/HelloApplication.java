package com.example.facecreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();




    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        drawShape();
        drawMouth(50);
        drawEyes();
        drawNose();
        drawLeftEar();
        drawRightEar();
        drawNeck();
    }

    public static void drawShape() {
        gc.strokeOval(150, 150, 300, 300);
    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        gc.fillOval(280,370,mouthSize,mouthSize);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLUE);
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
    }
    public static void drawNose(){
        gc.setFill(Color.GRAY);
        gc.fillRect(290,300,20,20);
    }

    public static void drawLeftEar() {
        gc.strokeOval(125,190,50,50);
    }

    public static void drawRightEar() {
        gc.strokeOval(425,190,50,50);
    }

    public static void drawNeck() {
        gc.fillRect(160,450,300,550);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what color eyes you want");
        System.out.println("1 for demon eyes");
        System.out.println("2 for angel eyes");
        System.out.println("3 for forest eyes");
        scanner.nextLine();
        int number = scanner.nextInt();

        if (number == 1) {
            gc.setFill(Color.RED);
        }else if (number == 2){
            gc.setFill(Color.BLUE);
        } else if (number == 3){
            gc.setFill(Color.GREEN);
        }








        launch();

    }
}