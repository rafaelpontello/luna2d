package com.rpontello.scene;

import com.rpontello.Game;
import com.rpontello.manager.SceneManager;
import com.rpontello.manager.SceneManager.Scene;
import com.rpontello.manager.TileManager;
import com.rpontello.object.*;

import java.awt.Graphics2D;

public class Level01 implements GameObject {

    boolean init = false;
    boolean nextLevel = false;

    Background background;
    Player player;

    public Level01() {
        background = new Background();
        this.player = new Player(10);
        SceneManager.getGameObjects().add(background);
        SceneManager.getGameObjects().add(player);

    }


    @Override
    public void update() {

        if (player.getPosition().getX() > Game.GAME_WIDTH || player.getPosition().getY() > Game.GAME_HEIGHT) {
            nextLevel = true;
        }

        if(!init) {
            init = true;
            System.out.println("Init level 01...");
        }

        if (nextLevel) {
            SceneManager.nextScene(Scene.LEVEL_02);
        }



    }

    @Override
    public void render(Graphics2D g) {

    }
}
