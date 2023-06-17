package com.eduardo.app.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.util.Motion;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class InputController extends InputAdapter {

    private NaveActor naveActor;

    public InputController() {
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                naveActor.changeState(Motion.UP, true);
                break;
            case Keys.S:
                naveActor.changeState(Motion.DOWN, true);
                break;
            case Keys.A:
                naveActor.changeState(Motion.LEFT, true);
                break;
            case Keys.D:
                naveActor.changeState(Motion.RIGHT, true);
                break;
            case Keys.O:
                naveActor.changeState(Motion.FRONT, true);
                break;
            case Keys.L:
                naveActor.changeState(Motion.BACK, true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.W:
                naveActor.changeState(Motion.UP, false);
                break;
            case Keys.S:
                naveActor.changeState(Motion.DOWN, false);
                break;
            case Keys.A:
                naveActor.changeState(Motion.LEFT, false);
                break;
            case Keys.D:
                naveActor.changeState(Motion.RIGHT, false);
                break;
            case Keys.O:
                naveActor.changeState(Motion.FRONT, false);
                break;
            case Keys.L:
                naveActor.changeState(Motion.BACK, false);
                break;
        }
        return true;
    }

    public void setNaveActor(NaveActor naveActor) {
        this.naveActor = naveActor;
    }
}
