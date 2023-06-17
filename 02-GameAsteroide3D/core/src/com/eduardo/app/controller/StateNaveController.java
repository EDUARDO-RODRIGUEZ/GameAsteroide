package com.eduardo.app.controller;

import com.badlogic.gdx.Gdx;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.util.Motion;

import java.util.Iterator;
import java.util.Map;

public class StateNaveController extends Thread {
    public static float SPEED = 0.00001F;
    private NaveActor naveActor;
    private Map<Motion, Boolean> states;

    public StateNaveController(NaveActor naveActor, Map<Motion, Boolean> states) {
        this.naveActor = naveActor;
        this.states = states;
    }

    @Override
    public void run() {
        while (true) {
            for (Map.Entry<Motion, Boolean> state : states.entrySet()) {
                if (state.getKey().equals(Motion.UP) && state.getValue()) {
                    naveActor.translate(0, SPEED * Gdx.graphics.getDeltaTime(), 0);
                }
                if (state.getKey().equals(Motion.DOWN) && state.getValue()) {
                    naveActor.translate(0, -SPEED * Gdx.graphics.getDeltaTime(), 0);
                }
                if (state.getKey().equals(Motion.LEFT) && state.getValue()) {
                    naveActor.translate(-SPEED * Gdx.graphics.getDeltaTime(), 0, 0);
                    naveActor.rotateLeft();
                }
                if (state.getKey().equals(Motion.RIGHT) && state.getValue()) {
                    naveActor.translate(SPEED * Gdx.graphics.getDeltaTime(), 0, 0);
                    naveActor.rotateRight();
                }
                if (state.getKey().equals(Motion.FRONT) && state.getValue()) {
                    naveActor.translate(0, 0, -SPEED * Gdx.graphics.getDeltaTime());
                }
                if (state.getKey().equals(Motion.BACK) && state.getValue()) {
                    naveActor.translate(0, 0, SPEED * Gdx.graphics.getDeltaTime());
                }
            }
        }
    }
}
