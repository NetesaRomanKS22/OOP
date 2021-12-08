package dev.mygame.main.gfx;

import dev.mygame.main.Handler;
import dev.mygame.main.enteties.Entity;
import dev.mygame.main.enteties.creatures.Player;

public class GameCamera {
	
	private float xoffset, yoffset;
	private Handler handler;
	
	public GameCamera(Handler handler,float xoffset, float yoffset) {
		this.xoffset = xoffset;
		this.yoffset = yoffset;
		this.handler = handler;
	}
	
	public void move(float xAmt, float yAmt) {
		xoffset += xAmt;
		yoffset += yAmt; 
	}
	
	public void centerOnEntity(Player e) {
		xoffset = (float)(e.getX())- handler.getWidth() / 2 + e.getWidth() / 2;
		yoffset = (float)(e.getY()) - handler.getHeight() / 2 + e.getHeight() / 2;
	}
	
	public float getXoffset() {
		return xoffset;
	}

	public void setXoffset(float xoffset) {
		this.xoffset = xoffset;
	}

	public float getYoffset() {
		return yoffset;
	}

	public void setYoffset(float yoffset) {
		this.yoffset = yoffset;
	}
}
