package org.joohopark;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Screen extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Canvas canvas;
	
	private SpriteSheet tile;
	
	private BufferStrategy bs;
	private Graphics g;

	public static final int SCALE = 8 * 3;
	public static final int WIDTH = 10 * SCALE;
	public static final int HEIGHT = 24 * SCALE;
	public static final String GAMENAME = "Tetris";
	
	public Screen(SpriteSheet tile){
		
		this.tile = tile;
		
		frame = new JFrame(GAMENAME);
		this.frame = new JFrame(GAMENAME);
		this.frame.setSize(WIDTH, HEIGHT );
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));

		frame.add(canvas);
		frame.pack();
		
	}
	
	public void updateScreen(int[][] board){
		
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		for(int y = 4; y < 24; y++){
			for(int x = 0; x < 10; x++){
				g.drawImage(tile.getBlock(board[y][x]), x * SCALE, (y - 4) * SCALE, SCALE * 8, SCALE * 8, null);
			}
		}

		bs.show();
		g.dispose();
		
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
