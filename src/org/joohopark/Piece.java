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
		
		this.yPos = 3;
		
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
	}

	//checks if there is space on the bottom
	public boolean checkDown(int x){
		
		if(yPos == 23){
			isFalling = false;
			return false;
		}
		
		for(int i =0; i < width; i++){
			for(int j = 1; j <= height && block[height - j][i] == 0; j++){
				System.out.println(block[height - j][i] != 0 );
				System.out.println(board.isFilled(yPos + 2 - j, x + i));
				if(block[height - j][i] != 0 && board.isFilled(yPos + 2 - j, x + i)){
					isFalling = false;
					return false;
				}
			}
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
				if(!(block[i][j] != 0 && board.isFilled(yPos - height + 1 - i, xPos + j - 1))){
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
				if(!(block[i][j] != 0 && board.isFilled(yPos - height + 1 - i, xPos + j + 1))){
					return false;
				}
			}
		}
		return true;
	}

	//public boolean checkRotate(){}
	
	public int getPart(int x, int y){
		return block[height - 1 - y][x];
	}
	
}
