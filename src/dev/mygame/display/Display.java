package dev.mygame.display;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {//Класс который создает окно нашей игры, и полотно для работы с графикой
	private Canvas canvas;
	private JFrame frame;
	
	private String title;
	private int height, width;
	
	public Display(String title, int height, int width) {
		this.title = title;
		this.height = height;
		this.width = width;
		
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		
		frame.add(canvas);
		frame.pack();
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
