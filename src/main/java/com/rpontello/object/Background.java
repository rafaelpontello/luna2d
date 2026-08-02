package com.rpontello.object;

import com.rpontello.Game;
import com.rpontello.asset.Sprite;
import com.rpontello.manager.TileManager;

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


        var x = 0;
        while(x < Game.GAME_WIDTH) {
            g.drawImage(TileManager.get(7), x, 500, 16, 16, null);
            g.drawImage(TileManager.get(9), x, 516, 16, 16, null);
            g.drawImage(TileManager.get(9), x, 532, 16, 16, null);
            g.drawImage(TileManager.get(9), x, 548, 16, 16, null);
            g.drawImage(TileManager.get(9), x, 564, 16, 16, null);

            x += 16;
        }

    }
}
