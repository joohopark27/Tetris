package org.joohopark;

public class JPTetris {
	
	private GameBoard space;
	private GameBoard color;
	private Piece nextPiece;
	
	public Piece currentPiece;
	
	private boolean isGameOver = false;
	
	public JPTetris(){

		this.space = new GameBoard(this);
		this.color = new GameBoard(this);
		this.currentPiece = new Piece(this, this.space, 6);
		
	}
	
	//public void init(){}
	
	public void run(){
		
		while(!isGameOver){
			
			for(int i = 0; i < space.tile.length; i++){
			    if(space.rowFilled(i, space)){
			    	
			    }
			}
			
		}
		
	}
	
	public static void main(String[] args){
	    
		JPTetris game = new JPTetris();
		
		game.space.showBoard(game.currentPiece);
		
	}
	
}
