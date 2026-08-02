package com.rpontello.manager;

import com.rpontello.asset.Sprite;

import java.awt.image.BufferedImage;

public class TileManager {
    public static final int TILE_SIZE = 16;

    private static BufferedImage[] tiles;

    public static void init() {

        var sheet = new Sprite("/assets/terrain_16x16.png");

        int columns = sheet.getBuffer().getWidth() / TILE_SIZE;
        int rows = sheet.getBuffer().getHeight() / TILE_SIZE;

        tiles = new BufferedImage[columns * rows];

        int index = 0;

        for (int y = 0; y < rows; y++) {

            for (int x = 0; x < columns; x++) {

                tiles[index++] = sheet.getBuffer().getSubimage(
                        x * TILE_SIZE,
                        y * TILE_SIZE,
                        TILE_SIZE,
                        TILE_SIZE
                );

            }

        }
    }

    public static BufferedImage get(int id) {
        return tiles[id];
    }

    public static int size() {
        return tiles.length;
    }

}
