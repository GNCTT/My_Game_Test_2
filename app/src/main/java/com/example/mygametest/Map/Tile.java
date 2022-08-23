package com.example.mygametest.Map;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Tile {

    public enum TileType{
        BrickTile1,
        BrickTile2,
        BridgeTile1,
        BridgeTile2,
        DecorBrick
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {

        switch(TileType.values()[idxTileType]) {

            case BrickTile1:
                return new BrickTile1(spriteSheet, mapLocationRect);
            case BrickTile2:
                return new BrickTile2(spriteSheet, mapLocationRect);
            case BridgeTile1:
                return new BridgeTile1(spriteSheet, mapLocationRect);
            case BridgeTile2:
                return new BridgeTile2(spriteSheet, mapLocationRect);
            case DecorBrick:
                return new DecorBrick(spriteSheet, mapLocationRect);
            default:
                return null;
        }

    }
}
