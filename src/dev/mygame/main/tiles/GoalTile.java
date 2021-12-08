package dev.mygame.main.tiles;

import java.awt.image.BufferedImage;

import dev.mygame.main.gfx.Assets;

import java.awt.Graphics; 

public class GoalTile extends Tile{
	public GoalTile(int id) {
		super(Assets.tileEnabled, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
