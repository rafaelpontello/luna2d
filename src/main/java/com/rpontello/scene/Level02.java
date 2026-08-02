package com.rpontello.scene;

import com.rpontello.object.GameObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import static com.rpontello.Game.GAME_HEIGHT;
import static com.rpontello.Game.GAME_WIDTH;

public class Level02 implements GameObject {

    boolean init = false;

    @Override
    public void update() {
        if(!init) {
            init = true;
            System.out.println("Init level 02...");
        }
    }

    @Override
    public void render(Graphics2D g) {

    }
}
