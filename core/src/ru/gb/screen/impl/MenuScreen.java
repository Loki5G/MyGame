package ru.gb.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.math.Rect;
import ru.gb.screen.BaseScreen;
import ru.gb.sprite.Logo;
import ru.gb.sprite.impl.Background;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture hero;
    private Vector2 pos;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("game_front.jpg");
        hero = new Texture("hero.png");
        background = new Background(img);
        logo = new Logo (hero);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        logo.update(delta);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        hero.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return super.touchDown(touch, pointer, button);
    }
}
