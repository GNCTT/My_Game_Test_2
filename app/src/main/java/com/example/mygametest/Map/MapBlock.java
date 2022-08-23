package com.example.mygametest.Map;

public class MapBlock {
    public static final int NUMBER_OF_ROW_TILES = 60;
    public static final int NUMBER_OF_COLUMN_TILES = 60;

    public MapBlock(){}

    public boolean checkValid(int x, int y){
        if(x<0 || x>=NUMBER_OF_COLUMN_TILES || y<0 || y>=NUMBER_OF_ROW_TILES)
            return false;
        return true;
    }

    public int[][] createHorizontalLineBlock(int map[][], int x1, int x2, int y, int asset){
        if(checkValid(x1, y) && checkValid(x2, y)) {
            for (int i = x1; i <= x2; i++) {
                map[y][i] = asset;
            }
        }
        return map;
    }

    public int[][] createVerticalLineBlock(int map[][], int y1, int y2, int x, int asset){
        if(checkValid(x, y1) && checkValid(x, y2)) {
            for (int i = y1; i <= y2; i++) {
                map[i][x] = asset;
            }
        }
        return map;
    }

    public int[][] createBlock(int map[][], int x, int y, int asset){
        if(checkValid(x, y)) {
            map[y][x] = asset;
        }
        return map;
    }
}
