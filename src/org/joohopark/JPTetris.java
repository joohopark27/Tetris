package org.joohopark;

import java.io.IOException;

public class JPTetris{
	
	private GameBoard space;
	private Piece nextPiece;
	private Clock time;
	private Screen screen;
	private Input keyboard;
	private SpriteSheet tile;
	
	public Piece currentPiece;
	
	private boolean isRunning;
	
	private int level,
	            score;
	private double gravity;
    
	private enum scoreReason {
	    SOFTDROP, HARDDROP, LINECLEAR;
	}
	
	public JPTetris() throws IOException{
        
		this.space = new GameBoard(this);
		this.currentPiece = new Piece(this, (int)(Math.random() * 7));
		keyboard = new Input();
		tile = new SpriteSheet();
		screen = new Screen(tile);
		
	}
	
	public void init(){

		this.time = new Clock();
	    nextPiece = new Piece(this, (int)(Math.random() * 7));
	    
	    screen.getFrame().addKeyListener(keyboard);
	    
	    isRunning = true;
	    score = 0;
	    gravity = 1D / 120D;
	    level = 0;
	    
	}
	
	public void run(){
		
		init();
		
		while(isRunning){
            
            if(time.timer()){
            	update();
            }
		}
	}

	public void update(){
		
		screen.updateScreen(space.getBoard(currentPiece));
		
	    space.getBoard(currentPiece);
	    
	    if(time.gravity(gravity)){
	    	fall();
	    }
	    
	}
	
	public void fall(){
		
		if(currentPiece.checkDown(space, currentPiece.yPos)){
			currentPiece.yPos += 1;
		}else{ //if piece has stopped moving
			currentPiece.isFalling = false;
			endFall();
		}
		
	}
	
	public void endFall(){
		
		space.addToBoard(currentPiece);
		
		int linesCleared = 0;
		for(int i = 4; i < space.tile.length; i++){
			if(space.rowFilled(i)){
				System.out.println(i);
				linesCleared++;
			}
		}
		
		if(linesCleared != 0){
		    score += score(scoreReason.LINECLEAR, linesCleared);
		}
		
		currentPiece = nextPiece;
		nextPiece = new Piece(this, (int) (Math.random() * 7));
		
		if(space.checkGameOver()){
			isRunning = false;
		}
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
            }
	    }
	    
	    return points;
	    
	}
	
	public static void main(String[] args) throws IOException{
	    
		JPTetris game = new JPTetris();
		
		game.run();
		System.out.println("done");
		
	}
	
}
