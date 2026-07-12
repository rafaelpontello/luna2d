package com.rpontello.manager;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class InputManager {

    private static final Map<Character, Boolean> KEYBOARD_MAP = new HashMap<>();

    private static KeyListener keyListener;
    private static MouseListener mouseListener;

    private static MouseEvent mouseLastClick;
    private static MouseEvent mouseEnter;

    public static void init(Component game) {
        game.addKeyListener(getKeyListener());
        game.addMouseListener(getMouseListener());
    }


    private static KeyListener getKeyListener() {
        if (keyListener != null) return keyListener;
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // do nothing...
            }
            @Override
            public void keyPressed(KeyEvent e) {
                KEYBOARD_MAP.put(e.getKeyChar(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KEYBOARD_MAP.put(e.getKeyChar(), false);
            }
        };
        return keyListener;
    }

    private static MouseListener getMouseListener() {
        if (mouseListener != null) return mouseListener;
        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseLastClick = e;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEnter = e;
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        return mouseListener;
    }

    public static boolean isKeyPressed(Character character) {
        return KEYBOARD_MAP.getOrDefault(character, false);
    }

    public static MouseEvent getMouseClick() {
        return mouseLastClick;
    }

    public static MouseEvent getMouseMoviment() {
        return mouseEnter;
    }

}
