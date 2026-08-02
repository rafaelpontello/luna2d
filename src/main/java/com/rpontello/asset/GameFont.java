package com.rpontello.asset;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class GameFont implements Asset{

    private Font font;
    private final String resource;

    public GameFont(String resource) {
        this.resource = resource;
        this.load();
    }

    public Font getFont(int style, int size) {
        return font.deriveFont(style, size);
    }

    @Override
    public void load() {
        try {
            var resourceStream = Sprite.class.getResourceAsStream(resource);
            if (resourceStream == null) {
                throw new Exception("Resource [" + resource + "] not found.");
            }
            font = Font.createFont(Font.TRUETYPE_FONT, resourceStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (Exception e) {
            System.out.println("Resource [" + resource + "] cannot be loaded.");
            throw new RuntimeException(e);
        }
    }
}
