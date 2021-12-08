package dev.mygame.main.enteties.creatures;

import dev.mygame.main.*;
import dev.mygame.main.enteties.Entity;

import java.awt.*;
import java.awt.Color;
import dev.mygame.main.gfx.Assets;
import dev.mygame.main.states.MenuState;
import dev.mygame.main.states.State;

public class Player extends Creature{

	
	public Player(Handler handler,float x, float y) {
		 
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 3;
		bounds.y = 3;
		bounds.width = this.width - 12;
		bounds.height = this.height - 12;
		
	}

	@Override
	public void tick() {
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		checkAttacks();
	}
	
	private void checkAttacks(){

		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
	
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt();
				return;
			}
		}
		
	}
	
	@Override
	public void die() {
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().escape) 
			State.setState(new MenuState(handler));
		if(handler.getKeyManager().up) 
			yMove = -speed;
		if(handler.getKeyManager().down) 
			yMove = speed;
		if(handler.getKeyManager().left) 
			xMove = -speed;
		if(handler.getKeyManager().right) 
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getXoffset()), (int) (y- handler.getGameCamera().getYoffset()), width, height, null);
		
		
		
	}

}
