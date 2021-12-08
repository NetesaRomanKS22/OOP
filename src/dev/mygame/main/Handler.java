package dev.mygame.main;

import dev.mygame.main.gfx.GameCamera;
import dev.mygame.main.input.KeyManager;
import dev.mygame.main.input.MouseManager;
import dev.mygame.main.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) 
	{
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setState() {
		
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
