package com.rpontello.object;

import com.rpontello.asset.Sprite;

public record Tile(
       int topLeft,
       int topRight,
       int botLeft,
       int botRight
) {
}
