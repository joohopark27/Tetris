package org.joohopark;

public class Tetris {
	
	private GameBoard space;
	private GameBoard color;
	public static Tetris game;
	
	public Tetris(){
	    
		this.space = new GameBoard();
		this.color = new GameBoard();
	    
	}
	
	public static void main(String[] args){
	    
		game = new Tetris();
		
		for(int i = 0; i < game.space.tile[3].length; i++){
		    game.space.tile[3][i] = 1;
		}
		
		game.space.showBoard();
		
		for(int i = 0; i < game.space.tile.length; i++){
		    System.out.println(game.space.rowFilled(i, game.space));
		}
	}
	
	//public void init(){}
	
	public void run(){
	      
	}
	
}
