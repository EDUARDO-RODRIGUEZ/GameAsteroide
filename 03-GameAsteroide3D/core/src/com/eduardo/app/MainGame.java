package com.eduardo.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.eduardo.app.screen.GameScreen;
import com.eduardo.app.util.Assets;

public class MainGame extends Game {
    public static AssetManager assetManager = new AssetManager();

    public MainGame() {
        loadAssets();
    }

    public void loadAssets() {
        assetManager.load(Assets.NAVE_OBJ, Model.class);
        assetManager.load(Assets.MISSILE_OBJ, Model.class);
        assetManager.load(Assets.ASTEROIDE_OBJ, Model.class);
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
        getScreen().dispose();
    }
}
