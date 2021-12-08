package dev.mygame.main.tiles;

import java.awt.image.BufferedImage;

import dev.mygame.main.gfx.Assets;

import java.awt.Graphics; 

public class BlockTile extends Tile{

	
	public BlockTile(int id) {
		super(Assets.block, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
