package com.rpontello;


import com.rpontello.manager.GameManager;
import com.rpontello.manager.InputManager;
import com.rpontello.manager.SceneManager;
import com.rpontello.manager.TileManager;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private boolean running = false;
    private Thread gameThread;

    private static final int FPS = 60;
    private static final double TIME_PER_FRAME = 1000000000.0 / FPS;

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public Game() {
        JFrame frame = new JFrame("2D");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setSize(GAME_WIDTH, GAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        GameManager.init(this);
        InputManager.init(this);
        SceneManager.init();
        TileManager.init();
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {
        running = false;
        System.exit(0);
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double delta = 0;

        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / TIME_PER_FRAME;
            lastTime = now;

            while (delta >= 1) {
                SceneManager.update();
                delta--;
            }

            SceneManager.render(getBufferStrategy());

        }

        stop();
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        if (super.getBufferStrategy() == null) {
            createBufferStrategy(3);
        }
        return super.getBufferStrategy();
    }


    public static void main(String[] args) {
        new Game().start();
    }



}