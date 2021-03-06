package org.joohopark;

public class Piece {
	
	private int[][] block;
	
	public int xPos, yPos;
	public int width, height;
	
	private JPTetris tetris;
	
	public boolean isFalling;
	
	public Piece(JPTetris tetris, int type){
		
		this.tetris = tetris;
		
		this.isFalling = true;
		
		this.createPiece(type);
	}
	
	public void createPiece(int type){

		switch(type){
		case 0:			//I
			this.block = new int[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {1,1,1,1}};
			this.xPos = 3;
			break;
		case 1:			//O
			this.block = new int[][] {{2,2}, {2,2}};
			this.xPos = 4;
			break;
		case 2:			//T
			this.block = new int[][] {{0,0,0}, {0,3,0}, {3,3,3}};
			this.xPos = 3;
			break;
		case 3:			//S
			this.block = new int[][] {{0,0,0}, {0,4,4}, {4,4,0}};
			this.xPos = 3;
			break;
		case 4:			//Z
			this.block = new int[][] {{0,0,0}, {5,5,0}, {0,5,5}};
			this.xPos = 3;
			break;	
		case 5:			//J
			this.block = new int[][] {{0,6}, {0,6}, {6,6}};
			this.xPos = 4;
			break;
		case 6:			//L
			this.block = new int[][] {{7,0}, {7,0}, {7,7}};
			this.xPos = 4;
			break;
		}
		this.height = block.length;
		this.width = block[height -1].length;
		this.yPos = 4 - this.height;
	}

	//checks if there is space on the bottom
	public boolean checkDown(GameBoard board, int yPos){
		
		if(yPos + height >= 24){
			return false;
		}
		
		for(int x = 0; x < width; x++){ //checks for each colum
			int y = height - 1;
			
			while(block[y][x] == 0 && y > 0){ // runs until space is ocupide
				y--;
			}
			
			if(block[y][x] != 0 && board.isFilled(yPos + y + 1, xPos + x)){
				return false;
			}
		}
		return true;
	}
	
	//checks if there is space on the left
	public boolean checkLeft(GameBoard board){
		
		if(xPos <= 0){
			return false;
		}
		
		for(int y = 0; y < height; y++){ //checks for each colum
			int x = 0;
			
			while(block[y][x] == 0 && x < width - 1){ // runs until space is ocupide
				System.out.println(x);
				x++;
			}
			
			if(block[y][x] != 0 && board.isFilled(yPos, xPos + x - 1)){
				return false;
			}
		}
		return true;
	}
	
	//checks if there is space on the right
	public boolean checkRight(GameBoard board){
		
		if(xPos >= 10 - width){
			return false;
		}
		
		for(int y = 0; y < height; y++){ //checks for each row
			int x = width - 1;
			
			while(block[y][x] == 0 && x > 0){ // runs until space is ocupide
				x--;
			}
			
			if(block[y][x] != 0 && board.isFilled(yPos, xPos + x + 1)){
				return false;
			}
		}
		
		return true;
	}

	public int getPart(int x, int y){
		return block[y][x];
	}
	
}
