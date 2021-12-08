package dev.mygame.main;
import dev.mygame.display.*;
import dev.mygame.main.input.*;

import dev.mygame.main.gfx.Assets;
import dev.mygame.main.gfx.GameCamera;

import dev.mygame.main.states.*;

import java.awt.image.*;
import java.awt.Graphics;
import java.awt.*;
public class Game implements Runnable{ // ласс самой игры, тут будет главный поток
	
	private Color bgColor = new Color(254, 199, 89);
	private Display display;
	private int height, width;
	public String title;
	
	private KeyManager km;
	private MouseManager ms; 
	
	private Handler handler;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public  State gameState;
	public  State menuState;
	public  State settingsState;
	
	private GameCamera gameCamera;
	
	public Game(String title, int height, int width) {
		this.width = width;
		this.height = height;
		this.title = title;
		km  = new KeyManager();
		ms = new MouseManager();
		
	
		
	}
	
	private void init() {// метод который происходит один раз при запуске игры
		display = new Display(title, height, width);
		display.getFrame().addKeyListener(km);
		display.getFrame().addMouseListener(ms);
		display.getFrame().addMouseMotionListener(ms);
		display.getCanvas().addMouseListener(ms);
		display.getCanvas().addMouseMotionListener(ms);
		Assets.init();
		
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		
		State.setState(menuState);
	}
	

	
	private void tick() {//действие раз в тик, на юнити это метот апдейт
		km.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {// тоже самое что и тик, только тут все дл€ графики
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//Draw here
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		 
		//End drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {//метод самой игры, цикл бесконечный, пока извне не останов€т его
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
			tick();
			render();
			ticks++;
			delta --;
			}
			
			if(timer >= 1000000000) {
				
				ticks = 0;
				timer = 0;
			}
			
			if(running == false) break;
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return km;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Display getDisplay() {
		return display;
	} 
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public void setRunning() {
		running = false;
	}
	
	public MouseManager getMouseManager() {
		return ms;
	}
	public synchronized void start() {//«апуск игры
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {//¬ыход
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
