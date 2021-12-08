package dev.mygame.main.states;
import dev.mygame.main.Game;
import dev.mygame.main.Handler;

import java.awt.Graphics;

import dev.mygame.main.gfx.Assets;
import dev.mygame.main.tiles.Tile;
import dev.mygame.main.ui.ClickListener;
import dev.mygame.main.ui.UIImageButton;
import dev.mygame.main.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		
		Assets.init();
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(650, 400, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				
				State.setState(handler.getGame().gameState);
			}}));
		
		
		uiManager.addObject(new UIImageButton(650, 600, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT , Assets.btn_exit, new ClickListener() {

			@Override
			public void onClick() {
				
				handler.getGame().getDisplay().getFrame().dispose();
				handler.getGame().stop();
			}}));
	}
	
	
	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}


}