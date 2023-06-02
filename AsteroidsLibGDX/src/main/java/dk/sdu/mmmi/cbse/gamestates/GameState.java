package dk.sdu.mmmi.cbse.gamestates;

import dk.sdu.mmmi.cbse.managers.GameStateManager;

public abstract class GameState {
	//to change from GameState to another, we use the Manager class.
	protected GameStateManager gsm;
	
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		//manages the start of the game, and now we do not need to do it separately for each different gamestate
		init();
	}
	// every gamestate is going to need the below methods
	public abstract void init();
	public abstract void update(float dt);
	public abstract void draw();
	//doing stuff with the game keys
	public abstract void handleInput();
	public abstract void dispose();
	
}
