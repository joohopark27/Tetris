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
	
	public void showBoard(){
	    
	    for(int[] y: tile){
	        for(int x: y){
	            System.out.print(x);
	        }
	        System.out.println();
	    }
	    
	}
	
	public boolean rowFilled(int row, GameBoard board){
		for(int x: this.tile[row]){
		    if(!board.isFilled(row, x)){
		        return false;
		    }
		}
		return true;
	}
	
	public void createPiece(Piece piece){
		
		
		
	}
		
}
