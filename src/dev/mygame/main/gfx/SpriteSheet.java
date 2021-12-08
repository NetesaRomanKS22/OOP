package dev.mygame.main.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet { //Класс который разделяет тайлмапы
	
	private BufferedImage sheet; //тайлмап
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) { //разделяем тайл мап на отдельные картинки
		return sheet.getSubimage(x,y,width,height);
		
	}
}
