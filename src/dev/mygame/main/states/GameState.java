package dev.mygame.main.states;
import dev.mygame.main.Game;
import dev.mygame.main.Handler;

import java.awt.Graphics;

import dev.mygame.main.enteties.creatures.Player;
import dev.mygame.main.worlds.*;
public class GameState extends State {
	

	private World world;

	
	public GameState(Handler handler) {
		
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	
		
		handler.getGameCamera().move(0, 0);
	}
	
	
	@Override
	public void tick() {
		world.tick();

		

	}

	@Override
	public void render(Graphics g) {
		world.render(g);


	}


}
