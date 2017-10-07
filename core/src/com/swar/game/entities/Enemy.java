package com.swar.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.swar.game.BulletType;
import com.swar.game.Game;
import com.swar.game.Models.Creator;
import com.swar.game.Models.Killable;
import com.swar.game.Models.Moveable;
import com.swar.game.managers.World.BodyBuilder;
import com.swar.game.managers.World.ObjectHandler;

import static com.swar.game.utils.constants.GAME_WIDTH;

/**
 * Created by Koma on 07.10.2017.
 */
public class Enemy extends Sprite implements Killable, Moveable, Creator{
    public float hp = 200;
    public float collisionDmg = 30;
    public float speed = -(GAME_WIDTH)/5;

    public Enemy(Body body){
        super(body);
        Texture tex;
        tex = Game.res.getTexture("enemy");
        TextureRegion[] sprites = TextureRegion.split(tex, 32, 32)[0];

        setAnimation(sprites, 1 / 12f);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
    }

    @Override
    public float getHp() {
        return this.hp;
    }

    @Override
    public void setHp(float hp) {
        this.hp = hp;
    }


    @Override
    public void decreaseHp(float hp) {

    }

    @Override
    public void increaseHp(float hp) {

    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public void decreaseSpeed(float speed) {

    }

    @Override
    public void increaseSpeed(float speed) {

    }


    @Override
    public boolean createObject(BodyBuilder bodyBuilder, ObjectHandler objectHandler) {
        float x = getBody().getPosition().x;
        float y = getBody().getPosition().y;

        Body bulletBody;
        Bullet b;


        bulletBody = bodyBuilder.createBulletEnemy(x, y + 5);
        b = new Bullet(bulletBody, BulletType.bullet_1, BulletType.getbullet(BulletType.bullet_1), -1000);
        bulletBody.setUserData(b);
        objectHandler.add(b);
        return true;


    }
}
