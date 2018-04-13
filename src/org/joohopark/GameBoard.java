package org.joohopark;

public class GameBoard {
	
	private static final int ySIZE = 24;
	private static final int xSIZE = 10;
	private int[][] tile = new int[ySIZE][xSIZE];
	
	public GameBoard(){
		
	}
	
	public boolean isFilled(int y, int x){
		if(tile[y][x] != 0){
			return true;
		}
		return false;
	}
	
	public int[] checkFilled(){
		int[] rows= new int[ySIZE];
		
		for(int i =0; i < ySIZE; i++){
			boolean isFilled = true;
			for(int j = 0; j < xSIZE; j++){
				if(tile[i][j] == 0){
					isFilled = false;
					break;
				}
			}
			if(isFilled){
				rows[i] = 1;;
			}
		}
		return rows;
	}
		
}
