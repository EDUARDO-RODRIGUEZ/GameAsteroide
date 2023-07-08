package com.eduardo.app.extructura;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.eduardo.app.extructura.Actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stage {
    private List<Actor> actors;
    private ModelBatch modelBatch;
    private PerspectiveCamera camera;

    public Stage() {
        this.actors = Collections.synchronizedList(new ArrayList<Actor>());
        this.modelBatch = new ModelBatch();
        this.camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        configCamera();
    }

    public void configCamera() {
        camera.position.set(0f, 1f, 2f);
        camera.lookAt(0, 0, 0);
        camera.near = 0f;
        camera.far = 300f;
        camera.update();
    }

    public synchronized void addActor(Actor actor) {
        actors.add(actor);
    }

    public synchronized void removeActor(Actor actor) {
        actors.remove(actor);
    }

    public synchronized List<Actor> getActors() {
        return actors;
    }

    public synchronized void draw() {
        for (Actor actor : actors) {
            actor.draw(modelBatch, camera);
        }
    }

    public synchronized void dispose() {
        for (Actor actor : actors) {
            actor.dispose();
        }
        modelBatch.dispose();
    }

}
