package org.joohopark;

public class GameBoard {
	
	private static final int ySIZE = 24;
	private static final int xSIZE = 10;
	public int[][] tile = new int[ySIZE][xSIZE];
	
	private JPTetris tetris;
	
	public GameBoard(JPTetris tetris){
		
		this.tetris = tetris;

	}
	
	public boolean isFilled(int y, int x){
		if(tile[y][x] != 0){
			return true;
		}
		return false;
	}
	
	public void showBoard(Piece piece){
	    
	    for(int i = 0; i < tile.length; i++){
	    	boolean yPosInrange = (piece.yPos >= i && piece.yPos - piece.height < i);
	        for(int j = 0; j < tile[i].length; j++){
		    	boolean xPosInrange = (j - piece.xPos >= 0 && j - piece.xPos < piece.width);
		    	int block;
		    	if(yPosInrange && xPosInrange){
		    		block = piece.getPart(j - piece.xPos, piece.yPos - i);
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
	    System.out.println();
	    
	}
	
	public boolean rowFilled(int row, GameBoard board){
		for(int x: this.tile[row]){
		    if(!board.isFilled(row, x)){
		        return false;
		    }
		}
		return true;
	}
	
	public void addToBoard(Piece piece){
		
	}
	
}
