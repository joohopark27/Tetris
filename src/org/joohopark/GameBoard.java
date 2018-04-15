package org.joohopark;

public class GameBoard {
	
	private static final int ySIZE = 24;
	private static final int xSIZE = 10;
	public int[][] tile = new int[ySIZE][xSIZE];
	
	private JPTetris tetris;
	
	public GameBoard(JPTetris tetris){
		
		this.tetris = tetris;

	}
	
	public void showBoard(Piece piece){
		
	    System.out.println();
	    
	    for(int i = 0; i < tile.length; i++){
	    	boolean yPosInrange = (piece.yPos + piece.height > i && piece.yPos <= i);
	    	
	        for(int j = 0; j < tile[i].length; j++){
	        	
		    	boolean xPosInrange = (j - piece.xPos >= 0 && j - piece.xPos < piece.width);
		    	int block;
		    	
		    	if(yPosInrange && xPosInrange){
		    		block = piece.getPart(j - piece.xPos, i - piece.yPos);
	        	}else{
	        		block = 0;
	        	}
		    	
	        	if(block != 0){
	        		System.out.print(block);
	        	}else{
	        		System.out.print(tile[i][j]);
	        	}
	        }
	        System.out.println();
	    }
	    
	}

	//checks for one tile
	public boolean isFilled(int y, int x){
		if(tile[y][x] != 0){
			return true;
		}
		return false;
	}
	
	//checks if whole lane is filled
	public boolean rowFilled(int row){
		for(int x: this.tile[row]){
		    if(!this.isFilled(row, x)){
		        return false;
		    }
		}
		return true;
	}
	
	//return true if gameover
	public boolean checkGameOver(){
		for(int x: this.tile[3]){
		    if(this.isFilled(3, x)){
		    	System.out.println("game over");
		        return true;
		    }
		}
		return false;
	}
	
	
	public void addToBoard(Piece piece){
		for(int i = 0; i < piece.height; i++){
			for(int j = 0; j < piece.width; j++){
				if(piece.getPart(j, i) != 0){
					this.tile[piece.yPos + i][piece.xPos + j] = piece.getPart(j, i);
				}
			}
		}
	}
	
}
