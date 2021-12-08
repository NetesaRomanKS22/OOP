package dev.mygame.main.enteties.creatures;

import dev.mygame.main.enteties.Entity;
import dev.mygame.main.tiles.Tile;

import dev.mygame.main.*;
public abstract class Creature extends Entity{
	

	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	protected long last_time = System.nanoTime();



	
	
	protected float speed = 5.0f;
	protected float xMove = 0, yMove = 0;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}
	
	
	public void move() {
		if(!checkCollision(xMove, 0))moveX();
		if(!checkCollision(0, yMove))moveY();
		
		
		
		
		
	}
	
	public void moveTo(int targetX, int targetY) {
		long time = System.nanoTime();
	    int delta_time = (int) ((time - last_time) / 1000000);
	    last_time = time;
	    
	    float step = speed *delta_time;
	    
	    
		
	}
	



	public void moveX() {
		if(xMove > 0) {//Идем направо
			
			int tx = (int)(x + xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;//Перевод в координаты плиточек
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0) {//Идем налево
			int tx = (int)(x + xMove + bounds.x)/Tile.TILEWIDTH;//Перевод в координаты плиточек
			if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH +Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove  < 0) {//Вверх
			int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH,ty) && !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH,ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}else if(yMove > 0) {//Вниз
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH,ty) && !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH,ty)) {
				y += yMove;
			}else {
				y = ty  * Tile.TILEHEIGHT - bounds.y - bounds.height - 1; 
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid(); 
	}
	//getters setters
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}


	
	
	

}
