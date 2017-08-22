package com.swar.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.swar.game.managers.Animation;

import static com.swar.game.utils.constants.GAME_WIDTH;

/**
 * Created by Koma on 17.01.2017.
 */
public class Sprite {

    protected Body body;
    protected Animation animation;
    protected float width;
    protected float height;
    protected float scale;

    public Sprite(Body body){
        this.body = body;
        animation = new Animation();
        this.scale = 2.5f;
        this.scale = GAME_WIDTH/(GAME_WIDTH*0.4f);
    }
    public void initSprite(Body body){
        this.body = body;
        animation = new Animation();
    }

    public void setAnimation(TextureRegion[] reg, float delay){
        animation.setFrames(reg, delay);
        width = reg[0].getRegionWidth()*scale;
        height = reg[0].getRegionHeight()*scale;
    }

    public void update(float dt){
        animation.update(dt);
    }

    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(animation.getFrame(), body.getPosition().x - width / 2, body.getPosition().y - height / 2, width, height);
        batch.end();
    }
    public Body getBody() {return body;}
    public Vector2 getPosition() { return body.getPosition();}
    public float getWidth() {return width;}
    public float getHeight() { return height;}

}