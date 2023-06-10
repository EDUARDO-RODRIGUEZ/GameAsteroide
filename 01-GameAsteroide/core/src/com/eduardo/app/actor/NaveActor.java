package com.eduardo.app.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.*;

public class NaveActor extends Actor {
    public static int SPEED = 200;
    private Texture texture;
    private boolean moveRight, moveLeft, moveUp, moveDown;

    public NaveActor() {
        texture = new Texture("nave.png");
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        handleInput();
        batch.draw(texture, getX(), getY());
    }

    public void handleInput() {
        if (moveRight) {
            setX(getX() + SPEED * Gdx.graphics.getDeltaTime());
        }
        if (moveLeft) {
            setX(getX() - SPEED * Gdx.graphics.getDeltaTime());
        }
        if (moveUp) {
            setY(getY() + SPEED * Gdx.graphics.getDeltaTime());
        }
        if (moveDown) {
            setY(getY() - SPEED * Gdx.graphics.getDeltaTime());
        }
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public Texture getTexture() {
        return texture;
    }
}
