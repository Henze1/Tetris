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
	private boolean upKeyPressed;
	private boolean downKeyPressed;
	private boolean spaceKeyPressed;
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
		upKeyPressed = false;
		downKeyPressed = false;
		spaceKeyPressed = false;
		startTime = 0;
		pauseTime = 0;
		score = 0;
		textureField = field.getField();

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
				if (
					keycode == Input.Keys.RIGHT ||
					keycode == Input.Keys.D
				) {
					handleRightClick();
				} else if (
					keycode == Input.Keys.LEFT ||
					keycode == Input.Keys.A
				) {
					handleLeftClick();
				} else if (
					keycode == Input.Keys.UP ||
					keycode == Input.Keys.W
				) {
					handleUpClick();
				} else if (
					keycode == Input.Keys.DOWN ||
					keycode == Input.Keys.S
				) {
					handleDownClick();
				} else if (
					keycode == Input.Keys.SPACE ||
					keycode == Input.Keys.ESCAPE
				) {
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
//		System.out.println("Rendered");// may be removed
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
		System.out.println("Disposed");// may be removed
		sound.dispose();
		font.dispose();
		batch.dispose();
		shapeRenderer.dispose();
		batch.dispose();
		backGround.dispose();
		field.dispose();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Resized");// may be removed
		viewport.update(width, height);
	}

	@Override
	public void pause() {
		System.out.println("Paused");// may be removed
	}

	@Override
	public void resume() {
		System.out.println("Resumed");// may be removed
	}

	private void draw() {
		//TODO: Implement draw logic

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
		System.out.println("Right or D Clicked");
	}

	private void handleLeftClick() {
		//TODO: Implement handleLeftClick logic
		System.out.println("Left or A Clicked");
	}

	private void handleDownClick() {
		//TODO: Implement handleDownClick logic
		System.out.println("Down or S Clicked");
	}

	private void handleUpClick() {
		//TODO: Implement handleUpClick logic
		System.out.println("Up or W Clicked");
	}

	private void handleSpaceClick() {
		//TODO: Implement handleSpaceClick logic
		System.out.println("Space or ESCAPE Clicked");
	}


	public Tetris() {
		super();
	}
}