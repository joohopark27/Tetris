package org.joohopark;

public class Piece {
	
	private int[][] block;
	
	public int xPos, yPos;
	public int width, height;
	
	private JPTetris tetris;
	private GameBoard board;
	
	public boolean isFalling;
	
	public Piece(JPTetris tetris,GameBoard board, int type){
		
		this.tetris = tetris;
		this.board = board;
		
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
				this.block = new int[][] {{1,1}, {1,1}};
				this.xPos = 4;
				break;
			case 2:			//T
				this.block = new int[][] {{0,0,0}, {0,1,0}, {1,1,1}};
				this.xPos = 3;
				break;
			case 3:			//S
				this.block = new int[][] {{0,0,0}, {0,1,1}, {1,1,0}};
				this.xPos = 3;
				break;
			case 4:			//Z
				this.block = new int[][] {{0,0,0}, {1,1,0}, {0,1,1}};
				this.xPos = 3;
				break;	
			case 5:			//J
				this.block = new int[][] {{0,0,1}, {0,0,1}, {0,1,1}};
				this.xPos = 4;
				break;
			case 6:			//L
				this.block = new int[][] {{1,0,0}, {1,0,0}, {1,1,0}};
				this.xPos = 4;
				break;
		}
		this.height = block.length;
		this.width = block[height -1].length;
		this.yPos = 4 - this.height;
	}

	//checks if there is space on the bottom
	public boolean checkDown(){
		
		if(yPos == 24 - height){
			isFalling = false;
			return false;
		}
		
		for(int x = 0; x < width; x++){
			int y = 0;
			
			/*for(int y = 1; y <= height && block[height - y][x] == 0; y++){
				System.out.println(block[height - y][x] != 0);
				System.out.println(board.isFilled(yPos + 2 - y, xPos + x));
				if(block[height - y][x] != 0 && board.isFilled(yPos + 2 - y, xPos + x)){
					isFalling = false;
					return false;
				}
			}*/
		}
		return true;
	}
	
	//checks if there is space on the left
	public boolean checkLeft(){
		
		if(xPos == 0){
			return false;
		}
		
		for(int i = 0; i < height ; i++){
			for(int j = 0; block[i][j] == 0 && j < width; j++){
				if(!(block[i][j] != 0 && board.isFilled(i, xPos + j - 1))){
					return false;
				}
			}
		}
		return true;
	}
	
	//checks if there is space on the right
	public boolean checkRight(){
		
		if(xPos == 10 - width){
			return false;
		}
		
		for(int i = 0; i < height ; i++){
			for(int j = width - 1; block[i][j] == 0 && j >= 0; j++){
				if(!(block[i][j] != 0 && board.isFilled(i, xPos + j + 1))){
					return false;
				}
			}
		}
		return true;
	}

	//public boolean checkRotate(){}
	
	public int getPart(int x, int y){
		return block[y][x];
	}
	
}
