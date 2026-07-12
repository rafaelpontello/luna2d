package com.rpontello.asset;

import com.rpontello.manager.AssetManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Sprite implements Asset {

    private BufferedImage buffer;
    private final String resource;

    public Sprite(String resource) {
        this.resource = resource;
        AssetManager.add(this);
    }

    @Override
    public void load() {
        try {
            var resourceStream = Sprite.class.getResourceAsStream(resource);
            if (resourceStream == null) {
                throw new Exception("Resource [" + resource + "] not found.");
            }
            buffer = ImageIO.read(resourceStream);
        } catch (Exception e) {
            System.out.println("Resource [" + resource + "] cannot be loaded.");
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getBuffer() {
        return buffer;
    }
}
