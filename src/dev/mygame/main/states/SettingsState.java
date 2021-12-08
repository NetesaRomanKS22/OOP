package dev.mygame.main.states;
import dev.mygame.main.Game;
import dev.mygame.main.Handler;

import java.awt.Graphics;

import dev.mygame.main.gfx.Assets;

public class SettingsState extends State {

	public SettingsState(Handler handler) {
		super(handler);
	}
	
	
	@Override
	public void tick() {
	
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.block, 200, 200, null);
	}


}