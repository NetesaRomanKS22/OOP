package dev.mygame.main.enteties.statics;

import java.awt.*;

import dev.mygame.main.Handler;
import dev.mygame.main.gfx.Assets;
import dev.mygame.main.tiles.Tile;

public class Coin extends StaticEntity{

	public Coin(Handler handler, float x, float y) {
		super(handler, x, y, 48, 48);
		
		bounds.x =  3;
		bounds.y =  3;
		bounds.width = width;
		bounds.height = height;
	}
	
	@Override
	public void tick() {
		
		
	}
	
	@Override
	public void die() {
		
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.tileEnabled,(int)(x-handler.getGameCamera().getXoffset()),(int) (y-handler.getGameCamera().getYoffset()), width, height, null);
		
	}
}
