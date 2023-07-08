package com.eduardo.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.eduardo.app.MainGame;
import com.eduardo.app.procesor.ProcesorGameScreen;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.controller.InputController;
import com.eduardo.app.producer.ProducerAsteroid;
import com.eduardo.app.util.BaseScreen;
import com.eduardo.app.extructura.Stage;

public class GameScreen extends BaseScreen {
    public static Stage stage = new Stage();
    private ProcesorGameScreen procesor;
    private InputController inputController;
    private ProducerAsteroid producerAsteroid;
    public static NaveActor naveActor = new NaveActor();

    public GameScreen(MainGame mainGame) {
        super(mainGame);
        this.inputController = new InputController();
        this.procesor = new ProcesorGameScreen();
        this.producerAsteroid = new ProducerAsteroid();
        loadActors();
        loadControllers();
        lauchThreads();
    }

    private void loadControllers() {
        inputController.setNaveActor(naveActor);
        Gdx.input.setInputProcessor(inputController);
    }

    public void loadActors() {
        stage.addActor(naveActor);
    }

    public void lauchThreads() {
        procesor.start();
        producerAsteroid.start();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        procesor.finalizar();
        producerAsteroid.finalizar();
        stage.dispose();
    }
}
