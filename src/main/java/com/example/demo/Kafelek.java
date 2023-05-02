package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kafelek {

    private Color color;

    private int width;
    private int height;

    private int positionX;
    private int positionY;


    public Kafelek(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;

        positionX = 0;
        positionY = 0;
    }

    public Kafelek(int width, int height, int positionX, int positionY, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;

        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void drawKafelek(GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(positionX,positionY, width, height);
    }

    public void setPosition(int positionX, int positionY){
        this.positionY = positionY;
        this.positionX = positionX;
    }

    public void updatePosition(int updateX, int updateY){
        updatePositionY(updateY);
        updatePositionX(updateX);
    }

    public void updatePositionX(int updateX){
        positionX = positionX + updateX;
    }

    public void updatePositionY(int updateY){
        positionY = positionY + updateY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
