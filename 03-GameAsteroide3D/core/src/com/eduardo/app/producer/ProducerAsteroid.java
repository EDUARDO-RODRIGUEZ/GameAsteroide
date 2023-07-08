package com.eduardo.app.producer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector3;
import com.eduardo.app.actor.AsteroidActor;
import com.eduardo.app.screen.GameScreen;
import com.eduardo.app.util.GraphicControl;

public class ProducerAsteroid extends Thread {
    private boolean suspend;
    private boolean finish;

    @Override
    public void run() {
        while (true) {
            try {
                if (suspend) wait();
                if (finish) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GraphicControl.WaitMilliSeconds(500);
            AsteroidActor asteroide = new AsteroidActor();
            float posx = (float) (Math.random() * (2) + (-1));
            float posy = (float) (Math.random() * (2) + (-1));
            asteroide.setPosition(new Vector3(posx, posy, -10.0f));
            asteroide.calcuarlPendiente(GameScreen.naveActor.getPosition());
            GameScreen.stage.addActor(asteroide);
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
