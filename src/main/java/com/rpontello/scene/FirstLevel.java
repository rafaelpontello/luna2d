package com.rpontello.scene;

import com.rpontello.object.GameObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import static com.rpontello.Game.GAME_HEIGHT;
import static com.rpontello.Game.GAME_WIDTH;

public class FirstLevel implements GameObject {


    @Override
    public void update() {
        System.out.println("New Level");
    }

    @Override
    public void render(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
    }
}
