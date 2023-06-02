package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import dk.sdu.mmmi.cbse.managers.GameInputProcessor;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

public class Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera cam;
	
	private GameStateManager gsm;

	//called once when the game starts up
        @Override
	public void create() {
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		// a new camera view
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		//recentres the camera view to show the whole game area.
		cam.translate(WIDTH / 2, HEIGHT / 2);
		cam.update();
		
		Gdx.input.setInputProcessor(
			new GameInputProcessor()
		);
		
		gsm = new GameStateManager();
		
	}
	// game loop method that gets called constantly
        @Override
	public void render() {
		
		// clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//getDeltaTime tells how long i has een since the last render() call
		// we do this, because we do not have control over the game loop, and we need to know how much to move the game forward.
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();

		// test game keys if (GameKeys.isPressed(GameKeys.SPACE)) {System.out.println("SPACE");}

		GameKeys.update();
		
	}
	//called whenever screen size is changed
        @Override
	public void resize(int width, int height) {}
	//pause and resume are mainly for Android versions of the game
        @Override
	public void pause() {}
        @Override
	public void resume() {}
	// one time method as well that is called when the game exits
        @Override
	public void dispose() {}
	
}
