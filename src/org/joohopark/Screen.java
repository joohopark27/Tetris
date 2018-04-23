package org.joohopark;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Screen extends Canvas{
	
	private JFrame frame;
	private Canvas canvas;
	private BufferedImage image;
	
	private int[] pixels;

	public static final int WIDTH = 320;
	public static final int HEIGHT = 180;
	public static final int SCALE = 3;
	public static final String GAMENAME = "Tetris";
	
	public Screen(){
		
		image = new BufferedImage(10 * 8 * SCALE, 20 * 8 * SCALE, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		frame = new JFrame(GAMENAME);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
	
	public void updateScreen(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		
	}
	
}
