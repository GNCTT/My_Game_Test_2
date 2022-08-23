package com.example.mygametest.Map;

import static com.example.mygametest.Map.MapLayout.NUMBER_OF_COLUMN_TILES;
import static com.example.mygametest.Map.MapLayout.NUMBER_OF_ROW_TILES;

public class Tilemap {

    private final MapLayout mapLayout;
    private Tile[][] tilemap;

    public Tilemap() {
        mapLayout = new MapLayout();
        initializeTilemap();
    }

    private void initializeTilemap() {
        int[][] layout = mapLayout.getLayout();

        for(int iRow=0; iRow<NUMBER_OF_ROW_TILES; iRow++){
            for(int iCol=0; iCol<NUMBER_OF_COLUMN_TILES; iCol++){
                tilemap[iRow][iCol] = Tile.getTile(

                );
            }
        }
    }
}
