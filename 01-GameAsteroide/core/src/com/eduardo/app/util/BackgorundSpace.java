package com.eduardo.app.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BackgorundSpace {
    private Texture texture;
    private Image firtImage;
    private Image secondImage;
    private int pos1x, pos1y, pos2x, pos2y;
    private boolean upFirstImage, upSecondImage;

    public BackgorundSpace() {
        pos1x = 0;
        pos1y = 0;
        pos2x = 0;
        pos2y = 0;
        texture = new Texture("background_space.png");
        firtImage = new Image(texture);
        secondImage = new Image(texture);

        firtImage.setHeight(Gdx.graphics.getHeight() * 2);
        firtImage.setWidth(Gdx.graphics.getWidth());
        firtImage.setPosition(pos1x, pos1y);

        secondImage.setHeight(Gdx.graphics.getHeight() * 2);
        secondImage.setWidth(Gdx.graphics.getWidth());
        secondImage.setPosition(pos2x, pos2y);
    }

    public void update() {
        if (firtImage.getY() < 0 && !upSecondImage) {
            secondImage.setY(Gdx.graphics.getHeight() * 2 - 10);
            upSecondImage = true;
            upFirstImage = false;
        }
        if (secondImage.getY() < 0 && !upFirstImage) {
            firtImage.setY(Gdx.graphics.getHeight() * 2 -10);
            upFirstImage = true;
            upSecondImage = false;
        }
        firtImage.setY(firtImage.getY() - 200 * Gdx.graphics.getDeltaTime());
        secondImage.setY(secondImage.getY() - 200 * Gdx.graphics.getDeltaTime());
    }

    public Image getFirtImage() {
        return firtImage;
    }

    public Image getSecondImage() {
        return secondImage;
    }

}
