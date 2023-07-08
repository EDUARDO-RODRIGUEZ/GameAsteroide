package com.eduardo.app.extructura;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public abstract class Actor {
    protected AssetManager assetManager;
    private Vector3 position, scale, rotate;
    private ModelInstance model;

    public Actor(AssetManager assetManager) {
        this.assetManager = assetManager;
        position = new Vector3(0, 0, 0);
        scale = new Vector3(1, 1, 1);
        rotate = new Vector3(0, 0, 0);
    }

    protected abstract void draw(ModelBatch batch, PerspectiveCamera camera);

    protected abstract void dispose();

    public void setTranslate(float x, float y, float z) {
        Matrix4 transform = model.transform;
        position.x = x;
        position.y = y;
        position.z = z;
        transform.setTranslation(position);
    }

    public void translate(float dx, float dy, float dz) {
        Matrix4 transform = model.transform;
        position.x += dx;
        position.y += dy;
        position.z += dz;
        transform.setTranslation(position);
    }

    public void setScale(float x, float y, float z) {
        Matrix4 transform = model.transform;
        transform.scale(x, y, z);
    }

    public void scale(float x, float y, float z) {
        Matrix4 transform = model.transform;
        scale.x += x;
        scale.y += y;
        scale.z += z;
        transform.scale(x, y, z);
    }

    public void setRotate(float x, float y, float z, float value) {
        Matrix4 transform = model.transform;
        transform.rotate(x, y, z, value);
    }


    public void rotate(Vector3 rotate, float x, float y, float z, float value) {
        Matrix4 transform = model.transform;
        rotate.x += x * value;
        rotate.y += y * value;
        rotate.z += z * value;
        transform.rotate(x, y, z, value);
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        setTranslate(position.x,position.y,position.z);
    }

    public Vector3 getScale() {
        return scale;
    }

    public void setScale(Vector3 scale) {
        this.scale = scale;
    }

    public Vector3 getRotate() {
        return rotate;
    }

    public void setRotate(Vector3 rotate) {
        this.rotate = rotate;
    }

    public ModelInstance getModel() {
        return model;
    }

    public void setModel(ModelInstance model) {
        this.model = model;
    }
}
