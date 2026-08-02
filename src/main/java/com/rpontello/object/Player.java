package com.rpontello.object;

import com.rpontello.asset.Sprite;
import com.rpontello.manager.InputManager;

import java.awt.*;

public class Player implements GameObject {

    private final Sprite sprite;
    private final Position position;

    private int life;
    private int speed;

    public Player(int speed) {
        this.sprite = new Sprite("/assets/idle.png");
        this.position = new Position(100, 100);
        this.life = 10;
        this.speed = speed;
    }

    @Override
    public void update() {

        double moveX = 0;
        double moveY = 0;

        if (InputManager.isKeyPressed('a')) moveX -= 1;
        if (InputManager.isKeyPressed('d')) moveX += 1;
        if (InputManager.isKeyPressed('w')) moveY -= 1;
        if (InputManager.isKeyPressed('s')) moveY += 1;

        double magnitude = Math.sqrt(moveX * moveX + moveY * moveY);

        if (magnitude > 0) {
            moveX = moveX / magnitude;
            moveY = moveY / magnitude;
        }

        int newX = (int) (position.getX() + (moveX * speed));
        int newY = (int) (position.getY() + (moveY * speed));

        position.setX(newX);
        position.setY(newY);
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(sprite.getBuffer(), position.getX(), position.getY(), null);
    }


    public Position getPosition() {
        return position;
    }
}
