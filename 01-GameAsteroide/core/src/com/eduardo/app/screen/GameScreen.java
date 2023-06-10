package com.eduardo.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.eduardo.app.MainGame;
import com.eduardo.app.actor.NaveActor;
import com.eduardo.app.input.Input;
import com.eduardo.app.util.BackgorundSpace;
import com.eduardo.app.util.BaseScreen;

public class GameScreen extends BaseScreen {
    private Stage stage;
    private NaveActor nave;
    private Input input;
    private Texture background;
    private BackgorundSpace backgorundSpace;

    public GameScreen(MainGame mainGame) {
        super(mainGame);
    }

    @Override
    public void show() {
        stage = new Stage();
        nave = new NaveActor();
        input = new Input(nave);
        backgorundSpace = new BackgorundSpace();
        Gdx.input.setInputProcessor(input);
        loadActorsStage();
        setPosInitialActors();
    }

    public void loadActorsStage() {
        stage.addActor(backgorundSpace.getFirtImage());
        stage.addActor(backgorundSpace.getSecondImage());
        stage.addActor(nave);
    }

    public void setPosInitialActors() {
        float posxNave = (Gdx.graphics.getWidth() * 0.5f) - (nave.getTexture().getWidth() * 0.5f);
        float posyNave = (Gdx.graphics.getHeight() * 0.5f) - (nave.getTexture().getHeight() * 0.5f);
        nave.setPosition(posxNave, posyNave);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.32f, 0.45f, 0.33f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backgorundSpace.update();
        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void dispose() {
    }
}
