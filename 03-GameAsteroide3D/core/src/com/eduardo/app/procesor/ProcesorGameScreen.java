package com.eduardo.app.procesor;

import com.badlogic.gdx.Game;
import com.eduardo.app.actor.AsteroidActor;
import com.eduardo.app.actor.BulletActor;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.extructura.Actor;
import com.eduardo.app.screen.GameScreen;
import com.eduardo.app.util.GraphicControl;


public class ProcesorGameScreen extends Thread {
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
            GraphicControl.WaitNextFrame();
            int size = GameScreen.stage.getActors().size();
            for (int i = 0; i < size; i++) {
                try {
                    Actor actor = GameScreen.stage.getActors().get(i);
                    if (actor instanceof BulletActor) {
                        handleBullet((BulletActor) actor);
                    }
                    if (actor instanceof AsteroidActor) {
                        handleAsteroid((AsteroidActor) actor);
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
    }

    private void handleBullet(BulletActor bullet) {
        if (bullet.exceedLimit()) {
            GameScreen.stage.removeActor(bullet);
            return;
        }
        bullet.translate(0, 0, -0.1f);
    }

    private void handleAsteroid(AsteroidActor asteroide) {
        if (asteroide.exceedLimit()) {
            GameScreen.stage.removeActor(asteroide);
            return;
        }
        asteroide.translate((float) (asteroide.getPendienteDx() * 0.01), (float) (asteroide.getPendienteDy() * 0.01), 0.05f);
        //asteroide.translate(0, 0, 0.05f);
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
