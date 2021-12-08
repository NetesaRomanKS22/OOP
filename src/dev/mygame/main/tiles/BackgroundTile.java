package dev.mygame.main.tiles;

import java.awt.image.BufferedImage;

import dev.mygame.main.gfx.Assets;

import java.awt.Graphics; 

public class BackgroundTile extends Tile{
	public BackgroundTile(int id) {
		super(Assets.bgTile, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
}
