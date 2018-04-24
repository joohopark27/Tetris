package org.joohopark;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage image;
	
	public SpriteSheet() throws IOException{
		image = ImageIO.read(SpriteSheet.class.getResource("/block.png"));
	}
	
	public BufferedImage getBlock(int tileType){
		int width = 8,
			height = 8;
		int x = 0, 
			y = 0;
		switch(tileType){
		case 7:
			x += 8;
		case 6:
			x += 8;
		case 5:
			x += 8;
		case 4:
			y += 8;
			break;
		case 3:
			x += 8;
		case 2:
			x += 8;
		case 1:
			x += 8;
			break;
		default:
		}
		return image.getSubimage(x, y, width, height);
	}
	
}
