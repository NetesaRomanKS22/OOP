 	package dev.mygame.main.worlds;
import dev.mygame.main.tiles.*;
import dev.mygame.main.utils.Util;
import dev.mygame.main.*;
import dev.mygame.main.enteties.EntityManager;
import dev.mygame.main.enteties.creatures.Player;
import dev.mygame.main.enteties.statics.Coin;

import java.awt.Graphics; 

public class World {
	private Handler handler;
	private int width, height;
	private int spawnx, spawny;
	private int[][] tiles;
	
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		

		loadWorld(path);
		
		entityManager.addEntity(new Coin(handler,200,100));
		entityManager.addEntity(new Coin(handler,1000,200));
		entityManager.getPlayer().setX(spawnx);
		entityManager.getPlayer().setY(spawny);
		
	
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void tick() {
		entityManager.tick();
		
	}
	
	public void render(Graphics g) {
		
		for(int y = 0;y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x,y).render(g,(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getXoffset()),(int)(y * Tile.TILEHEIGHT- handler.getGameCamera().getYoffset()));
			}
		}
		
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x>= width || y >= height) {
			return Tile.bgTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.bgTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnx = Util.parseInt(tokens[2]);
		spawny = Util.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
}
