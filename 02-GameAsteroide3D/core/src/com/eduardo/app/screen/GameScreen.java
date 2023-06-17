package com.eduardo.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.eduardo.app.MainGame;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.controller.InputController;
import com.eduardo.app.util.BaseScreen;
import com.eduardo.app.util.Stage;

public class GameScreen extends BaseScreen {
    private Stage stage;
    private InputController inputController;

    public GameScreen(MainGame mainGame) {
        super(mainGame);
        this.stage = new Stage();
        this.inputController = new InputController();
        loadActors();
    }

    public void loadActors() {
        NaveActor naveActor = new NaveActor(mainGame.getAssetManager());
        stage.addActor(naveActor);
        inputController.setNaveActor(naveActor);
        Gdx.input.setInputProcessor(inputController);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
