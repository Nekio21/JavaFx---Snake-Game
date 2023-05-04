package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene s = new Scene(group, 1260, 700, Color.rgb(0,0,0));

        GameCanvas canvas = new GameCanvas(1260, 700);

        s.setOnKeyPressed(e->{
            canvas.obslugaKlawiszy(e);
        });

        group.getChildren().add(canvas);

        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(s);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        System.out.println("Teletubie mowia papa :)");

        System.exit(12);
    }

    public static void main(String[] args) {
        launch();
    }
}