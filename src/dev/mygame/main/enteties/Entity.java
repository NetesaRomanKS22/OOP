package dev.mygame.main.enteties;
import dev.mygame.main.*;


import java.awt.Graphics; 
import java.awt.Rectangle; 

public abstract class Entity {
	
	
	protected int health;
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	protected boolean active = true;
	
	
	public Entity(Handler handler,float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		
		this.health = 1;
		this.handler = handler;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y=y;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void die();
	
	public int getHealth() {
		return health;
	}
	
	public void hurt () {

			active = false;
			die();
		
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}



	

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean checkCollision(float xoffset, float yoffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) continue;
			
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))) return true;
			
		}
		
		return false;
	}
	
	public Rectangle getCollisionBounds(float xoffset, float yoffset) {//Хитбокс для монеток и тд
		return new Rectangle((int) (x + bounds.x + xoffset), (int)(y+ bounds.y + yoffset), bounds.width, bounds.height);
	}
	
	
	//Getters Setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
