package org.joohopark;

public class JPTetris {
	
	private GameBoard space;
	private GameBoard color;
	private Piece nextPiece;
	
	public Piece currentPiece;
	
	private boolean isGameOver = false;
	
	private int level,
	            score;
    
	private enum scoreReason {
	    SOFTDROP, HARDDROP, LINECLEAR;
	}
	
	public JPTetris(){

		this.space = new GameBoard(this);
		this.color = new GameBoard(this);
		this.currentPiece = new Piece(this, (int)(Math.random() * 7));
		
	}
	
	public void init(){
	    
	    nextPiece = new Piece(this, (int)(Math.random() * 7));
	    
	    score = 0;
	    level = 0;
	    
	}
	
	public int score(scoreReason reason, int lines){
	    int points = 0;
	    
	    switch(reason) {
	        case HARDDROP://2 point per line dropped
	            points += 1 * lines;
	        case SOFTDROP://1 points per line dropped
	            points += 1 * lines;
	            break;
	        case LINECLEAR:// level n: 1 line: 40 * (n + 1),	two line: 100 * (n + 1)	   three line: 300 * (n + 1)	Tetris: 1200 * (n + 1)
	            points = 1;
	        	switch(lines) {
	            	case 1:
		                points *= 40 * (level + 1);
	            		break;
	            	case 4:
	            		points *= 4;
	            	case 3:
	            		points *= 3;
	            	case 2:
	            		points *= 100 * (level + 1);
	            		break;
	            	default:
	            		System.out.println("bug in score system");
	            }
	    }
	    
	    return points;
	    
	}
	
	public void run(){
		
		init();
		
		while(!isGameOver){

			space.showBoard(currentPiece);
			
			try {
				Thread.sleep(100);
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
				
				int linesCleared = 0;
				for(int i = 4; i < space.tile.length; i++){
					if(space.rowFilled(i)){
						System.out.println(i);
						linesCleared++;
					}
				}
				
				if(linesCleared != 0){
				    score(scoreReason.LINECLEAR, linesCleared);
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
