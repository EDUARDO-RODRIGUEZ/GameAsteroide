package com.eduardo.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.eduardo.app.screen.GameScreen;

public class MainGame extends Game {
    private AssetManager assetManager;

    public MainGame(){
        assetManager = new AssetManager();
        loadAssets();
    }

    public void loadAssets(){
        assetManager.load(Assets.NAVE_SIMPLE_OBJ, Model.class);
    }

    @Override
    public void create() {
        assetManager.finishLoading();
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        super.render();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
