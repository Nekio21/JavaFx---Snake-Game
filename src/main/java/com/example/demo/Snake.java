package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake extends Kafelek implements SnakeFunction {

    private ArrayList<Tolow> list;
    private InfoSnake infoSnake;

    public Snake(int width, int height, Color color) {
        super(width, height, color);

        list = new ArrayList();
        infoSnake = InfoSnake.LEFT;
    }

    public void addFriend(){
        Tolow tolow = new Tolow(getWidth(), getHeight(), Color.rgb((int)Math.random()%255,(int)Math.random()%255, (int)Math.random()%255));

        Kafelek previous;

        if(list.size() == 0){
            previous = this;
        }else {
            previous = list.get(list.size() - 1);
        }

        int positionX = previous.getPositionX() + previous.getWidth();
        int positionY = previous.getPositionY();

        tolow.setPosition(positionX, positionY);

        list.add(tolow);
    }

    public void drawSnake(GraphicsContext gc){
        drawKafelek(gc);
        for(Tolow t: list){
            t.drawKafelek(gc);
        }
    }

    public void update(GraphicsContext gc) {
        pelznij(infoSnake);
        drawSnake(gc);
        przekazDalejDane(infoSnake);
        
    }

    @Override
    public void przekazDalejDane(InfoSnake infoSnake) {

    }

    private void pelznij(InfoSnake infoSnake){
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
}
