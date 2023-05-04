package com.example.demo;

import com.example.demo.snake.InfoSnake;
import com.example.demo.snake.Snake;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas {

    private GraphicsContext gc;
    private Snake snake;

    private final int SPEED_GAME = 200;

    private final int WIDTH_KAFELEK = 75;
    private final int HEIGHT_KAFELEK = 75;

    private final int elementsTabX = 13;
    private final int elementsTabY = 8;

    private Thread thread;

    private int tab[][] = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public GameCanvas(int width, int height){
        super(width, height);

        gc = getGraphicsContext2D();

        snake = new Snake(20, 20, Color.RED);
        snake.setPosition(200,200);

        initPlansza(gc, tab);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    initPlansza(gc, tab);
                    snake.update(gc);

                    try {
                        Thread.sleep(SPEED_GAME);
                    } catch (InterruptedException e) {
                        System.out.println("PROBLEM");
                        break;
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });

        thread.start();
    }

    private void initPlansza(GraphicsContext gc, int tab[][]){
        for(int i=0; i<elementsTabY; i++){
            for(int j=0; j<elementsTabX; j++){

                Kafelek k = new Kafelek(WIDTH_KAFELEK, HEIGHT_KAFELEK, Color.WHITE);
                k.setPosition(WIDTH_KAFELEK*j, HEIGHT_KAFELEK*i);

                if(tab[i][j] == 0){
                    k.setColor(Color.GRAY);
                }

                k.drawKafelek(gc);
            }
        }
    }

    public void obslugaKlawiszy(KeyEvent e){
        switch (e.getCode()) {
            case W -> {
                if(snake.getInfoSnake() != InfoSnake.DOWN){
                    snake.setInfoSnake(InfoSnake.UP);
                }
            }
            case S -> {
                if(snake.getInfoSnake() != InfoSnake.UP){
                    snake.setInfoSnake(InfoSnake.DOWN);
                }
            }
            case A -> {
                if(snake.getInfoSnake() != InfoSnake.RIGHT){
                    snake.setInfoSnake(InfoSnake.LEFT);
                }
            }
            case D -> {
                if(snake.getInfoSnake() != InfoSnake.LEFT){
                    snake.setInfoSnake(InfoSnake.RIGHT);
                }
            }
            case Y -> snake.addFriend();
        }
    }
}
