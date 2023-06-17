package com.eduardo.app.actor;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.eduardo.app.Assets;
import com.eduardo.app.controller.StateNaveController;
import com.eduardo.app.util.Actor;
import com.eduardo.app.util.Motion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NaveActor extends Actor {
    private ModelInstance model;
    private Map<Motion, Boolean> state;
    private StateNaveController stateNaveController;
    private Vector3 position;

    public NaveActor(AssetManager assetManager) {
        super(assetManager);
        model = new ModelInstance(assetManager.get(Assets.NAVE_SIMPLE_OBJ, Model.class));
        state = new ConcurrentHashMap<>();
        position = new Vector3(0, 0, 0);
        stateNaveController = new StateNaveController(this, state);
        stateNaveController.start();
        configInitModel();
    }

    public void configInitModel() {
        Matrix4 transform = model.transform;
        transform.getTranslation(position);
        transform.setToRotation(0, 1, 0, 180);
        position.x = position.y = position.z = 0f;
        transform.setTranslation(position);
        model.transform.set(transform);
    }

    @Override
    protected void act(float delta) {
    }

    @Override
    protected void draw(ModelBatch batch, PerspectiveCamera camera) {
        batch.begin(camera);
        batch.render(model);
        batch.end();
    }


    public void changeState(Motion motion, Boolean value) {
        state.put(motion, value);
    }

    public void translate(float dx, float dy, float dz) {
        Matrix4 transform = model.transform;
        position.x += dx;
        position.y += dy;
        position.z += dz;
        transform.setTranslation(position);
        model.transform.set(transform);
    }

    public void rotateLeft() {
        Matrix4 transform = model.transform;
        transform.rotate(0, 0, -1, 0.00001f);
        model.transform.set(transform);
    }

    public void rotateRight() {
        Matrix4 transform = model.transform;
        transform.rotate(0, 0, 1, 0.00001f);
        model.transform.set(transform);
    }

}
