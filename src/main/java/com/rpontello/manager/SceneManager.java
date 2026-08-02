package com.rpontello.manager;

import com.rpontello.object.GameObject;
import com.rpontello.scene.Level01;
import com.rpontello.scene.Level02;
import com.rpontello.scene.MainMenu;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import static com.rpontello.Game.GAME_HEIGHT;
import static com.rpontello.Game.GAME_WIDTH;

public class SceneManager {

    private static List<GameObject> gameObjects;
    private static GameObject currentScene;
    private static int sceneCounter;

    public enum Scene {
        MAIN_MENU(MainMenu.class),
        LEVEL_01(Level01.class),
        LEVEL_02(Level02.class);

        final Class<? extends GameObject> gameObject;
        Scene(Class<? extends GameObject> gameObject){
            this.gameObject = gameObject;
        }

        GameObject load() {
            try {
                return (GameObject) gameObject.getConstructors()[0].newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void init() {
        gameObjects = new ArrayList<>();
        nextScene(Scene.MAIN_MENU);
    }

    public static void update() {
        currentScene.update();
        gameObjects.forEach(GameObject::update);
    }

    public static void render(BufferStrategy bufferStrategy)  {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        currentScene.render(g);
        gameObjects.forEach(obj -> obj.render(g));

        g.dispose();
        bufferStrategy.show();
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public static void resetGameObjects() {
        gameObjects = new ArrayList<>();
    }

    public static void nextScene(Scene scene) {
        currentScene = scene.load();
    }

}


