package ru.gb.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.math.Rect;

public class Logo extends Sprite{

    private Vector2 touch;


    public Logo(Texture texture){
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.15f);
        this.touch = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.set(touch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
