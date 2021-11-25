package ru.gb.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.screen.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture img2;
    private Vector2 touch;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        img = new Texture("game_front.jpg");
        img2 = new Texture("hero.png");
        touch = new Vector2();
        v = new Vector2(1,1);
//        v = v.cpy().scl(2);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth() ,Gdx.graphics.getHeight());
        batch.draw(img2, touch.x, touch.y);
        batch.end();
        touch.add(v);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        img2.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
