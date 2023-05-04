package com.example.demo.snake;

import com.example.demo.Kafelek;
import javafx.scene.paint.Color;

public class Tolow extends Kafelek {

    private static int index = 0;
    private int myIndex;
    private InfoSnake infoSnake;
    private Tolow nextTolow;

    public Tolow(int width, int height, Color color){
        super(width, height, color);

        nextTolow = null;
        infoSnake = InfoSnake.LEFT;
        myIndex = index++;
    }

    public void przekazDalejDane(){
        if(nextTolow != null) {
            nextTolow.przekazDalejDane();
            nextTolow.setInfoSnake(infoSnake);
        }
    }


    //IMPORTANT
    public void setNextTolow(Tolow tolow){
        nextTolow = tolow;
    }

    protected void pelznij(){
        switch (infoSnake){
            case LEFT:
                updatePositionX(-getWidth());
                break;
            case RIGHT:
                updatePositionX(getWidth());
                break;
            case UP:
                updatePositionY(-getHeight());
                break;
            case DOWN:
                updatePositionY(getHeight());
                break;
        }
    }

    public InfoSnake getInfoSnake() {
        return infoSnake;
    }

    public void setInfoSnake(InfoSnake infoSnake) {
        this.infoSnake = infoSnake;
    }

    @Override
    public String toString() {
        return "Tolow{" +
                "myIndex=" + myIndex +
                ", infoSnake=" + infoSnake +'}';
    }
}
