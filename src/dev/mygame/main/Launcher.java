package dev.mygame.main;

import dev.mygame.display.*;

public class Launcher {//����� ������� ��������� ����
	
	public static void main(String[] args) {
		Game myGame = new Game("MyGame", 1000, 1500);
		myGame.start();
	}
}
