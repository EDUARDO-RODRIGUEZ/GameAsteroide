package com.eduardo.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.eduardo.app.input.Input;
import com.eduardo.app.screen.GameScreen;

public class MainGame extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
