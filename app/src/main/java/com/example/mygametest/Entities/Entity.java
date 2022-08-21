package com.example.mygametest.Entities;

import android.graphics.Bitmap;


public abstract class Entity {

    //toado
    protected int x;
    protected int y;

    //rong dai
    protected int width;
    protected int height;

    //cac bien kem theo
    protected boolean remove;
    protected boolean beDestroy;

    //Image

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;

        remove = false;
        beDestroy = false;
    }

    public abstract boolean collide(Entity other);

    public abstract void update();
    public abstract void draw();


}
