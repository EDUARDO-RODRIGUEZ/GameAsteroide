package com.eduardo.app.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.eduardo.app.actor.BulletActor;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.screen.GameScreen;
import com.eduardo.app.util.GraphicControl;
import com.eduardo.app.util.Motion;

import java.util.Map;

public class StateNaveController extends Thread {
    private boolean finish;
    private boolean suspend;
    public static float SPEED = 5f;
    private NaveActor naveActor;
    private Map<Motion, Boolean> states;

    public StateNaveController(NaveActor naveActor, Map<Motion, Boolean> states) {
        this.naveActor = naveActor;
        this.states = states;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (suspend) wait();
                if (finish) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GraphicControl.WaitNextFrame();
            handleMoveNave();
        }
    }


    public void handleMoveNave() {
        for (Map.Entry<Motion, Boolean> state : states.entrySet()) {
            if (state.getKey().equals(Motion.UP) && state.getValue()) {
                naveActor.translate(0, SPEED * Gdx.graphics.getDeltaTime(), 0);
            }
            if (state.getKey().equals(Motion.DOWN) && state.getValue()) {
                naveActor.translate(0, -SPEED * Gdx.graphics.getDeltaTime(), 0);
            }
            if (state.getKey().equals(Motion.LEFT) && state.getValue()) {
                naveActor.translate(-SPEED * Gdx.graphics.getDeltaTime(), 0, 0);
            }
            if (state.getKey().equals(Motion.RIGHT) && state.getValue()) {
                naveActor.translate(SPEED * Gdx.graphics.getDeltaTime(), 0, 0);
            }
            if (state.getKey().equals(Motion.FRONT) && state.getValue()) {
                naveActor.translate(0, 0, -SPEED * Gdx.graphics.getDeltaTime());
            }
            if (state.getKey().equals(Motion.BACK) && state.getValue()) {
                naveActor.translate(0, 0, SPEED * Gdx.graphics.getDeltaTime());
            }
            if (state.getKey().equals(Motion.SHOOT) && state.getValue()) {
                BulletActor bulletActor = new BulletActor();
                bulletActor.setPosition(new Vector3(naveActor.getPosition()));
                GameScreen.stage.addActor(bulletActor);
            }
        }
    }

    public void suspender() {
        suspend = true;
    }

    public void reanudar() {
        if (suspend) {
            suspend = false;
            notify();
        }
    }

    public void finalizar() {
        finish = true;
        if (suspend) {
            notify();
        }
    }

}