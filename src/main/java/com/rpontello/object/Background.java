package com.rpontello.object;

import com.rpontello.Game;
import com.rpontello.asset.Sprite;
import com.rpontello.manager.TileManager;

import java.awt.*;

public class Background implements GameObject {

    private final Sprite sprite;

    public Background() {
        this.sprite = new Sprite("/assets/bg_blue.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {


    }

}
