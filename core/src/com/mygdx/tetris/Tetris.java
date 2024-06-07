package com.mygdx.tetris;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.tetris.threads.FieldUpdateThread;
import com.mygdx.tetris.threads.FigureGenThread;

import java.util.Arrays;

public class Tetris extends ApplicationAdapter {
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int FRAME_WIDTH = 688;
	public static final int FRAME_HEIGHT = HEIGHT;

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private ScreenViewport viewport;
	private Sound sound;
	private Texture[][] textureField;
	private Texture[][] figureToChange;
	private Texture backGround;
	private Texture pauseButton;

	private boolean[][] map;
	private int height;
	private int width;
	private boolean gamePaused;
	private boolean gameEnded;
	private boolean gameLost;
	private boolean rightKeyPressed;
	private boolean leftKeyPressed;
	private boolean upKeyPressed;
	private boolean downKeyPressed;
	private boolean spaceKeyPressed;
	private long gamePauseTime;
	private long gameEndedTime;
	private long soundId;
	private int score;
	private Field field;
	private Figure figure;
	private FigureGenThread figureThread;
	private FieldUpdateThread fieldThread;

	@Override
	public void create () {
		height = 22;
		width = 14;
		map = new boolean[height][width];
		gamePaused = false;
		gameEnded = false;
		gameLost = false;
		rightKeyPressed = false;
		leftKeyPressed = false;
		upKeyPressed = false;
		downKeyPressed = false;
		spaceKeyPressed = false;
		gamePauseTime = 0;
		gameEndedTime = 0;
		score = 0;
		field = new Field();
		textureField = field.getField();
		figure = new Figure();
		figureThread = new FigureGenThread(figure);
		figureThread.start();
		fieldThread = new FieldUpdateThread(field, figure);
		fieldThread.start();

		sound = Gdx.audio.newSound(Gdx.files.internal("data/megalovania.wav"));
		soundId = sound.play();
		sound.setLooping(soundId, true);
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
					System.out.println(Arrays.deepToString(figure.getShape()));
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

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				// Convert screen coordinates to world coordinates
				Vector3 worldCoordinates = viewport.unproject(new Vector3(screenX, screenY, 0));
				float worldX = worldCoordinates.x;
				float worldY = worldCoordinates.y;

				// Button coordinates and dimensions
				float buttonX = 1500f;
				float buttonY = 270f;
				float buttonWidth = 200f;
				float buttonHeight = 200f;

				// Check if the click is within the button bounds
				if (
					worldX > buttonX &&
					worldX < buttonX + buttonWidth &&
					worldY > buttonY &&
					worldY < buttonY + buttonHeight
				) {
					System.out.println("Pause button pressed"); // Debug message
					gamePaused = true;
					gamePauseTime = TimeUtils.millis();
					return true; // Indicate the event was handled
				}
				return false;
			}
		});

		backGround = new Texture("data/background.png");
		pauseButton = new Texture("data/pause-play.png");
		field = new Field();
		viewport = new ScreenViewport(camera);
	}

	@Override
	public void render () {
//		System.out.println("Rendered");// may be removed
		if (!gameEnded) {
			drawMainScreen();
			if (gameLost) {
				gameEnded = true;
				gameEndedTime = TimeUtils.millis();
			}
		} else if (gamePaused) {
			drawPauseScreen();
			gamePauseTime = TimeUtils.millis();
		} else {
			drawEndScreen();
			if (TimeUtils.timeSinceMillis(gameEndedTime) > 2000) {
				create();
			}
		}
	}

	@Override
	public void dispose () {
		System.out.println("Disposed");// may be removed
		sound.dispose();
		font.dispose();
		batch.dispose();
		shapeRenderer.dispose();
		backGround.dispose();
		pauseButton.dispose();
		field.dispose();
//		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Resized");// may be removed
		viewport.update(width, height);
	}

	@Override
	public void pause() {
		System.out.println("Paused");// may be removed
		gamePaused = true;
	}

	@Override
	public void resume() {
		System.out.println("Resumed");// may be removed
		gamePaused = false;
	}

	private void drawMainScreen() {
		//TODO: Implement drawMainScreen logic

		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		batch.draw(
				backGround,0,30,
				viewport.getWorldWidth(),
				viewport.getWorldHeight()
		);
		batch.draw(
				pauseButton,
				(float) 1500,
				(float) 270,
				200,
				200
		);

		figureToChange = figure.getShape();
		field.draw(batch, textureField);
		batch.end();
	}

	private void drawPauseScreen() {
		//TODO: Implement drawPauseScreen logic
	}

	private void drawEndScreen() {
		//TODO: Implement drawEndScreen logic
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