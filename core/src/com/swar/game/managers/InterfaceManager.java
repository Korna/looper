package com.swar.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Koma on 01.10.2017.
 */
public class InterfaceManager {


    boolean available;
    float playerHandle = 4.5f;
    float playerZone = 0.3f;
    float playerNear = 0.25f;


    //bundle
    public float horizontalForce = 0;
    public float verticalForce = 0;
    public boolean shot = false;

    public InterfaceManager(boolean available, float playerZone, float playerHandle) {

        this.playerHandle = playerHandle;
        this.playerZone = playerZone;

        this.available = available;
    }

    public void inputUpdate(){
        horizontalForce = 0;
        verticalForce = 0;
        shot = false;





        if(available){
            float accelX = Gdx.input.getAccelerometerX();
            float accelY = Gdx.input.getAccelerometerY();

            if(accelX > playerNear){
                horizontalForce = -0.25f;
                if(accelX > playerZone + playerNear)
                    horizontalForce -= 0.8f;
            }
            else
            if(accelX < -playerNear){
                horizontalForce = 0.25f;
                if(accelX < -(playerZone + playerNear))
                    horizontalForce += 0.8f;

            }

            if(accelY > (playerZone + playerHandle)){
                --verticalForce;
            }
            else
            if(accelY < (-playerZone + playerHandle)){
                ++verticalForce;
            }

            if(Gdx.input.justTouched()){
               shot = true;
            }
            if(Gdx.input.isTouched())
                shot = true;

        }else{


            if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
                --horizontalForce;

            }
            else
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
                ++horizontalForce;

            }

            if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
                ++verticalForce;
            }
            else
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
                --verticalForce;
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                shot = true;
            }

        }



    }



}
