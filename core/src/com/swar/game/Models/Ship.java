package com.swar.game.Models;

import java.util.ArrayList;

/**
 * Created by Koma on 27.01.2017.
 */
public class Ship implements Killable, Moveable{
    private float hp;

    private float speed;

    private int energy = 200;
    public int armor;
    private String shipSprite;
    private String Sprite;

    private float weaponPositionX[] = new float[10];//пусть будет 10 оружек - максимум
    private float weaponPositionY[] = new float[10];
    public ArrayList<Weapon> weapons = new ArrayList<>();

    private int carryWeapons;
    private int carryEquipment;

    public Ability ability;
    private int height;
    private int width;

    public Ship(float speed, int hp,
                int armor, String shipSprite,
                String Sprite, float weaponPositionX[],
                float weaponPositionY[],
                int carryWeapons, int carryEquipment,
                ArrayList<Weapon> weaponArrayList,
    int height, int width,
                Ability ability){
        this.speed = speed;
        this.hp = hp;
        this.armor = armor;
        this.shipSprite = shipSprite;
        this.Sprite = Sprite;
        this.ability = ability;


/*
        for (int i = 0; i < carryWeapons; i++)
            this.weaponPositionX[i] = weaponPositionX[i];

        for (int i = 0; i < carryWeapons; i++)
            this.weaponPositionY[i] = weaponPositionY[i];
*/
        this.carryWeapons = carryWeapons;
        this.carryEquipment = carryEquipment;
/*
        for (int i = 0; i < carryWeapons; i++)
            this.weaponList[i] = weaponList[i];
*/

        this.height = height;
        this.width = width;
    }

    public void makeHit(float damage){
        float dmgAfterArmor = damage + this.armor;
        if(dmgAfterArmor > 0)
            setHp(getHp() - dmgAfterArmor);
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
        this.hp -= hp;
    }

    @Override
    public void increaseHp(float hp) {
        this.hp += hp;
    }

    @Override
    public float getSpeed(){
        return this.speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void decreaseSpeed(float speed) {
        this.speed -= speed;
    }

    @Override
    public void increaseSpeed(float speed) {
        this.speed += speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getShipSprite() {
        return shipSprite;
    }

    public void setShipSprite(String shipSprite) {
        this.shipSprite = shipSprite;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


}
