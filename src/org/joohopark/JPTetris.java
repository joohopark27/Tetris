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

			nextPiece = new Piece(this, this.space, (int)(Math.random() * 7));

			space.showBoard(currentPiece);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(currentPiece.isFalling){
				currentPiece.yPos += 1;
				currentPiece.checkDown();
			}else{

				isGameOver = true;
				space.addToBoard(currentPiece);
				
				if(space.checkGameOver()){
					isGameOver = true;
				}
				
				for(int i = 0; i < space.tile.length; i++){
					if(space.rowFilled(i)){
						System.out.println(i);
					}
				}
				currentPiece = nextPiece;
				nextPiece = new Piece(this, this.space, (int) Math.random() * 7);
			}
		}
	}
	
	public static void main(String[] args){
	    
		JPTetris game = new JPTetris();
		
		for(int i = 0; i < game.space.tile[3].length; i++){
			game.space.tile[15][i] = 1;
		}
		
		game.run();
		System.out.println("done");
		
	}
	
}
