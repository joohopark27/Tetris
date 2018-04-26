package org.joohopark;

public class Clock {
    
	private JPTetris tetris;
	
    private int ticks,
    			lastFall,
    			lastInput;
    private long lastUpdate,
    			 now,
                 lastTimer;
    private double delta;
    private static double nsPerTick = 1000000000D / 60D;
    
    public Clock(JPTetris tetris){
        
    	this.tetris = tetris;
    	
        this.ticks = 0;
        this.lastFall = 0;
        this.lastInput = 0;
        this.lastUpdate = System.nanoTime();
        this.lastTimer = System.currentTimeMillis();
        this.delta = 0f;
        
    }
    
    public boolean timer(){

        now = System.nanoTime();
        delta += (now - lastUpdate) / nsPerTick;
        lastUpdate = now;
        boolean shouldRender = false;
        
        if(delta >= 1){
        	lastInput--;
        	if(lastInput < 0){
        		lastInput = 0;
        	}
        	lastFall++;
        	tick();
        	delta--;
        	shouldRender = true;
        }
        
        
        if (System.currentTimeMillis() - lastTimer > 1000){
        	tetris.printGameStatus();
      	  	System.out.println("ticks: "+ ticks);
      	  	lastTimer += 1000;
      	  	ticks = 0;
        }
        
        return shouldRender;
    }
    
    private void tick(){
        ticks++;
    }
    
    public boolean inputCooldown(){
    	if(lastInput <= 0){
    		lastInput = 10;
    		return true;
    	}else{
    		return false;
    	}
    }
    
    //checks if a piece can fall
    public boolean gravity(double gravity){
    	if(lastFall * gravity >= 1){
    		resetGravity();
    		return true;
    	}
    	return false;
    }
    
    public void resetGravity(){
    	lastFall = 0;
    }
    
    public static final float getTime(){
        return (System.nanoTime() / 1000000);
    }
    
}
