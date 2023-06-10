package com.eduardo.app.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.eduardo.app.actor.NaveActor;

public class Input extends InputAdapter {
    private NaveActor nave;

    public Input(Actor nave) {
        this.nave = (NaveActor) nave;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                nave.setMoveUp(true);
                break;
            case Keys.S:
                nave.setMoveDown(true);
                break;
            case Keys.A:
                nave.setMoveLeft(true);
                break;
            case Keys.D:
                nave.setMoveRight(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W:
                nave.setMoveUp(false);
                break;
            case Keys.S:
                nave.setMoveDown(false);
                break;
            case Keys.A:
                nave.setMoveLeft(false);
                break;
            case Keys.D:
                nave.setMoveRight(false);
                break;
        }
        return true;
    }


}
