package org.joohopark;

public class Piece {
	
	private int[][] block;
	
	public int xPos, yPos;
	public int width, height;
	
	private JPTetris tetris;
	private GameBoard board;
	
	private boolean isFalling;
	
	public Piece(JPTetris tetris,GameBoard board, int type){
		
		this.tetris = tetris;
		this.board = board;
		this.createPiece(type);
		
	}
	
	public void createPiece(int type){
		
		this.yPos = 3;
		this.isFalling = true;
		
		switch(type){
			case 0:			//I
				this.block = new int[][] {{1,1,1,1}};
				this.xPos = 3;
				break;
			case 1:			//O
				this.block = new int[][] {{1,1}, {1,1}};
				this.xPos = 4;
				break;
			case 2:			//T
				this.block = new int[][] {{0,1,0}, {1,1,1}};
				this.xPos = 3;
				break;
			case 3:			//S
				this.block = new int[][] {{0,1,1}, {1,1,0}};
				this.xPos = 3;
				break;
			case 4:			//Z
				this.block = new int[][] {{1,1,0}, {0,1,1}};
				this.xPos = 3;
				break;	
			case 5:			//J
				this.block = new int[][] {{0,1}, {0,1}, {1,1}};
				this.xPos = 4;
				break;
			case 6:			//L
				this.block = new int[][] {{1,0}, {1,0}, {1,1}};
				this.xPos = 4;
				break;
		}
		this.height = block.length;
		this.width = block[height -1].length;
	}
	
	public boolean checkDown(){
			for(int i =0; i < block[width].length; i++){
				for(int j = 0; block[height -j][i] == 0; j++){
					if(!(block[height - j][i] != 0 && board.isFilled(yPos - j, xPos + i))){
						return false;
					}
				}
			}
		return true;
	}
	
	public int getPart(int x, int y){
			return block[height - 1 - y][x];
	}
	
	//public boolean checkRotate(){}
	
}
