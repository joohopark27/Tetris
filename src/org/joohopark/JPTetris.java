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
		this.currentPiece = new Piece(this, (int)(Math.random() * 7));
		
	}
	
	//public void init(){}
	
	public void run(){
		
		nextPiece = new Piece(this, (int)(Math.random() * 7));
		
		while(!isGameOver){

			space.showBoard(currentPiece);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(currentPiece.isFalling){
				currentPiece.yPos += 1;
				currentPiece.checkDown(space);
			}else{ //if piece has stopped moving
				
				space.addToBoard(currentPiece);
				
				if(space.checkGameOver()){
					isGameOver = true;
				}
				
				for(int i = 5; i < space.tile.length; i++){
					if(space.rowFilled(i)){
						System.out.println(i);
					}
				}
				
				currentPiece = nextPiece;
				nextPiece = new Piece(this, (int) (Math.random() * 7));
				currentPiece.checkDown(space);
			}
		}
	}
	
	public static void main(String[] args){
	    
		JPTetris game = new JPTetris();
		
		game.run();
		System.out.println("done");
		
	}
	
}
