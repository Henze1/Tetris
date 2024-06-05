package com.mygdx.tetris;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tetris extends InputAdapter implements ApplicationListener {
	OrthographicCamera camera;
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	
	@Override
	public void create () {
//		System.out.println("Created");

	 	Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
//		System.out.println("Rendered");
	}
	
	@Override
	public void dispose () {
//		System.out.println("Disposed");
	}

	@Override
	public void resize(int width, int height) {
//		System.out.println("Resized");
	}

	@Override
	public void pause() {
//		System.out.println("Paused");
	}

	@Override
	public void resume() {
//		System.out.println("Resumed");
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.DOWN) {
			//TODO: Key Down logic
			System.out.println("Key Down: " + keycode);
		}

		return super.keyDown(keycode);
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.UP) {
			//TODO: Key Up logic
			System.out.println("Key Up: " + keycode);
		}

		return super.keyUp(keycode);
	}

	@Override
	public boolean keyTyped(char character) {
		System.out.println("Key Typed: " + character);
		return true;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		System.out.println("Scrolled| X: " + amountX + "| Y: " + amountY);

		return true;
	}

	public Tetris() {
		super();
	}
}
