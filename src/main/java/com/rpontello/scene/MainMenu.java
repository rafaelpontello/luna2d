package com.rpontello.scene;

import com.rpontello.asset.GameFont;
import com.rpontello.manager.GameManager;
import com.rpontello.manager.InputManager;
import com.rpontello.manager.SceneManager;
import com.rpontello.manager.SceneManager.Scene;
import com.rpontello.object.GameObject;

import java.awt.*;

import static com.rpontello.Game.GAME_HEIGHT;
import static com.rpontello.Game.GAME_WIDTH;

public class MainMenu implements GameObject {

    private final Rectangle startGame;
    private final Rectangle exitGame;
    private final GameFont gameFont;

    private boolean isStart = false;
    private boolean isExist = false;

    public MainMenu() {
        startGame = new Rectangle(280, 150, 200, 50);
        exitGame  = new Rectangle(280, 280, 200, 50);
        gameFont = new GameFont("/assets/font/space.otf");
    }

    @Override
    public void update() {

        var mouseClick = InputManager.getMouseClick();

        if (mouseClick != null) {
            if (!isStart && startGame.contains(mouseClick.getPoint())) {
                isStart = true;
                System.out.println("Starting...");
                SceneManager.nextScene(Scene.LEVEL_01);
            }

            if (!isExist && exitGame.contains(mouseClick.getPoint())) {
                isExist = true;
                System.out.println("Exiting...");
                GameManager.existGame();
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        g.setFont(gameFont.getFont(Font.BOLD, 48));
        g.setColor(Color.WHITE);
        drawString(g, "START GAME", startGame);

        g.setFont(gameFont.getFont(Font.BOLD, 38));
        g.setColor(isExist ? Color.RED : Color.WHITE);
        drawString(g, "EXIT", exitGame);
    }

    private void drawString(Graphics2D g, String text, Rectangle rect) {
        FontMetrics fm = g.getFontMetrics();
        int x = rect.x + (rect.width - fm.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(text, x, y);
    }

}
