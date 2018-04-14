package org.joohopark;

public class JPTetris {
	
	private GameBoard space;
	private GameBoard color;
	private Piece currentPiece;
	
	private boolean isGameOver = false;
	
	public JPTetris(){
	    
		this.space = new GameBoard(this);
		this.color = new GameBoard(this);
	    
		
	}
	
	//public void init(){}
	
	/*public void run(){
		
		while(!isGameOver){
			
			
			
		}
		
	}*/
	
	public static void main(String[] args){
	    
		JPTetris game = new JPTetris();
		
		
		for(int i = 0; i < game.space.tile[3].length; i++){
		    game.space.tile[3][i] = 1;
		}
		
		game.space.showBoard();
		
		for(int i = 0; i < game.space.tile.length; i++){
		    System.out.println(game.space.rowFilled(i, game.space));
		}
	}
	
}
