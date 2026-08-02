package com.rpontello.object;

import com.rpontello.asset.Sprite;

import java.util.ArrayList;
import java.util.List;

public class TileMap {

    private final List<List<Tile>> grid;

    public TileMap(int size) {
        this.grid = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.grid.add(i, new ArrayList<>(size));
        }
    }

    public void addSprite(int row, int column, Tile tile) {
        grid.get(row).add(column, tile);
    }


    public List<List<Tile>> getGrid() {
        return grid;
    }
}
