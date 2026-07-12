package com.rpontello.manager;

import com.rpontello.object.GameObject;
import com.rpontello.scene.FirstLevel;
import com.rpontello.scene.MainMenu;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    private static List<GameObject> gameObjects;
    private static GameObject currentScene;
    private static int sceneCounter;

    public static void init() {
        sceneCounter = 0;
        currentScene = new MainMenu();
        gameObjects = new ArrayList<>();
    }

    public static void update() {
        currentScene.update();
        gameObjects.forEach(GameObject::update);
    }

    public static void render(Graphics2D g)  {
        currentScene.render(g);
        gameObjects.forEach(obj -> obj.render(g));
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public static void resetGameObjects() {
        gameObjects = new ArrayList<>();
    }

    public static void nextScene() {
        System.out.println("Aqui");
        switch (sceneCounter) {
            case 0: currentScene = Scene.MAIN_MENU.load(); break;
            case 1: currentScene = Scene.FIRST_LEVEL.load(); break;
            default: {
                Scene.MAIN_MENU.load();
                sceneCounter = 0;
            };
        }
        sceneCounter++;
    }

}

enum Scene {
    MAIN_MENU(MainMenu.class),
    FIRST_LEVEL(FirstLevel.class);

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
