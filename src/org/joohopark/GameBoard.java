package org.joohopark;

public class GameBoard {
	
	private static final int ySIZE = 10;
	private static final int xSIZE = 24;
	public int[][] tile = new int[ySIZE][xSIZE];
	
	public GameBoard(){
		
		for(int[] y: tile){
			for(int x: y){
				x = 1;
			}
		}
		
	}
	
	public static void main(String[] args){
		
		GameBoard board = new GameBoard();
		
		for(int[] y: board.tile){
			for(int x: y){
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
	}
}
