package com.rpontello.manager;

import com.rpontello.Game;

public class GameManager {

    private static Game game;

    public static void init(Game game) {
        GameManager.game = game;
        loadScenes();
    }


    public static void existGame() {
        game.stop();
    }

    public static void loadScenes() {




    }

}
