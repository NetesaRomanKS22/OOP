package dev.mygame.main.gfx;

import java.awt.image.*;


public class Assets {//¬ этом классе будут содержатьс€ все ассеты
	
	private static final int width = 64, height = 64;
	
	public static BufferedImage player, toungeTip, toungeBase, block, tileEnabled, tileDisabled, bgTile;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_exit;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res\\sprites\\SpriteSheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		block = sheet.crop(width, 0, width, height);
		toungeTip = sheet.crop(width * 2, 0, width, height);
		toungeBase = sheet.crop(width * 3, 0, width, height);
		tileDisabled = sheet.crop(width * 4,0, width, height);
		tileEnabled = sheet.crop(width * 5, 0, width, height);
		bgTile = sheet.crop(width * 6, 0, width, height);
		
		
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(0,height,width*2,height);
		btn_start[1] = sheet.crop(width*2 ,height,width*2,height);
		
		btn_exit = new BufferedImage[2];
		btn_exit[0] = sheet.crop(0,height + 64,width*2,height);
		btn_exit[1] = sheet.crop(width*2,height+ 64 ,width*2,height );

		
	}
}
