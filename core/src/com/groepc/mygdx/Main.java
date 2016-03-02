package com.groepc.mygdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
        Sprite sprite;
        
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
                sprite = new Sprite(img);
	}
        
        float playerSpeed = 100.0f; 
        float playerX;
        float playerY;
        
	@Override
	public void render () {
            if(Gdx.input.isKeyPressed(Keys.A)) 
                playerX -= Gdx.graphics.getDeltaTime() * playerSpeed;
            if(Gdx.input.isKeyPressed(Keys.D)) 
                playerX += Gdx.graphics.getDeltaTime() * playerSpeed;
            if(Gdx.input.isKeyPressed(Keys.W)) 
                playerY += Gdx.graphics.getDeltaTime() * playerSpeed;
            if(Gdx.input.isKeyPressed(Keys.S)) 
                playerY -= Gdx.graphics.getDeltaTime() * playerSpeed;

             
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();

            float angle = (float) Math.atan2(562 - Gdx.input.getY() - sprite.getY(), Gdx.input.getX() - sprite.getX());

            angle = (float) Math.toDegrees(angle);

            sprite.setRotation(angle);

            //batch.draw(sprite, (int)playerX, (int)playerY);
            sprite.setPosition(playerX, playerY);
            sprite.draw(batch);
            batch.end();
	}
        
        private void mouseMoved(int screenX, int screenY) {
            float angle = (float) Math.atan2(562 - Gdx.input.getY() - sprite.getY(), Gdx.input.getX() - sprite.getX());

             angle = (float) Math.toDegrees(angle);

             sprite.setRotation(angle);
        }
        
}
