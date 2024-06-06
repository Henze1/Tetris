package com.mygdx.tetris;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Tetris extends ApplicationAdapter {
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int FAME_WIDTH = 688;
	public static final int FRAME_HEIGHT = HEIGHT;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private ScreenViewport viewport;
	private Sound sound;
	private Texture[][] textureField;
	private Texture[][] Figure;
	private Texture backGround;

	private boolean[][] map;
	private int height;
	private int width;
	private boolean gameStarted;
	private boolean gamePaused;
	private boolean gameEnded;
	private boolean rightKeyPressed;
	private boolean leftKeyPressed;
	private long startTime;
	private long pauseTime;
	private int score;
	private Field field;
	private Figure figure;

	@Override
	public void create () {
		height = 22;
		width = 14;
		map = new boolean[height][width];
		gameStarted = false;
		gamePaused = false;
		gameEnded = false;
		rightKeyPressed = false;
		leftKeyPressed = false;
		startTime = 0;
		pauseTime = 0;
		score = 0;

		sound = Gdx.audio.newSound(Gdx.files.internal("data/bad_piggies_theme.wav"));
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		font.setColor(Color.WHITE);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		camera.update();

		newMap();

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keycode) {
				if (keycode == Input.Keys.RIGHT) {
					handleRightClick();
				} else if (keycode == Input.Keys.LEFT) {
					handleLeftClick();
				} else if (keycode == Input.Keys.SPACE) {
					handleSpaceClick();
				}

				return true;
			};
		});

		backGround = new Texture("data/background.png");
		field = new Field();
		viewport = new ScreenViewport();
	}

	@Override
	public void render () {
//		System.out.println("Rendered");
		if (!gameEnded) {
			batch.setProjectionMatrix(viewport.getCamera().combined);
			batch.begin();
			batch.draw(
					backGround,
					(float) - Gdx.graphics.getWidth() / 2,
					(float) - Gdx.graphics.getHeight() / 2,
					viewport.getWorldWidth(),
					viewport.getWorldHeight()
			);
			field.draw(batch);
			batch.end();
		}
	}

	@Override
	public void dispose () {
//		System.out.println("Disposed");
		batch.dispose();
		backGround.dispose();
		field.dispose();
	}

	@Override
	public void resize(int width, int height) {
//		System.out.println("Resized");
		viewport.update(width, height);
	}

	@Override
	public void pause() {
//		System.out.println("Paused");
	}

	@Override
	public void resume() {
//		System.out.println("Resumed");
	}

	private void newMap() {
		gameEnded = false;

		//TODO: Implement newMap logic
		for(int x = 0; x < height; x++) {
			for(int y = 0; y < width; y++) {
				map[x][y] = false;
			}
		}
	}

	private void handleRightClick() {
		//TODO: Implement handleRightClick logic
		System.out.println("Right Clicked");
	}

	private void handleLeftClick() {
		//TODO: Implement handleLeftClick logic
		System.out.println("Left Clicked");
	}

	private void handleSpaceClick() {
		//TODO: Implement handleSpaceClick logic
		System.out.println("Space Clicked");
	}


	public Tetris() {
		super();
	}
}