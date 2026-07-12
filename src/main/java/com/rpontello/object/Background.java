package com.rpontello.object;

import com.rpontello.asset.Sprite;

import java.awt.*;

public class Background implements GameObject {

    private Sprite sprite;

    public Background() {
        this.sprite = new Sprite("/assets/bg_blue.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {

        Rectangle area = new Rectangle(0, 0, 64, 64);
        TexturePaint texture = new TexturePaint(sprite.getBuffer(), area);

        g.setPaint(texture);
        g.fillRect(0, 0, 800, 600);
    }
}
