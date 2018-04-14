package org.joohopark;

public class Piece {
	
	private int[][] piece;
	private int xPos, yPos;
	
	private JPTetris tetris;
	
	public Piece(JPTetris tetris, int type){
		
		this.tetris = tetris;
		this.pieceType(type);
		
	}
	
	public void pieceType(int type){
		this.yPos = 3;
		switch(type){
			case 0:			//I
				this.piece = new int[][] {{1,1,1,1}};
				this.xPos = 3;
				return;
			case 1:			//O
				this.piece = new int[][] {{1,1}, {1,1}};
				this.xPos = 4;
				return;
			case 2:			//T
				this.piece = new int[][] {{0,1,0}, {1,1,1}};
				this.xPos = 3;
				return;
			case 3:			//S
				this.piece = new int[][] {{0,1,1}, {1,1,0}};
				this.xPos = 3;
				return;
			case 4:			//Z
				this.piece = new int[][] {{1,1,0}, {0,1,1}};
				this.xPos = 3;
				return;	
			case 5:			//J
				this.piece = new int[][] {{0,1}, {0,1}, {1,1}};
				this.xPos = 4;
				return;
			case 6:			//L
				this.piece = new int[][] {{1,0}, {1,0}, {1,1}};
				this.xPos = 4;
				return;
		}
	}
	
	/*public boolean checkDown(){
		boolean empty = true;
		for(int i = piece.length -1; i >= 0; i--){
			for(int j =0; j < piece[i].length; j++){
				if(piece[i][j] != 0 && ){
					
				}
			}
		}
		return empty;
	}*/
	
	//public boolean checkRotate(){}
	
}
