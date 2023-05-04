package com.example.demo.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake extends Tolow {

    private ArrayList<Tolow> list;

    public Snake(int width, int height, Color color) {
        super(width, height, color);

        list = new ArrayList();
    }

    public void addFriend(){
        Tolow tolow = new Tolow(getWidth(), getHeight(), Color.rgb((int)Math.random()%255,(int)Math.random()%255, (int)Math.random()%255));

        Tolow previous;

        if(list.size() == 0){
            previous = this;
        }else {
            previous = list.get(list.size() - 1);
        }

        previous.setNextTolow(tolow);

        setPositionForFriend(tolow, previous);

        tolow.setInfoSnake(previous.getInfoSnake());

        list.add(tolow);
    }

    private void setPositionForFriend(Tolow newTolow, Tolow previousTolow) {
        int positionX = -1;
        int positionY = -1;


        switch (previousTolow.getInfoSnake()){
            case RIGHT -> {
                positionX = previousTolow.getPositionX() - previousTolow.getWidth();
                positionY = previousTolow.getPositionY();
            }
            case LEFT -> {
                positionX = previousTolow.getPositionX() + previousTolow.getWidth();
                positionY = previousTolow.getPositionY();
            }
            case UP -> {
                positionX = previousTolow.getPositionX();
                positionY = previousTolow.getPositionY() + previousTolow.getHeight();
            }
            case DOWN -> {
                positionX = previousTolow.getPositionX();
                positionY = previousTolow.getPositionY() - previousTolow.getHeight();
            }
        }

        newTolow.setPosition(positionX, positionY);
    }

    public void drawSnake(GraphicsContext gc){
        drawKafelek(gc);
        for(Tolow t: list){
            t.drawKafelek(gc);
        }
    }

    public void update(GraphicsContext gc) {
        pelznij();

        for(Tolow t: list){
            t.pelznij();
        }

        drawSnake(gc);

        przekazDalejDane();
    }
}
