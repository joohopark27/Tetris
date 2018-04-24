package org.joohopark;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Screen extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Canvas canvas;
	private BufferedImage image;
	
	private int[] pixels;

	public static final int SCALE = 8 * 3;
	public static final int WIDTH = 10 * SCALE;
	public static final int HEIGHT = 24 * SCALE;
	public static final String GAMENAME = "Tetris";
	
	public Screen(){
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		frame = new JFrame(GAMENAME);
		this.frame = new JFrame(GAMENAME);
		this.frame.setSize(WIDTH, HEIGHT );
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	
	}
	
	public void updateScreen(){
//		BufferStrategy bs = getBufferStrategy();
//		if(bs == null){
//			createBufferStrategy(3);
//			return;
//		}
//		
//		Graphics g = bs.getDrawGraphics();
//		
//		g.setColor(Color.BLACK);
//		
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
